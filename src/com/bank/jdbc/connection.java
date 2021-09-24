package com.bank.jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.jmx.snmp.Timestamp;

public class connection {

	Connection connection;

	Statement statement;
	ResultSet resultSet;
	Scanner scanner;
	PreparedStatement pst;

	ResultSetMetaData metaData;

	public connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // choosing the mysql drivers
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root"); // databade

		scanner = new Scanner(System.in);
		statement = connection.createStatement();
	}

	public ArrayList showAllResult(String db , int acc_number) throws SQLException {
		String output = null;
		ArrayList l1 = new ArrayList<>();

		//String query = "select * from " + db;

		pst = connection.prepareStatement("select Date_time,Activity,Amount from transaction where username = ? and Acc_number = ?");
		resultSet = null;
		pst.setString(1, db);
		pst.setInt(2, acc_number);
		resultSet = pst.executeQuery();
		
		
		//metaData = resultSet.getMetaData();

		

		while (resultSet.next()) {
			l1.add(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
		}
		return l1;

	}

	public void addRecords(String fname, String email, String username, String P_number, String acc_number,
			String gender, String acc_type, String password, String R_password, int balance) throws SQLException {

		int res = statement.executeUpdate("insert into signup values('" + fname + "','" + email + "','" + username
				+ "','" + P_number + "','" + acc_number + "','" + gender + "','" + acc_type + "','" + password + "','" + R_password
				+ "','" + balance + "')");
		if (res == 1)
			System.out.println("Register Record is Added");
		
		connection.close();

	}

	public void create_user_table(String username) throws SQLException {
		String query = "create table " + username + "(Date_time varchar(100), Activity varchar(10) , Amount int)";
		statement.execute(query);
		System.out.println("user table is created");

	}

	public String searchRecord(String username,String acc_number) throws SQLException {

		pst = connection.prepareStatement("select * from signup where username = ? and Acc_number = ?");
		resultSet = null;

		pst.setString(1, username);
		pst.setString(2, acc_number);		
		resultSet = pst.executeQuery();

		if (resultSet.next()) {
			String pass = resultSet.getString(8);
			return pass;
			
			
		} else {
			return "cool";
		}
	}

	public String show_balance(String username) throws SQLException {
		pst = connection.prepareStatement("select balance from signup where username = ? ");
		resultSet = null;

		pst.setString(1, username);
		resultSet = pst.executeQuery();

		if (resultSet.next()) {
			return resultSet.getString(1);
		} else {
			return "Unable to fetch";
		}
	}
	

	public boolean updateRecord(String username, String balance) throws SQLException {

		pst = connection.prepareStatement("select * from signup where username = ?");
		resultSet = null;

		pst.setString(1, username);
		resultSet = pst.executeQuery();

		if (resultSet.next()) {

			pst = null;
			pst = connection.prepareStatement("update signup set balance = ? where username=?");
			pst.setString(1, balance);
			pst.setString(2, username);
			int i = pst.executeUpdate();

			System.out.println("Record updated");
			return true;

		} else {
			System.out.println("record is not available");
			return false;

		}
	}

	public void mini_statement_insert(String db,int acc_number, String activity, int amount) throws SQLException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		Date date = cal.getTime();

		String query = "insert into transaction values('" + db + "','" + acc_number + "','" + date + "','" + activity + "','" + amount + "')";

		int res = statement.executeUpdate(query); 
		if (res == 1)
			System.out.println("record added");
		
		connection.close();

	}
	
	
	public String encryption(int key , String password) {
		String encrypt = "";
		
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			ch += key;
			encrypt = encrypt + ch;
		}
		return encrypt;
		}
	
	
	public String decrypt(String encrypt , int key) {
		String decrypt =""; 
		for (int i = 0; i < encrypt.length(); i++) {
			char ch = encrypt.charAt(i);
			ch -= key;
			decrypt = decrypt + ch;
		}
		return decrypt;
		
	}
	
	//------------------------profile data fetch-------------------------------------
	
	public ArrayList profile_showAllResult(String db , int acc_number) throws SQLException {
		ArrayList l1 = new ArrayList<>();
		
//		String fname ,email,gender,acc_type ="";
//		int Ph_number = 0;
		

		pst = connection.prepareStatement("select Fname,email,ph_number,gender,Account_Type from signup where username = ? and Acc_number = ?");
		resultSet = null;
		pst.setString(1, db);
		pst.setInt(2, acc_number);
		resultSet = pst.executeQuery();
		
		
		//metaData = resultSet.getMetaData();
		while (resultSet.next()) {
				for (int i = 1; i < 6; i++) {
					l1.add(resultSet.getString(i));
				}
			
//			fname = resultSet.getString(1);
//			email = resultSet.getString(2);
//			Ph_number = resultSet.getInt(3);
//			gender = resultSet.getString(4);
//			acc_type = resultSet.getString(5);
//			
		}
		//System.out.println(l1);	
		return l1;	
	}
	
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		connection c = new connection();

	}

}
