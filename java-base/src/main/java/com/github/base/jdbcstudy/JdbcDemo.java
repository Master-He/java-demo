package com.github.base.jdbcstudy;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcstudy";
        String user = "root";
        String password = "123456";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int money = rs.getInt("money");
                System.out.println("id: " + id + ", name: " + name + ", money: " + money);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
