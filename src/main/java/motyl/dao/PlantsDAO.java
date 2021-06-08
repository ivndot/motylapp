package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.PlantsValueObject;

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
}
