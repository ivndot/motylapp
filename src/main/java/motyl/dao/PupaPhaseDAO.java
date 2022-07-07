package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.PupaPhaseValueObject;

public class PupaPhaseDAO extends DataAccessObject{

	public PupaPhaseDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	// GET ALL THE PUPA LOTES
	public ArrayList<PupaPhaseValueObject> getAllPupaLotes() throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		PupaPhaseValueObject pupaphase = null;
		ArrayList<PupaPhaseValueObject> pupaphaseList = new ArrayList<PupaPhaseValueObject>();

		// query
		String sql = "SELECT fase_pupa.*, especie.nombre_comun, especie.imagen_especie\n"
				+ "FROM fase_pupa INNER JOIN fase_larva ON fase_pupa.id_lotelarva=fase_larva.id_lotelarva\n"
				+ "INNER JOIN fase_huevo ON fase_larva.id_lotehuevo=fase_huevo.id_lotehuevo\n"
				+ "INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie\n"
				+ "ORDER BY fase_pupa.id_lotepupa ASC";

		try {

			ps = prepareStatement(sql); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				pupaphase = new PupaPhaseValueObject();
				
				pupaphase.setId(rs.getInt("id_lotepupa"));
				pupaphase.setInitPupas(rs.getInt("pupas_iniciales"));
				pupaphase.setInitDate(rs.getDate("inicio_etapa"));
				pupaphase.setEndDate(rs.getDate("fin_etapa"));
				pupaphase.setEndAdults(rs.getInt("adultos_finales"));
				pupaphase.setIdLoteLarva(rs.getInt("id_lotelarva"));
				pupaphase.setCommonNameSpecie(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				pupaphase.setImgSpecie(rs.getString("imagen_especie"));

				pupaphaseList.add(pupaphase);
			}

			return pupaphaseList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}
	

}
