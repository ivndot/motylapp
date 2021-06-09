package motyl.servlet.larvaphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.dao.LarvaPhaseDAO;
import motyl.dao.SpeciesDAO;
import motyl.valueobject.EggPhaseValueObject;
import motyl.valueobject.LarvaPhaseValueObject;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class SearchLarvaPhaseController
 */
@WebServlet("/search_larva.controller")
public class SearchLarvaPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//criteria
		String criteria = request.getParameter("criteria");
		//id
		String id = request.getParameter("id");
		
		LarvaPhaseDAO larvaphasedao = null;
		EggPhaseDAO eggphasesdao = null;
		
		try {
			larvaphasedao = new LarvaPhaseDAO();
			
			//criteria is set
			if(criteria != null) {
				//execute search by criteria to modify larva phase
				ArrayList<LarvaPhaseValueObject> larvaPhaseList = larvaphasedao.searchByCriteria(criteria.toLowerCase());
				
				request.setAttribute("larvaPhaseList", larvaPhaseList);
				RequestDispatcher rd = request.getRequestDispatcher("larva.jsp");
				
				rd.forward(request, response);
			}
			
			//id is set
			if(id != null) {
				
				//execute search by id to modify larva phase
				LarvaPhaseValueObject larvaphase = larvaphasedao.searchById(Integer.parseInt(id));
				
				//execute getAllEggsLotes from DAO
				eggphasesdao = new EggPhaseDAO();
				ArrayList<EggPhaseValueObject> eggPhaseList = eggphasesdao.getAllEggsLotes();
				
				request.setAttribute("eggPhaseList", eggPhaseList);
				request.setAttribute("larvaphase", larvaphase);				
				RequestDispatcher rd = request.getRequestDispatcher("edit_larva.jsp");
				
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(eggphasesdao!=null) eggphasesdao.closeConnection(); // close conexion
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
