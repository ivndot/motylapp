package motyl.servlet.plants;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.PlantsDAO;
import motyl.dao.SpeciesDAO;
import motyl.valueobject.PlantsValueObject;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class SearchPlantsController
 */
@WebServlet("/search_plants.controller")
public class SearchPlantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//criteria
		String criteria = request.getParameter("criteria");
		//id
		String id = request.getParameter("id");
		
		PlantsDAO plantsdao = null;
		
		try {
			plantsdao = new PlantsDAO();
			
			//criteria is set
			if(criteria != null) {
				//execute search by criteria to modify plant
				ArrayList<PlantsValueObject> plantsList = plantsdao.searchByCriteria(criteria.toLowerCase());
				
				request.setAttribute("plantsList", plantsList);
				RequestDispatcher rd = request.getRequestDispatcher("plants.jsp");
				
				rd.forward(request, response);
			}
			
			//id is set
			if(id != null) {
				
				//execute search by id to modify plant
				PlantsValueObject plant = plantsdao.searchById(Integer.parseInt(id));
				
				request.setAttribute("plant", plant);
				RequestDispatcher rd = request.getRequestDispatcher("edit_plants.jsp");
				
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(plantsdao!=null) plantsdao.closeConnection(); // close conexion
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
