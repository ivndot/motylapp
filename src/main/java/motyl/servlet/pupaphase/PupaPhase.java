package motyl.servlet.pupaphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.LarvaPhaseDAO;
import motyl.dao.PupaPhaseDAO;
import motyl.valueobject.LarvaPhaseValueObject;
import motyl.valueobject.PupaPhaseValueObject;

/**
 * Servlet implementation class PupaPhase
 */
@WebServlet("/pupa-phase")
public class PupaPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PupaPhaseDAO pupaphasedao = null;
		
		try {
			//execute getAllLarvaPhase from DAO
			pupaphasedao = new PupaPhaseDAO();
			ArrayList<PupaPhaseValueObject> pupaPhaseList = pupaphasedao.getAllPupaLotes();

			request.setAttribute("pupaPhaseList", pupaPhaseList);

			RequestDispatcher rd = request.getRequestDispatcher("pupa.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(pupaphasedao!=null) pupaphasedao.closeConnection(); // close conexion
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
