package com.virtusa.denorm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.denorm.entity.ProductDetail;

/**
 * Servlet implementation class BuyNowController
 */
@WebServlet("/BuyNowController")
public class BuyNowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyNowController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName=request.getParameter("productName");
		String productImage=request.getParameter("productImage");
		String productDescription=request.getParameter("productDesc");
		float productPrice=Float.parseFloat(request.getParameter("productPrice"));
		ProductDetail productDetail=new ProductDetail(productId, productName, productImage, productPrice, productDescription);
		request.setAttribute("product",productDetail);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BuyNow.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String productName=request.getParameter("productName");
		float quantity=Float.parseFloat(request.getParameter("quantity"));
		float productPrice=Float.parseFloat(request.getParameter("productPrice"));
		float productTotalPrice=productPrice*quantity;
		session.setAttribute("quantity",quantity);
		session.setAttribute("productName", productName);
		session.setAttribute("productPrice", productPrice);
		session.setAttribute("productTotalPrice", productTotalPrice);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Payment.jsp");
		dispatcher.forward(request, response);
		
	}

}
