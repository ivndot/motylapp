package motyl.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import motyl.exception.DAOInitializationException;
import motyl.utility.Utility;
import motyl.valueobject.EggPhaseValueObject;
import motyl.valueobject.SpeciesValueObject;

public class EggPhaseDAO extends DataAccessObject{

	public EggPhaseDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	
	// GET ALL THE EGG LOTES
	public ArrayList<EggPhaseValueObject> getAllEggsLotes() throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		EggPhaseValueObject eggPhase = null;
		ArrayList<EggPhaseValueObject> eggPhaseList = new ArrayList<EggPhaseValueObject>();

		// query
		String sql = "SELECT fase_huevo.*, especie.nombre_comun, especie.imagen_especie FROM fase_huevo"
				+ " INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie ORDER BY fase_huevo.id_lotehuevo ASC";

		try {

			ps = prepareStatement(sql); // prepare statement

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				eggPhase = new EggPhaseValueObject();
				
				eggPhase.setId(rs.getInt("id_lotehuevo"));
				eggPhase.setRecolectedEggs(rs.getInt("huevos_recolec"));
				eggPhase.setInitDate(rs.getDate("inicio_etapa"));
				eggPhase.setEndDate(rs.getDate("fin_etapa"));
				eggPhase.setRealDays(rs.getInt("dias_reales"));
				eggPhase.setFinalLarvs(rs.getInt("larvas_finales"));
				eggPhase.setIdSpecie(rs.getInt("id_especie"));
				eggPhase.setCommonNameSpecie( Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				eggPhase.setImgSpecie(rs.getString("imagen_especie"));

				eggPhaseList.add(eggPhase);
			}

			return eggPhaseList;

		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}

	}
	
	/**
	 * 
	 * @param eggPhase
	 * @throws DAOInitializationException
	 */
	public void insertEggLote(EggPhaseValueObject eggPhase) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "INSERT INTO fase_huevo (huevos_recolec, inicio_etapa, fin_etapa, dias_reales, larvas_finales, id_especie)"
				+ " VALUES (?, ?, ?, ?, ?, ?); "; // query

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, eggPhase.getRecolectedEggs());
			ps.setDate(2, eggPhase.getInitDate());
			ps.setDate(3, eggPhase.getEndDate());
			ps.setInt(4, eggPhase.getRealDays());
			ps.setInt(5, eggPhase.getFinalLarvs());
			ps.setInt(6, eggPhase.getIdSpecie());

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}
	
	
	/**
	 * 
	 * @param eggPhase
	 * @throws DAOInitializationException
	 */
	public void updateEggLote(EggPhaseValueObject eggPhase) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "UPDATE fase_huevo SET huevos_recolec=?, inicio_etapa=?, fin_etapa=?, dias_reales=?, "
				+ "larvas_finales=?, id_especie=? WHERE id_lotehuevo=?"; // query

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, eggPhase.getRecolectedEggs());
			ps.setDate(2, eggPhase.getInitDate());
			ps.setDate(3, eggPhase.getEndDate());
			ps.setInt(4, eggPhase.getRealDays());
			ps.setInt(5, eggPhase.getFinalLarvs());
			ps.setInt(6, eggPhase.getIdSpecie());
			ps.setInt(7, eggPhase.getId());

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
	public EggPhaseValueObject searchById(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		EggPhaseValueObject eggphase = null;

		// query
		String sql = "SELECT * FROM fase_huevo WHERE id_lotehuevo=?";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setInt(1, id); // id egglote

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			if (rs.next()) {

				// new species object
				eggphase = new EggPhaseValueObject();

				eggphase.setId(rs.getInt("id_lotehuevo"));
				eggphase.setRecolectedEggs(rs.getInt("huevos_recolec"));
				eggphase.setInitDate(rs.getDate("inicio_etapa"));
				eggphase.setEndDate(rs.getDate("fin_etapa"));
				eggphase.setRealDays(rs.getInt("dias_reales"));
				eggphase.setFinalLarvs(rs.getInt("larvas_finales"));
				eggphase.setIdSpecie(rs.getInt("id_especie"));

			}

			return eggphase;

		} finally {
			closeStatement(ps);
		}

	}

	
	/**
	 * 
	 * @param criteria
	 * @throws DAOInitializationException
	 */
	public ArrayList<EggPhaseValueObject> searchByCriteria(String criteria)
			throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		// Value object and value object list
		EggPhaseValueObject eggphase = null;
		ArrayList<EggPhaseValueObject> eggphaseList = new ArrayList<EggPhaseValueObject>();

		// query
		String sql = "SELECT fase_huevo.*, especie.nombre_comun, especie.imagen_especie FROM fase_huevo"
				+ "	INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie "
				+ "WHERE especie.nombre_comun LIKE ? OR fase_huevo.id_lotehuevo LIKE ?"
				+ "ORDER BY fase_huevo.id_lotehuevo ASC";

		try {

			ps = prepareStatement(sql); // prepare statement
			ps.setString(1, "%" + criteria + "%"); // common
			ps.setString(2, "%" + criteria + "%"); // id lote

			rs = ps.executeQuery(); // query is executed and the result is assigned to rs
			// iterations
			while (rs.next()) {

				// new species object
				eggphase = new EggPhaseValueObject();

				eggphase.setId(rs.getInt("id_lotehuevo"));
				eggphase.setRecolectedEggs(rs.getInt("huevos_recolec"));
				eggphase.setInitDate(rs.getDate("inicio_etapa"));
				eggphase.setEndDate(rs.getDate("fin_etapa"));
				eggphase.setRealDays(rs.getInt("dias_reales"));
				eggphase.setFinalLarvs(rs.getInt("larvas_finales"));
				eggphase.setIdSpecie(rs.getInt("id_especie"));
				eggphase.setCommonNameSpecie( Utility.upperCaseFirstLetter(rs.getString("nombre_comun")));
				eggphase.setImgSpecie(rs.getString("imagen_especie"));

				eggphaseList.add(eggphase);
			}

			return eggphaseList;

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
	public void deleteEggLote(int id) throws SQLException, DAOInitializationException {

		PreparedStatement ps = null;

		String sql = "DELETE FROM fase_huevo WHERE id_lotehuevo=?"; // query;

		try {

			ps = prepareStatement(sql); // prepare statement

			ps.setInt(1, id);

			ps.executeUpdate(); // execute query

		} finally {
			closeStatement(ps);
		}

	}

}
