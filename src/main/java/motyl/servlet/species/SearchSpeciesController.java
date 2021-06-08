package motyl.servlet.species;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class SearchSpecies
 */
@WebServlet("/search_species.controller")
public class SearchSpeciesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//criteria
		String criteria = request.getParameter("criteria");
		//id
		String id = request.getParameter("id");
		
		SpeciesDAO speciesdao = null;
		PlantsDAO plantsdao = null;
		
		try {
			speciesdao = new SpeciesDAO();
			
			//criteria is set
			if(criteria != null) {
				//execute search by criteria to modify specie
				ArrayList<SpeciesValueObject> speciesList = speciesdao.searchByCriteria(criteria.toLowerCase());
				
				request.setAttribute("speciesList", speciesList);
				RequestDispatcher rd = request.getRequestDispatcher("species.jsp");
				
				rd.forward(request, response);
			}
			
			//id is set
			if(id != null) {
				
				//execute search by id to modify specie
				SpeciesValueObject specie = speciesdao.searchById(Integer.parseInt(id));
				
				//execute getAllPlants from DAO
				plantsdao = new PlantsDAO();
				ArrayList<PlantsValueObject> plantsList = plantsdao.getAllPlants();

				request.setAttribute("plantsList", plantsList);
				request.setAttribute("specie", specie);
				
				RequestDispatcher rd = request.getRequestDispatcher("edit_species.jsp");
				
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(speciesdao!=null) speciesdao.closeConnection(); // close conexion
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
