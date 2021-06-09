package motyl.servlet.larvaphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.LarvaPhaseDAO;
import motyl.valueobject.LarvaPhaseValueObject;

/**
 * Servlet implementation class LarvaPhase
 */
@WebServlet("/larva-phase")
public class LarvaPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LarvaPhaseDAO larvaphasedao = null;
		
		try {
			//execute getAllLarvaPhase from DAO
			larvaphasedao = new LarvaPhaseDAO();
			ArrayList<LarvaPhaseValueObject> larvaPhaseList = larvaphasedao.getAllLarvaLotes();

			request.setAttribute("larvaPhaseList", larvaPhaseList);

			RequestDispatcher rd = request.getRequestDispatcher("larva.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

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
