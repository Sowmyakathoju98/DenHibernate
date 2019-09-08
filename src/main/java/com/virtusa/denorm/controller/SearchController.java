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

import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.service.ShoppingService;


/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchItem = request.getParameter("searchText");
		List<ProductDetail> list=new ArrayList<ProductDetail>();
		ShoppingService service;
		try {
			service = new ShoppingService();
			list = service.doSearch(searchItem);
			System.out.println(list);
			if (list != null) {
				request.setAttribute("list", list);
				System.out.println(list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/HomePage.jsp");
				dispatcher.forward(request, response);
				}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Error.jsp");
				dispatcher.include(request, response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
