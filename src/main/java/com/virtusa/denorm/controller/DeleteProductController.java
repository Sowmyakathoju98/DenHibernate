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
import com.virtusa.denorm.entity.ProductDetail;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=request.getParameter("productCategory");
		String c=request.getParameter("cid");
		List<ProductDetail> list;
		String productId=request.getParameter("pid");
		ShoppingService service=new ShoppingService();
		
		if(productId==null) {
		List<CategoryDetail> list1;
		try {
			list1 = service.getAllCategory();
			request.setAttribute("CategoryDetail",list1);
			
			System.out.println(list1);
		}catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			try {
				int cid=Integer.parseInt(c);
				CategoryDetail categoryDetail=new CategoryDetail(cid);
				list=service.doListProduct(categoryDetail);
				int pid=Integer.parseInt(productId);
				List<CategoryDetail> list1 = service.getAllCategory();
				request.setAttribute("CategoryDetail",list1);
				request.setAttribute("ProductDetail",list);
				service.doDeleteProduct(pid);
			} catch (ShoppingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/DeleteProduct.jsp");
			dispatcher.include(request, response);	 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productCategory");
		int categoryId=Integer.parseInt(id);
		System.out.println(id.getClass());
		ShoppingService service=new ShoppingService();
		List<ProductDetail> list;
		List<CategoryDetail> list1;
		ProductDetail productDetail=new ProductDetail();
		CategoryDetail categoryDetail=new CategoryDetail(categoryId);
		try {
			list=service.doListProduct(categoryDetail);
			list1 = service.getAllCategory();
			request.setAttribute("CategoryDetail",list1);
			request.setAttribute("ProductDetail",list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/DeleteProduct.jsp");
			dispatcher.forward(request, response);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
