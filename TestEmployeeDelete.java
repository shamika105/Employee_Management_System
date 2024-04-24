package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.Dbutil;

public class TestEmployeeDelete {

	public static void main(String[] args) {
		Connection con = Dbutil.getConnection();
		try {
            
            PreparedStatement pst = con.prepareStatement("Delete from Employee where id = ?");

            Scanner sc = new Scanner(System.in);

            
            System.out.println("Enter ID of employee to delete:");
            int id = sc.nextInt();

      
            pst.setInt(1, id);

           
            int rowsAffected = pst.executeUpdate();

            
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " row(s) deleted.");
            } else {
                System.out.println("No rows deleted.");
            }

            // Close resources
            pst.close();
            con.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
