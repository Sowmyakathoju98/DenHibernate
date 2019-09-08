package com.virtusa.denorm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.denorm.entity.CustomerDetail;
import com.virtusa.denorm.entity.LoginDetail;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDetail login = new LoginDetail(username, password);
		ShoppingService service = new ShoppingService();
		if ((username.equalsIgnoreCase("admin@gmail.com")) && (password.equals("admin"))) {
			session.setAttribute("cid","Admin");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminController");
			dispatcher.forward(request, response);
		} else {
			try {
				List<CustomerDetail> customer = service.doLogin(login);
				if (customer == null) {
					request.setAttribute("buynowid", "Please insert correct userName and password:");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login.jsp");
					dispatcher.forward(request, response);
				} else if (customer != null) {
					request.setAttribute("username", customer);
					System.out.println(customer.get(0).getCustomerName());
					session.setAttribute("name", customer.get(0).getCustomerName());
					session.setAttribute("cid", customer.get(0).getCustomerId());
					RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePageController");
					dispatcher.forward(request, response);
				}
			} catch (ShoppingException e) {
				e.printStackTrace();
			}
		}

	}
}
