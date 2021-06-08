package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.SpeciesValueObject;

public class SpeciesDAO extends DataAccessObject {

	public SpeciesDAO() throws ClassNotFoundException, SQLException {
		super();
	}

	// GET ALL THE SPECIES
	public ArrayList<SpeciesValueObject> getAllSpecies() throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		SpeciesValueObject species = null;
		ArrayList<SpeciesValueObject> speciesList = new ArrayList<SpeciesValueObject>();

		// query
		String sql = "SELECT especie.*, plantahospedera.nombre_planta FROM especie "
				+ "INNER JOIN plantahospedera ON especie.id_planta=plantahospedera.id_planta";

		try {

			ps = prepareStatement(sql); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				species = new SpeciesValueObject();

				species.setId(rs.getInt("id_especie"));
				species.setCientificName(Utility.upperCaseFirstLetter(rs.getString("nombre_cientifico")));
				species.setCommonName(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				species.setColor(Utility.upperCaseFirstLetter(rs.getString("color_especie")));
				species.setSize(Utility.upperCaseFirstLetter(rs.getString("tamano_especie")));
				species.setFood(rs.getBoolean("tipo_alimentacion") == false ? 0 : 1);
				species.setIdPlant(rs.getInt("id_planta"));
				species.setImg(rs.getString("imagen_especie"));
				species.setNamePlant(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));

				speciesList.add(species);
			}

			return speciesList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param specie
	 * @throws DAOInitializationException
	 */
	public void insertSpecie(SpeciesValueObject specie) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "INSERT INTO especie (nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)"; // query

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setString(1, specie.getCientificName());
			ps.setString(2, specie.getCommonName());
			ps.setString(3, specie.getColor());
			ps.setString(4, specie.getSize());
			ps.setBoolean(5, specie.getFood() == 0 ? false : true);
			ps.setInt(6, specie.getIdPlant());
			ps.setString(7, specie.getImg());

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param specie
	 * @param img
	 * @throws DAOInitializationException
	 */
	public void updateSpecie(SpeciesValueObject specie)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		String sql  = "UPDATE especie SET " + "nombre_cientifico=?, nombre_comun=?, color_especie=?, tamano_especie=?, "
				+ "tipo_alimentacion=?, id_planta=? WHERE id_especie=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setString(1, specie.getCientificName());
			ps.setString(2, specie.getCommonName());
			ps.setString(3, specie.getColor());
			ps.setString(4, specie.getSize());
			ps.setBoolean(5, specie.getFood() == 0 ? false : true);
			ps.setInt(6, specie.getIdPlant());
			ps.setInt(7, specie.getId());

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param id
	 * @throws DAOInitializationException
	 */
	public SpeciesValueObject searchById(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		SpeciesValueObject species = null;

		// query
		String sql = "SELECT especie.*, plantahospedera.nombre_planta FROM especie "
				+ "INNER JOIN plantahospedera ON especie.id_planta=plantahospedera.id_planta"
				+ " WHERE especie.id_especie=?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setInt(1, id); // id specie

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			if (rs.next()) {

				// new species object
				species = new SpeciesValueObject();

				species.setId(rs.getInt("id_especie"));
				species.setCientificName(Utility.upperCaseFirstLetter(rs.getString("nombre_cientifico")));
				species.setCommonName(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				species.setColor(Utility.upperCaseFirstLetter(rs.getString("color_especie")));
				species.setSize(Utility.upperCaseFirstLetter(rs.getString("tamano_especie")));
				species.setFood(rs.getBoolean("tipo_alimentacion") == false ? 0 : 1);
				species.setIdPlant(rs.getInt("id_planta"));
				species.setImg(rs.getString("imagen_especie"));
				species.setNamePlant(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));
			}

			return species;

		} finally {
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param criteria
	 * @throws DAOInitializationException
	 */
	public ArrayList<SpeciesValueObject> searchByCriteria(String criteria)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		SpeciesValueObject species = null;
		ArrayList<SpeciesValueObject> speciesList = new ArrayList<SpeciesValueObject>();

		// query
		String sql = "SELECT especie.*, plantahospedera.nombre_planta FROM especie"
				+ " INNER JOIN plantahospedera ON especie.id_planta=plantahospedera.id_planta"
				+ " WHERE especie.nombre_comun LIKE ? OR especie.nombre_cientifico LIKE ?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setString(1, "%" + criteria + "%"); // common
			ps.setString(2, "%" + criteria + "%"); // cientific

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				species = new SpeciesValueObject();

				species.setId(rs.getInt("id_especie"));
				species.setCientificName(Utility.upperCaseFirstLetter(rs.getString("nombre_cientifico")));
				species.setCommonName(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				species.setColor(Utility.upperCaseFirstLetter(rs.getString("color_especie")));
				species.setSize(Utility.upperCaseFirstLetter(rs.getString("tamano_especie")));
				species.setFood(rs.getBoolean("tipo_alimentacion") == false ? 0 : 1);
				species.setIdPlant(rs.getInt("id_planta"));
				species.setImg(rs.getString("imagen_especie"));
				species.setNamePlant(Utility.upperCaseFirstLetter(rs.getString("nombre_planta")));

				speciesList.add(species);
			}

			return speciesList;

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
	public void deleteSpecie(int id)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		
		String sql  = "DELETE FROM especie WHERE id_especie=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, id);

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}

}
