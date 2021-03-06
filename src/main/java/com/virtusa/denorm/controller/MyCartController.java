package com.virtusa.denorm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class MyCartController
 */
@WebServlet("/MyCartController")
public class MyCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int customerId = (Integer) session.getAttribute("cid");
		String customerName=(String) session.getAttribute("name");
		ShoppingService service=new ShoppingService();
		List<ShoppingCart> list=null;
		try {
			list=service.viewCart(customerId);
			if(list!=null) {
			session.setAttribute("CartList", list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/ViewCart.jsp");
			dispatcher.forward(request, response);
			}
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
	}

	

}
