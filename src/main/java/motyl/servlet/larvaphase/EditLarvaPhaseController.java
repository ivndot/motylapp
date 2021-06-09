package motyl.servlet.larvaphase;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.LarvaPhaseDAO;
import motyl.valueobject.LarvaPhaseValueObject;

/**
 * Servlet implementation class EditLarvaPhaseController
 */
@WebServlet("/edit_larva.controller")
public class EditLarvaPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Required */
		int id = Integer.parseInt(request.getParameter("id"));
		int numberLarvas =  Integer.parseInt(request.getParameter("numberLarvas"));
		String initDate = request.getParameter("initDate");
		int idEggLote = Integer.parseInt(request.getParameter("eggLote"));
		
		/* NO Required */
		String changeDate = request.getParameter("leafDate");
		String endDate = request.getParameter("endDate");
		String endPupas = request.getParameter("numberPupas");
		
		// LarvaPhase object
		LarvaPhaseValueObject larvaLote = new LarvaPhaseValueObject();
		
		/* Required */
		larvaLote.setId(id);
		larvaLote.setInitLarvas(numberLarvas);
		larvaLote.setInitDate(Date.valueOf(initDate));
		larvaLote.setIdLoteEgg(idEggLote);
		
		/* NO Required */
		if(!changeDate.equals("")) {
			larvaLote.setChangeDate(Date.valueOf(changeDate));
		}else {
			larvaLote.setChangeDate(null);
		}
		
		if(!endDate.equals("")) {
			larvaLote.setEndDate(Date.valueOf(endDate));
		}else {
			larvaLote.setEndDate(null);
		}
		
		if(!endPupas.equals("") && endPupas !=null) {
			larvaLote.setEndPupas(Integer.parseInt(endPupas));
		}else {
			larvaLote.setEndPupas(0);
		}
		
		// Insert data
		LarvaPhaseDAO larvaphasedao = null;

		try {
			// execute update Larva Lote
			larvaphasedao = new LarvaPhaseDAO();
			larvaphasedao.updateLarvaLote(larvaLote);

			RequestDispatcher rd = request.getRequestDispatcher("larva-phase");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (larvaphasedao != null)
				larvaphasedao.closeConnection(); // close conexion
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
