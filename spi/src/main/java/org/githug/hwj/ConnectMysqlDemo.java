package org.githug.hwj;

import java.sql.*;

/**
 * @author hewenji
 * @Date 2022/9/4 15:57
 */
public class ConnectMysqlDemo {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcstudy?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString("NAME");
            String password = rs.getString("PASSWORD");
            System.out.println("name: " + name + ", password: " + password);
        }

        rs.close();
        statement.close();
        connection.close();
    }
}
