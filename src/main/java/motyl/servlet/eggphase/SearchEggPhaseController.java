package motyl.servlet.eggphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.dao.PlantsDAO;
import motyl.dao.SpeciesDAO;
import motyl.valueobject.EggPhaseValueObject;
import motyl.valueobject.PlantsValueObject;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class SearchEggPhaseController
 */
@WebServlet("/search_egg.controller")
public class SearchEggPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//criteria
		String criteria = request.getParameter("criteria");
		//id
		String id = request.getParameter("id");
		
		EggPhaseDAO eggphasesdao = null;
		SpeciesDAO speciesdao = null;
		
		try {
			eggphasesdao = new EggPhaseDAO();
			
			//criteria is set
			if(criteria != null) {
				//execute search by criteria to modify egg phase
				ArrayList<EggPhaseValueObject> eggPhaseList = eggphasesdao.searchByCriteria(criteria.toLowerCase());
				
				request.setAttribute("eggPhaseList", eggPhaseList);
				RequestDispatcher rd = request.getRequestDispatcher("egg.jsp");
				
				rd.forward(request, response);
			}
			
			//id is set
			if(id != null) {
				
				//execute search by id to modify egg phase
				EggPhaseValueObject eggphase = eggphasesdao.searchById(Integer.parseInt(id));
				
				//execute getAllSpecies from DAO
				speciesdao = new SpeciesDAO();
				ArrayList<SpeciesValueObject> speciesList = speciesdao.getAllSpecies();
				
				request.setAttribute("speciesList", speciesList);
				request.setAttribute("eggphase", eggphase);				
				RequestDispatcher rd = request.getRequestDispatcher("edit_egg.jsp");
				
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
