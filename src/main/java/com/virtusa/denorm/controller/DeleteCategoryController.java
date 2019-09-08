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

import com.virtusa.denorm.entity.CategoryDetail;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

/**
 * Servlet implementation class DeleteCategoryController
 */
@WebServlet("/DeleteCategoryController")
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("categoryName");
		ShoppingService service=new ShoppingService();
		
		List<CategoryDetail> list;
		try {
			list = service.getAllCategory();
			request.setAttribute("CategoryDetail",list);
			System.out.println(list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/DeleteCategory.jsp");
			dispatcher.forward(request, response);
			
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productCategory");
		int categoryId=Integer.parseInt(id);
		System.out.println(id.getClass());
		ShoppingService service=new ShoppingService();
		List<CategoryDetail> list;
		CategoryDetail categoryDetail=new CategoryDetail(categoryId);
		try {
			int i=service.doDeleteCategory(categoryDetail);
			list = service.getAllCategory();
			request.setAttribute("CategoryDetail",list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/DeleteCategory.jsp");
			dispatcher.forward(request, response);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
