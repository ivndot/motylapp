package motyl.servlet.species;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.PlantsDAO;
import motyl.valueobject.PlantsValueObject;
/**
 * Servlet implementation class AddSpecies
 */
@WebServlet("/add-species")
public class AddSpecies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlantsDAO plantsdao = null;
		
		try {
			//execute getAllPlants from DAO
			plantsdao = new PlantsDAO();
			ArrayList<PlantsValueObject> plantsList = plantsdao.getAllPlants();

			request.setAttribute("plantsList", plantsList);

			RequestDispatcher rd = request.getRequestDispatcher("add_species.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(plantsdao!=null) plantsdao.closeConnection(); // close conexion
		}
	}

}
