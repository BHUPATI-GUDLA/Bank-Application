package com.bank.servlet;

import com.bank.jdbc.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verify_user")
public class verify_user extends HttpServlet {



	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			connection c1 = new connection();
			
			data_store ds = new data_store();
			
			String username = request.getParameter("username");
			String acc_number = request.getParameter("Account_number");
			String password = request.getParameter("password");
			
			HttpSession session=request.getSession();
			session.setAttribute("uname",username);  
			session.setAttribute("acc_number",acc_number);  
			
			int key = 8;
			
			String temp = c1.searchRecord(username,acc_number);
			String decrypt_password = c1.decrypt(temp ,key);
			
			
			
			
			System.out.println(temp);
			System.out.println(password);
			System.out.println(decrypt_password);
			
			if(decrypt_password.equals(password)) {
				
//				request.setAttribute("username", username);
				RequestDispatcher rd =request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
				
			}
			else {
				response.sendRedirect("login.html");
				
			}			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
//	public void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String amount = (String) request.getParameter("amount");
//		
//		request.setAttribute("amount", amount);
//		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
//		rd.forward(request, response);
//		
//		
//	}

}
