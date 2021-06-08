package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.PlantsValueObject;
import motyl.valueobject.SpeciesValueObject;

public class PlantsDAO extends DataAccessObject{

	public PlantsDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	// GET ALL THE PLANTS
	public ArrayList<PlantsValueObject> getAllPlants() throws SQLException, DAOInitializationException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// Value object and value object list
		PlantsValueObject plants = null;
		ArrayList<PlantsValueObject> plantsList = new ArrayList<PlantsValueObject>();
		
		// query
		String query = "SELECT * FROM plantahospedera";
		
		try {

			ps = prepareStatement(query); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new plants object
				plants = new PlantsValueObject();

				plants.setId(rs.getInt("id_planta"));
				plants.setName(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));
				plants.setLightNeccesity(Utility.upperCaseFirstLetter(rs.getString("necesidad_luz")));
				plants.setImg(rs.getString("imagen_planta"));
				
				plantsList.add(plants);
			}

			return plantsList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

	/**
	 * 
	 * @param plant
	 * @throws DAOInitializationException
	 */
	public void insertPlant(PlantsValueObject plant) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "INSERT INTO plantahospedera (nombre_planta, necesidad_luz, imagen_planta)"
				+ " VALUES (?, ?, ?)"; // query

		try {

			ps = prepareStatement(sql); // prepare statement
			
			ps.setString(1, plant.getName());
			ps.setString(2, plant.getLightNeccesity());
			ps.setString(3, plant.getImg());

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param specie
	 * @throws DAOInitializationException
	 */
	public void updatePlant(PlantsValueObject plant) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		String sql = "UPDATE plantahospedera SET nombre_planta=?, necesidad_luz=? WHERE id_planta=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement
			
			ps.setString(1, plant.getName());
			ps.setString(2, plant.getLightNeccesity());
			ps.setInt(3, plant.getId());

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}
	
	/**
	 * 
	 * @param criteria
	 * @throws DAOInitializationException
	 */
	public ArrayList<PlantsValueObject> searchByCriteria(String criteria)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		PlantsValueObject plants = null;
		ArrayList<PlantsValueObject> plantsList = new ArrayList<PlantsValueObject>();

		// query
		String sql = "SELECT * FROM plantahospedera WHERE nombre_planta LIKE ?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setString(1, "%" + criteria + "%"); // name

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs

			// iterations
			while (rs.next()) {

				// new plants object
				plants = new PlantsValueObject();

				plants.setId(rs.getInt("id_planta"));
				plants.setName(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));
				plants.setLightNeccesity(Utility.upperCaseFirstLetter(rs.getString("necesidad_luz")));
				plants.setImg(rs.getString("imagen_planta"));
				
				plantsList.add(plants);
			}

			return plantsList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}
	
	
	/**
	 * 
	 * @param id
	 * @throws DAOInitializationException
	 */
	public PlantsValueObject searchById(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		PlantsValueObject plants = null;

		// query
		String sql = "SELECT * FROM plantahospedera WHERE id_planta=?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setInt(1, id); // id plant

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			if (rs.next()) {

				// new species object
				plants = new PlantsValueObject();

				plants.setId(rs.getInt("id_planta"));
				plants.setName(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));
				plants.setLightNeccesity(Utility.upperCaseFirstLetter(rs.getString("necesidad_luz")));
				plants.setImg(rs.getString("imagen_planta"));
				
			}

			return plants;

		} finally {
			closeStatement(ps);
		}

	}
	
	
	/**
	 * 
	 * @param id
	 * @throws DAOInitializationException
	 */
	public void deletePlant(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "DELETE FROM plantahospedera WHERE id_planta=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, id);

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}
}
