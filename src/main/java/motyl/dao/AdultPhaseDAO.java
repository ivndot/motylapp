package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.AdultPhaseValueObject;
import motyl.valueobject.PupaPhaseValueObject;

public class AdultPhaseDAO extends DataAccessObject{

	public AdultPhaseDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	
	
	// GET ALL THE ADULTS LOTES
	public ArrayList<AdultPhaseValueObject> getAllAdultLotes() throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		AdultPhaseValueObject adultphase = null;
		ArrayList<AdultPhaseValueObject> adultphaseList = new ArrayList<AdultPhaseValueObject>();

		// query
		String sql = "SELECT fase_adulto.*, especie.nombre_comun, especie.imagen_especie\n"
				+ "FROM fase_adulto INNER JOIN fase_pupa ON fase_adulto.id_lotepupa=fase_pupa.id_lotepupa\n"
				+ "INNER JOIN fase_larva ON fase_pupa.id_lotelarva=fase_larva.id_lotelarva\n"
				+ "INNER JOIN fase_huevo ON fase_larva.id_lotehuevo=fase_huevo.id_lotehuevo\n"
				+ "INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie\n"
				+ "ORDER BY fase_adulto.id_loteadulto ASC;";

		try {

			ps = prepareStatement(sql); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				adultphase = new AdultPhaseValueObject();
				
				adultphase.setId(rs.getInt("id_loteadulto"));
				adultphase.setAdults(rs.getInt("numfinal_adultos"));
				adultphase.setLiberation(rs.getInt("cantidad_liberacion"));
				adultphase.setSanctuary(rs.getInt("cantidad_mariposario"));
				adultphase.setIdLotePupa(rs.getInt("id_lotepupa"));
				adultphase.setCommonNameSpecie(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				adultphase.setImgSpecie(rs.getString("imagen_especie"));

				adultphaseList.add(adultphase);
			}

			return adultphaseList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}

}
