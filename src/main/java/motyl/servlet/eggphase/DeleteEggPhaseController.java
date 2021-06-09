package motyl.servlet.eggphase;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.dao.SpeciesDAO;

/**
 * Servlet implementation class DeleteEggPhaseController
 */
@WebServlet("/delete_egg.controller")
public class DeleteEggPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//id species
		String id = request.getParameter("id");
		
		EggPhaseDAO eggphasedao = null;
		
		try {
			//execute delete Specie
			eggphasedao = new EggPhaseDAO();
			eggphasedao.deleteEggLote(Integer.parseInt(id));

			RequestDispatcher rd = request.getRequestDispatcher("egg-phase");
			rd.forward(request, response);
			
		} catch (Exception e) {

			request.setAttribute("deleteMessage", "No se puede eliminar este elemento");
			
			RequestDispatcher rd = request.getRequestDispatcher("egg-phase");
			rd.forward(request, response);

			e.printStackTrace();
		}finally {
			
			if(eggphasedao!=null) eggphasedao.closeConnection(); // close conexion
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
