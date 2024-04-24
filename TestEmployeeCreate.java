package com.test;
//import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.Dbutil;

public class TestEmployeeCreate {
	public static void main(String args[]) throws ClassNotFoundException {
	try {
		Connection con=Dbutil.getConnection();
		Statement st=con.createStatement();
		
		st.executeUpdate("create table Employee(id int (10),name varchar(10),salary double)");
		System.out.println("Driver loaded...");
		
//		Establish connection
		System.out.println("Table created...");
		st.close();
		con.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
				}
		}
	}

