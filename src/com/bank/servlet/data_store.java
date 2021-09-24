package com.bank.servlet;

import java.io.IOException;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.jdbc.connection;

@WebServlet("/data_store")
public class data_store extends HttpServlet {
	public static String type = null;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("Fname"); // FULL NAME

		String email = request.getParameter("email"); // EMAIL
		String username = request.getParameter("username"); // USERNAME
		String P_number = request.getParameter("phone_number"); // PHONE NUMBER
		String acc_number = request.getParameter("Account_number"); // account number
		String gender = request.getParameter("gender");
		String acc_type = request.getParameter("ac_type");

		String password = request.getParameter("psw");
		String R_password = request.getParameter("psw-repeat");
		HttpSession session = request.getSession();
		session.setAttribute("acc_type", acc_type);

		int key = 8;

		try {
			connection c1 = new connection();

			// out.println("Data Updated ");
			// out.println("=========================");
			// out.println(fname);
			// out.println(mname);
			// out.println(lname);
			// out.println(email);
			// out.println(username);
			// out.println(P_number);
			// out.println(password);
			// out.println(R_password);

			int n = 10;
			StringBuilder sb = new StringBuilder(n);

			for (int i = 0; i < n; i++) {
				int index = (int) (fname.length() * Math.random());
				sb.append(fname.charAt(index));

			}
			String user = sb.toString();

			String encypt_pass = c1.encryption(key, password);

			int balance = 5000;
			c1.addRecords(fname, email, user, P_number, acc_number, gender, acc_type, encypt_pass, encypt_pass,
					balance);

			// c1.create_user_table(username);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
