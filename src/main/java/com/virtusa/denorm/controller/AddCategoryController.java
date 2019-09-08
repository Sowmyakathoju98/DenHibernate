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
 * Servlet implementation class AddCategoryController
 */
@WebServlet("/AddCategoryController")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("categoryName");
		ShoppingService service=new ShoppingService();
		
		List<CategoryDetail> list;
		try {
			list = service.getAllCategory();
			request.setAttribute("CategoryDetail",list);
			System.out.println(list);
			System.out.println("Ureke");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/AddCategory.jsp");
			dispatcher.forward(request, response);
			
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=request.getParameter("categoryName");
		ShoppingService service=new ShoppingService();
		
		try {
			int id=service.doAddCategory(name);
			if(id!=0) {
				List<CategoryDetail> list=service.getAllCategory();
				request.setAttribute("CategoryDetail",list);
				System.out.println(list);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/AddCategory.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
