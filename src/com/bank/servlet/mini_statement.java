package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.jdbc.connection;

@WebServlet("/mini_statement")
public class mini_statement extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public mini_statement() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("uname");
		int acc_number = Integer.parseInt((String) session.getAttribute("acc_number"));
		
		try {
			connection mini = new connection();
			ArrayList output = new ArrayList<>();
			
			output = mini.showAllResult(username,acc_number);
			
			PrintWriter out = response.getWriter();
			//out.print(output);
			
			//mini.mini_statement_insert("bhu","deposit",10000);
			
			System.out.println();
			
			 Iterator itr=output.iterator();//getting the Iterator  
			  while(itr.hasNext()){//check if iterator has the elements 
				  
				  out.println("<h1>"+itr.next()+"</h1>");//printing the element and move to next  
				  
			  }  
			  
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
