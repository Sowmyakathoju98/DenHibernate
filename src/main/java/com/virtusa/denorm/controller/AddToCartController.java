package com.virtusa.denorm.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.denorm.entity.CustomerDetail;
import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.entity.ShoppingCart;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;


/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String pId = request.getParameter("pid");
		int productId = Integer.parseInt(pId);
		Object customerId = session.getAttribute("cid");
		if(customerId!=null) {
			int custId=(Integer)customerId;
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ShoppingService service = new ShoppingService();
		Date date = new Date();
		String cartDate = sdf.format(date);
		ProductDetail product = new ProductDetail(productId);
		ShoppingCart cart = new ShoppingCart( product, custId, cartDate);
		try {
			int id = service.doAddToCart(cart);
			if (id != 0) {
				request.setAttribute("cartId", id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/HomePage.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
		}else {
			request.setAttribute("addToCart","Please Login to add the products to cart");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login.jsp");
			dispatcher.forward(request, response);
		
		}
	}
}
