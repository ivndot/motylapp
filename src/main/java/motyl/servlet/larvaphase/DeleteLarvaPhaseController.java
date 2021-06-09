package motyl.servlet.larvaphase;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.dao.LarvaPhaseDAO;

/**
 * Servlet implementation class DeleteLarvaPhaseController
 */
@WebServlet("/delete_larva.controller")
public class DeleteLarvaPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id species
		String id = request.getParameter("id");
		
		LarvaPhaseDAO larvaphasedao = null;
		
		try {
			//execute delete larva lote
			larvaphasedao = new LarvaPhaseDAO();
			larvaphasedao.deleteLarvaLote(Integer.parseInt(id));

			RequestDispatcher rd = request.getRequestDispatcher("larva-phase");
			rd.forward(request, response);
			
		} catch (Exception e) {

			request.setAttribute("deleteMessage", "No se puede eliminar este elemento");
			
			RequestDispatcher rd = request.getRequestDispatcher("larva-phase");
			rd.forward(request, response);

			e.printStackTrace();
		}finally {
			
			if(larvaphasedao!=null) larvaphasedao.closeConnection(); // close conexion
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
