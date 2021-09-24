package com.bank.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.jdbc.connection;

@WebServlet("/display_balance")
public class display_balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public display_balance() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String balance = request.getParameter("amount");
		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("uname");
		int acc_number = Integer.parseInt((String) session.getAttribute("acc_number"));
		
		
		
		
		
		
		try {
			connection c = new connection();
			
			int bal = Integer.parseInt(c.show_balance(username));
			bal = bal + Integer.parseInt(balance);
			String b = String.valueOf(bal);
			c.updateRecord(username, b);
			
			c.mini_statement_insert(username,acc_number, "Deposit", Integer.parseInt(balance));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("user_display", username);
		request.setAttribute("balance", balance);
		RequestDispatcher rd = request.getRequestDispatcher("Deposit_show_balance.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
