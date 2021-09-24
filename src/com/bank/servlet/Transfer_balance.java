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

@WebServlet("/Transfer_balance")
public class Transfer_balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Transfer_balance() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String username = request.getParameter("username");
		String account_number = request.getParameter("Account_number");
		String amount = request.getParameter("amount");

		HttpSession session = request.getSession();
		String real_username = (String) session.getAttribute("uname");
		int acc_number = Integer.parseInt((String) session.getAttribute("acc_number"));

		try {
			connection transfer = new connection();

			int bal1 = Integer.parseInt(transfer.show_balance(real_username));
			bal1 = bal1 - Integer.parseInt(amount);
			String b1 = String.valueOf(bal1);
			request.setAttribute("available_balance", b1);

			if (bal1 < 5000) {
				
				response.sendRedirect("error.jsp");

			} else {

				

				transfer.updateRecord(real_username, b1);

				int bal = Integer.parseInt(transfer.show_balance(username));
				bal = bal + Integer.parseInt(amount);
				String b = String.valueOf(bal);

				transfer.updateRecord(username, b);
				
				transfer.mini_statement_insert(real_username,acc_number, "Transfer", Integer.parseInt(amount));
				
				request.setAttribute("user_display", username);
				request.setAttribute("balance", amount);

				RequestDispatcher rd = request.getRequestDispatcher("Transfer_show_balance.jsp");
				rd.forward(request, response);
				
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
