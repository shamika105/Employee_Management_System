package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.Dbutil;

public class TestEmployeeRead {

    public static void main(String[] args) {
        Connection con = Dbutil.getConnection();

        try {
            PreparedStatement pst = con.prepareStatement("insert into Employee values (?, ?, ?)");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter id,name,salary:");
            int id = sc.nextInt();
            
            sc.nextLine(); // Consume newline
            String name = sc.nextLine();
            double sa = sc.nextDouble();

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, sa);

            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " rows inserted.");

            pst.close();
            con.close();
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
