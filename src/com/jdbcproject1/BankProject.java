package com.jdbcproject1;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.Statement;


public class BankProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadData.getDetails(1,"jdbc:mysql://localhost:3306/bankDB","Ram","Ram-123" );
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankDB","Ram","Ram-123");
			
			Statement st = con.createStatement();
			
			int i = st.executeUpdate("insert into customers values(123,'aaa',1515,5000.00,'pune')");
			
			System.out.println("inserted data into tables of customer" + i);
			
		} catch(Exception err) {
			System.out.println(err);
		}

	}

}

class ReadData {
	
	public static void getDetails(int row, String url,String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
			ResultSet rs=stmt.executeQuery("select * from customers");
			
			rs.absolute(row);  
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

class InsertData {
		public static void insert() {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankDB","Ram","Ram-123");
				
				Statement st = con.createStatement();
				
				int i = st.executeUpdate("insert into customers values(123,'aaa',1515,5000.00,'pune')");
				
				System.out.println("inserted data into tables of customer" + i);
				
			} catch(Exception err) {
				System.out.println(err);
			}
		}
}

