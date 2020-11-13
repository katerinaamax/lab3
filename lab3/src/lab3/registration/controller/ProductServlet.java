package lab3.registration.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import lab3.registration.dao.ProductDao;
import lab3.registration.model.Product;

@WebServlet("/register")
public class ProductServlet extends HttpServlet {
	private ProductDao productDao;
	
	public ProductServlet() {
		productDao = new ProductDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Server at: ").append(request.getContextPath());
		RequestDispatcher dispatcher  = request.getRequestDispatcher("WEB-INF/views/productRegister.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String barcode =  request.getParameter("barcode");
		String name = request.getParameter("name");
		String colour = request.getParameter("colour");
		String description = request.getParameter("description");

		Product product = new Product();
		product.setBarcode(Integer.parseInt(barcode));
		product.setName(name);
		product.setColour(colour);
		product.setDescription(description);
		int result = 1;
		
		try {
			result = ProductDao.registerProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result == 1) {
			RequestDispatcher dispatcher  = request.getRequestDispatcher("WEB-INF/views/productDetails.jsp");
			request.setAttribute("barcode", barcode);
			request.setAttribute("name", name);
			request.setAttribute("colour", colour);
			request.setAttribute("description", description);
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher  = request.getRequestDispatcher("WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}