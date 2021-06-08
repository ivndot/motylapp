package motyl.servlet.species;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.SpeciesDAO;

/**
 * Servlet implementation class DeleteSpeciesController
 */
@WebServlet("/delete_species.controller")
public class DeleteSpeciesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id species
		String id = request.getParameter("id");
		
		SpeciesDAO speciesdao = null;
		
		try {
			//execute delete Specie
			speciesdao = new SpeciesDAO();
			speciesdao.deleteSpecie(Integer.parseInt(id));

			RequestDispatcher rd = request.getRequestDispatcher("species");
			rd.forward(request, response);
			
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
