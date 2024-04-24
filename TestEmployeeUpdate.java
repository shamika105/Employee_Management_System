package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.Dbutil;

public class TestEmployeeUpdate {

	public static void main(String[] args) {
		 Connection con = Dbutil.getConnection();
		 try {
	            PreparedStatement pst1 = con.prepareStatement("UPDATE Employee SET name = ?, salary = ? WHERE id = ?");

	            Scanner sc = new Scanner(System.in);

	            System.out.println("Enter id:");
	            int id = sc.nextInt();
	            
	            sc.nextLine(); 
	            
	            System.out.println("Enter updated name:");
	            String name = sc.nextLine();
	            
	            System.out.println("Enter updated salary:");
	            double salary = sc.nextDouble();

	            // Set parameters for the update statement
	            pst1.setString(4, name);
	            pst1.setDouble(3, salary);
	            pst1.setInt(1, id);

	            // Execute the update statement
	            int rowsAffected = pst1.executeUpdate();

	            // Check if any rows were affected
	            if (rowsAffected > 0) {
	                System.out.println(rowsAffected + " row(s) updated.");
	            } else {
	                System.out.println("No rows updated.");
	            }

	            pst1.setInt(1, id);
	            

	            int rowsAffected1 = pst1.executeUpdate();
	          
	            pst1.close();
	            con.close();
	            sc.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
