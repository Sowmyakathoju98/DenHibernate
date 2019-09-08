package com.virtusa.denorm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

/**
 * Servlet implementation class doDeleteCartItemController
 */
@WebServlet("/DeleteCartItemController")
public class DeleteCartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String cid=request.getParameter("cid");
		int cartId=Integer.parseInt(cid);
		ShoppingService service=new ShoppingService();
		try {
			service.doDeleteCartItem(cartId);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/MyCartController");
			requestDispatcher.forward(request, response);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
