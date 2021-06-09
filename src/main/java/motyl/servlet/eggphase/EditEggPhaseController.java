package motyl.servlet.eggphase;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motyl.dao.EggPhaseDAO;
import motyl.utility.Utility;
import motyl.valueobject.EggPhaseValueObject;

/**
 * Servlet implementation class EditEggPhaseController
 */
@WebServlet("/edit_egg.controller")
public class EditEggPhaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =  Integer.parseInt(request.getParameter("id")) ;
		/* Required */
		String initDate = request.getParameter("initDate");
		int eggsRecolected = Integer.parseInt(request.getParameter("numberEggs"));
		int idSpecie = Integer.parseInt(request.getParameter("specieId"));

		/* NO Required */
		String endDate = request.getParameter("endDate");
		System.out.println("##############################");
		System.out.println("END DATE" + endDate);
		System.out.println("##############################");
		String finalLarvs = request.getParameter("numberLarvas");
		System.out.println("##############################");
		System.out.println("FINAL LARVS" + finalLarvs);
		System.out.println("##############################");
		int realDays = 0;
		if (!initDate.equals("") && !endDate.equals("")) {
			System.out.println("##############################");
			System.out.println("se chinga aqui?");
			System.out.println("##############################");
			realDays = Utility.daysBetweenTwoDates(Date.valueOf(initDate), Date.valueOf(endDate));
		}
		
		// EggPhase object
		EggPhaseValueObject eggLote = new EggPhaseValueObject();
		eggLote.setId(id);
		/* Required */
		eggLote.setInitDate(Date.valueOf(initDate));
		eggLote.setRecolectedEggs(eggsRecolected);
		eggLote.setIdSpecie(idSpecie);
		
		/* NO Required */
		if (!endDate.equals("")) {
			System.out.println("##############################");
			System.out.println("SE PUSO FECHA DE FIN");
			System.out.println("##############################");
			eggLote.setEndDate(Date.valueOf(endDate));

		} else {
			System.out.println("##############################");
			System.out.println("NO SE PUSO FECHA DE FIN");
			System.out.println("##############################");
			eggLote.setEndDate(null);

		}
		if(!finalLarvs.equals("")) {
			System.out.println("##############################");
			System.out.println("SE PUSO LARVAS FINALES");
			System.out.println("##############################");
			eggLote.setFinalLarvs(Integer.parseInt(finalLarvs));

		}else {
			System.out.println("##############################");
			System.out.println("NO SE PUSO LARVAS FINALES");
			System.out.println("##############################");
			eggLote.setFinalLarvs(0);

		}
		
		eggLote.setRealDays(realDays);
		
		// Update data
		EggPhaseDAO eggphasedao = null;

		try {
			// execute insert EggLote
			eggphasedao = new EggPhaseDAO();
			eggphasedao.updateEggLote(eggLote);

			RequestDispatcher rd = request.getRequestDispatcher("egg-phase");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (eggphasedao != null)
				eggphasedao.closeConnection(); // close conexion
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
