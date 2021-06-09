package motyl.servlet.eggphase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.dao.SpeciesDAO;
import motyl.valueobject.EggPhaseValueObject;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class Egg
 */
@WebServlet("/egg-phase")
public class EggPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EggPhaseDAO eggphasedao = null;
		
		try {
			//execute getAllEggsPhase from DAO
			eggphasedao = new EggPhaseDAO();
			ArrayList<EggPhaseValueObject> eggPhaseList = eggphasedao.getAllEggsLotes();

			request.setAttribute("eggPhaseList", eggPhaseList);

			RequestDispatcher rd = request.getRequestDispatcher("egg.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {

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
