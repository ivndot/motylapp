package motyl.servlet.plants;

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

import motyl.dao.PlantsDAO;
import motyl.dao.SpeciesDAO;
import motyl.valueobject.PlantsValueObject;

/**
 * Servlet implementation class AddPlantsController
 */
@WebServlet("/add_plants.controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AddPlantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String light = request.getParameter("light");
		String img = request.getPart("img").getSubmittedFileName();
		
		//Plant object
		PlantsValueObject plant = new PlantsValueObject();
		plant.setName(name.toLowerCase());
		plant.setLightNeccesity(light.toLowerCase());
		plant.setImg(img);
		
		//Insert data
		PlantsDAO plantsdao = null;
		
		try {
			//execute insert Plants
			plantsdao = new PlantsDAO();
			plantsdao.insertPlant(plant);
			
			// upload image
			uploadImage(request);

			RequestDispatcher rd = request.getRequestDispatcher("plants");
			rd.forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			if(plantsdao!=null) plantsdao.closeConnection(); // close conexion
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
