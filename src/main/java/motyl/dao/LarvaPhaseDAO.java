package motyl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.EggPhaseValueObject;
import motyl.valueobject.LarvaPhaseValueObject;
import motyl.valueobject.SpeciesValueObject;

public class LarvaPhaseDAO extends DataAccessObject {

	public LarvaPhaseDAO() throws ClassNotFoundException, SQLException {
		super();
	}

	// GET ALL THE LARVA LOTES
	public ArrayList<LarvaPhaseValueObject> getAllLarvaLotes() throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		LarvaPhaseValueObject larvaphase = null;
		ArrayList<LarvaPhaseValueObject> larvaphaseList = new ArrayList<LarvaPhaseValueObject>();

		// query
		String sql = "SELECT fase_larva.*, especie.nombre_comun, especie.imagen_especie\n"
				+ "FROM fase_larva INNER JOIN fase_huevo ON fase_larva.id_lotehuevo=fase_huevo.id_lotehuevo\n"
				+ "INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie ORDER BY fase_larva.id_lotelarva ASC";

		try {

			ps = prepareStatement(sql); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				larvaphase = new LarvaPhaseValueObject();

				larvaphase.setId(rs.getInt("id_lotelarva"));
				larvaphase.setInitLarvas(rs.getInt("larvas_iniciales"));
				larvaphase.setInitDate(rs.getDate("inicio_etapa"));
				larvaphase.setChangeDate(rs.getDate("fecha_cambiohoja"));
				larvaphase.setEndDate(rs.getDate("fin_etapa"));
				larvaphase.setEndPupas(rs.getInt("pupas_finales"));
				larvaphase.setIdLoteEgg(rs.getInt("id_lotehuevo"));
				larvaphase.setCommonNameSpecie(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				larvaphase.setImgSpecie(rs.getString("imagen_especie"));

				larvaphaseList.add(larvaphase);
			}

			return larvaphaseList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}

	/**
	 * 
	 * @param Larva
	 * @throws DAOInitializationException
	 */
	public void insertLarvaLote(LarvaPhaseValueObject larvaPhase) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "INSERT INTO fase_larva (larvas_iniciales, inicio_etapa, fecha_cambiohoja, fin_etapa, pupas_finales, id_lotehuevo)"
				+ "VALUES (?, ?, ?, ?, ?, ?)"; // query

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, larvaPhase.getInitLarvas());
			ps.setDate(2, larvaPhase.getInitDate());
			ps.setDate(3, larvaPhase.getChangeDate());
			ps.setDate(4, larvaPhase.getEndDate());
			ps.setInt(5, larvaPhase.getEndPupas());
			ps.setInt(6, larvaPhase.getIdLoteEgg());

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
	public LarvaPhaseValueObject searchById(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		LarvaPhaseValueObject larvaphase = null;

		// query
		String sql = "SELECT * FROM fase_larva WHERE id_lotelarva=?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setInt(1, id); // id egglote

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			if (rs.next()) {

				// new species object
				larvaphase = new LarvaPhaseValueObject();
				
				larvaphase.setId(rs.getInt("id_lotelarva"));
				larvaphase.setInitLarvas(rs.getInt("larvas_iniciales"));
				larvaphase.setInitDate(rs.getDate("inicio_etapa"));
				larvaphase.setChangeDate(rs.getDate("fecha_cambiohoja"));
				larvaphase.setEndDate(rs.getDate("fin_etapa"));
				larvaphase.setEndPupas(rs.getInt("pupas_finales"));
				larvaphase.setIdLoteEgg(rs.getInt("id_lotehuevo"));

			}

			return larvaphase;

		} finally {
			closeStatement(ps);
		}

	}
	
	/**
	 * 
	 * @param criteria
	 * @throws DAOInitializationException
	 */
	public ArrayList<LarvaPhaseValueObject> searchByCriteria(String criteria)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		LarvaPhaseValueObject larvaphase = null;
		ArrayList<LarvaPhaseValueObject> larvaphaseList = new ArrayList<LarvaPhaseValueObject>();

		// query
		String sql = "SELECT fase_larva.*, especie.nombre_comun, especie.imagen_especie"
				+ " FROM fase_larva INNER JOIN fase_huevo ON fase_larva.id_lotehuevo=fase_huevo.id_lotehuevo"
				+ " INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie WHERE fase_larva.id_lotelarva LIKE"
				+ " ? OR especie.nombre_comun LIKE ? OR fase_huevo.id_lotehuevo LIKE ? ORDER BY fase_larva.id_lotelarva"
				+ " ASC";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setString(1, "%" + criteria + "%"); // id lote
			ps.setString(2, "%" + criteria + "%"); // specie
			ps.setString(3, "%" + criteria + "%"); // id lote egg
			
			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				larvaphase = new LarvaPhaseValueObject();

				larvaphase.setId(rs.getInt("id_lotelarva"));
				larvaphase.setInitLarvas(rs.getInt("larvas_iniciales"));
				larvaphase.setInitDate(rs.getDate("inicio_etapa"));
				larvaphase.setChangeDate(rs.getDate("fecha_cambiohoja"));
				larvaphase.setEndDate(rs.getDate("fin_etapa"));
				larvaphase.setEndPupas(rs.getInt("pupas_finales"));
				larvaphase.setIdLoteEgg(rs.getInt("id_lotehuevo"));
				larvaphase.setCommonNameSpecie(Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				larvaphase.setImgSpecie(rs.getString("imagen_especie"));

				larvaphaseList.add(larvaphase);
			}

			return larvaphaseList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}
	
	/**
	 * 
	 * @param larvaPhase
	 * @throws DAOInitializationException
	 */
	public void updateLarvaLote(LarvaPhaseValueObject larvaPhase) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "UPDATE fase_larva SET larvas_iniciales=?, inicio_etapa=?, fecha_cambiohoja=?, fin_etapa=?"
				+ ", pupas_finales=?, id_lotehuevo=? WHERE id_lotelarva=?"; // query

		try {

			ps = prepareStatement(sql); // prepare statement
			
			ps.setInt(1, larvaPhase.getInitLarvas());
			ps.setDate(2, larvaPhase.getInitDate());
			ps.setDate(3, larvaPhase.getChangeDate());
			ps.setDate(4, larvaPhase.getEndDate());
			ps.setInt(5, larvaPhase.getEndPupas());
			ps.setInt(6, larvaPhase.getIdLoteEgg());
			ps.setInt(7, larvaPhase.getId());
			

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
	public void deleteLarvaLote(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "DELETE FROM fase_larva WHERE id_lotelarva=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, id);

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}
}
