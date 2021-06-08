package motyl.servlet.species;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.SpeciesDAO;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class Species
 */
@WebServlet("/species")
public class Species extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SpeciesDAO speciesdao = null;
		
		try {
			//execute getAllSpecies from DAO
			speciesdao = new SpeciesDAO();
			ArrayList<SpeciesValueObject> speciesList = speciesdao.getAllSpecies();

			request.setAttribute("speciesList", speciesList);

			RequestDispatcher rd = request.getRequestDispatcher("species.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(speciesdao!=null) speciesdao.closeConnection(); // close conexion
		}

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {
		doGet(req, resp);
	};

}
