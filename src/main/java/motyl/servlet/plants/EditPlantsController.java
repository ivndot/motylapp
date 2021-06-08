package motyl.servlet.plants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.PlantsDAO;
import motyl.valueobject.PlantsValueObject;

/**
 * Servlet implementation class EditPlantsController
 */
@WebServlet("/edit_plants.controller")
public class EditPlantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name = request.getParameter("name");
		String light = request.getParameter("light");
		
		//Plant object
		PlantsValueObject plant = new PlantsValueObject();
		plant.setId(id);
		plant.setName(name.toLowerCase());
		plant.setLightNeccesity(light.toLowerCase());
		
		//Insert data
		PlantsDAO plantsdao = null;
		
		try {
			//execute insert Plants
			plantsdao = new PlantsDAO();
			plantsdao.updatePlant(plant);

			RequestDispatcher rd = request.getRequestDispatcher("plants");
			rd.forward(request, response);
			
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
