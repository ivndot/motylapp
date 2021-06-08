package motyl.servlet.species;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class AddSpeciesController
 */
@WebServlet("/add_species.controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AddSpeciesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commonName = request.getParameter("commonName");
		String cientificName = request.getParameter("cientificName");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		int food = Integer.parseInt(request.getParameter("food"));
		int idPlant = Integer.parseInt(request.getParameter("homePlant"));
		String img = request.getPart("img").getSubmittedFileName();
		
		//Specie object
		SpeciesValueObject specie = new SpeciesValueObject();
		specie.setCientificName(cientificName.toLowerCase());
		specie.setCommonName(commonName.toLowerCase());
		specie.setColor(color.toLowerCase());
		specie.setSize(size.toLowerCase());
		specie.setFood(food);
		specie.setIdPlant(idPlant);
		specie.setImg(img);
		
		//Insert data
		SpeciesDAO speciesdao = null;
		
		try {
			//execute insert Specie
			speciesdao = new SpeciesDAO();
			speciesdao.insertSpecie(specie);
			
			// upload image
			uploadImage(request);

			RequestDispatcher rd = request.getRequestDispatcher("species");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(speciesdao!=null) speciesdao.closeConnection(); // close conexion
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

	/*
	 * 
	 * Upload an image
	 * 
	 */
	private void uploadImage(HttpServletRequest request)
			throws IOException, ServletException {
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploadImages";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		Part filePart = request.getPart("img");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : request.getParts()) {
			part.write(uploadPath + File.separator + fileName);
		}
	}

}
