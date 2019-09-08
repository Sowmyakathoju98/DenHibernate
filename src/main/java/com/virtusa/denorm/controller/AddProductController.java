package com.virtusa.denorm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.denorm.entity.CategoryDetail;
import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShoppingService service = new ShoppingService();
		List<CategoryDetail> l = null;
		try {
			l = service.getAllCategory();
			request.setAttribute("l", l);
			System.out.println("get");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AddProduct.jsp");
			dispatcher.forward(request, response);

		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		String productName = request.getParameter("productName");
		String productImage = request.getParameter("productImage");
		String productCategory = request.getParameter("productCategory");
		String productPrice = request.getParameter("productPrice");
		String productDesc = request.getParameter("productDesc");
		String productQuantity = request.getParameter("productQuantity");
		float price = Float.parseFloat(productPrice);
		int stock = Integer.parseInt(productQuantity);
		int categoryId = Integer.parseInt(productCategory);
		CategoryDetail categoryDetail = new CategoryDetail(categoryId);
		ProductDetail productDetail = new ProductDetail(productName, productImage, price, productDesc, stock,
				categoryDetail);
		ShoppingService service = new ShoppingService();
		int id = 0;
		try {
			id = service.doAddProduct(productDetail);
			if (id != 0) {
				List<CategoryDetail> l = service.getAllCategory();
				System.out.println(id);
				request.setAttribute("l", l);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AddProduct.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
