package motyl.servlet.species;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import motyl.dao.SpeciesDAO;
import motyl.valueobject.SpeciesValueObject;

/**
 * Servlet implementation class EditSpecies
 */
@WebServlet("/edit_species.controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EditSpeciesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String commonName = request.getParameter("commonName");
		String cientificName = request.getParameter("cientificName");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		int food = Integer.parseInt(request.getParameter("food"));
		int idPlant = Integer.parseInt(request.getParameter("homePlant"));

		// Specie object
		SpeciesValueObject specie = new SpeciesValueObject();
		specie.setId(id);
		specie.setCientificName(cientificName.toLowerCase());
		specie.setCommonName(commonName.toLowerCase());
		specie.setColor(color.toLowerCase());
		specie.setSize(size.toLowerCase());
		specie.setFood(food);
		specie.setIdPlant(idPlant);

		// Update data
		SpeciesDAO speciesdao = null;

		try {
			// execute update Specie
			speciesdao = new SpeciesDAO();
			speciesdao.updateSpecie(specie);

			RequestDispatcher rd = request.getRequestDispatcher("species");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (speciesdao != null)
				speciesdao.closeConnection(); // close conexion
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
