package com.virtusa.denorm.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		System.out.println("Registration");
		String customerName = request.getParameter("name");
		String customerEmail = request.getParameter("email");
		String customerPassword = request.getParameter("password");
		String customerDOB = request.getParameter("dob");
		String contact = request.getParameter("contact");
		String customerState = request.getParameter("state");
		String customerCity = request.getParameter("city");
		String customerAddress = request.getParameter("address");
		long customerContact = Long.parseLong(contact); 
		CustomerDetail customerDetail = new CustomerDetail(customerName,customerEmail,customerPassword,
			customerDOB,customerAddress,customerContact,customerState,customerCity) ;
		ShoppingService service = new ShoppingService();
		try {
			int id = service.doRegister(customerDetail);
			if (id != 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
	}
}
