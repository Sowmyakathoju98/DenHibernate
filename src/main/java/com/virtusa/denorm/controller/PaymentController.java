package com.virtusa.denorm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.denorm.entity.CardDetail;
import com.virtusa.denorm.exception.ShoppingException;
import com.virtusa.denorm.service.ShoppingService;


/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardNo = request.getParameter("cardNumber");
		String cardName = request.getParameter("cardHolderName");
		String cardType = request.getParameter("cardType");
		String cardExpiryDate = request.getParameter("Edate");
		String cvv = request.getParameter("cvv");
		long cardNumber = Long.parseLong(cardNo);
		long cvvNumber=Long.parseLong(cvv);
		CardDetail details=new CardDetail(cardNumber,cardName,cardType,cardExpiryDate,cvvNumber);
		ShoppingService service=new ShoppingService();
		try {
			int id=service.doPayment(details);
			if(id!=0) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/BillingPage.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
