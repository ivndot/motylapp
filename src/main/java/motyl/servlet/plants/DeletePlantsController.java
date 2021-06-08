package motyl.servlet.plants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.PlantsDAO;

/**
 * Servlet implementation class DeletePlantsController
 */
@WebServlet("/delete_plants.controller")
public class DeletePlantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id plant
		String id = request.getParameter("id");
		
		PlantsDAO plantsdao = null;
		
		try {
			//execute delete Specie
			plantsdao = new PlantsDAO();
			plantsdao.deletePlant(Integer.parseInt(id));

			RequestDispatcher rd = request.getRequestDispatcher("plants");
			rd.forward(request, response);
			
		} catch (Exception e) {
			
			request.setAttribute("deleteMessage", "No se puede eliminar este elemento");
			
			RequestDispatcher rd = request.getRequestDispatcher("plants");
			rd.forward(request, response);

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
