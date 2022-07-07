package motyl.servlet.adulphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.AdultPhaseDAO;
import motyl.dao.PupaPhaseDAO;
import motyl.valueobject.AdultPhaseValueObject;
import motyl.valueobject.PupaPhaseValueObject;

/**
 * Servlet implementation class AdultPhase
 */
@WebServlet("/adult-phase")
public class AdultPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdultPhaseDAO adultphasedao = null;
		
		try {
			//execute getAllLarvaPhase from DAO
			adultphasedao = new AdultPhaseDAO();
			ArrayList<AdultPhaseValueObject> adultPhaseList = adultphasedao.getAllAdultLotes();

			request.setAttribute("adultPhaseList", adultPhaseList);

			RequestDispatcher rd = request.getRequestDispatcher("adult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(adultphasedao!=null) adultphasedao.closeConnection(); // close conexion
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
