package motyl.servlet.larvaphase;

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
 * Servlet implementation class AddLarvaPhase
 */
@WebServlet("/add-larva")
public class AddLarvaPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EggPhaseDAO eggphasedao = null;
		
		try {
			//execute getAllEggs from DAO
			eggphasedao = new EggPhaseDAO();
			ArrayList<EggPhaseValueObject> eggphaseList = eggphasedao.getAllEggsLotes();

			request.setAttribute("eggphaseList", eggphaseList);

			RequestDispatcher rd = request.getRequestDispatcher("add_larva.jsp");
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
