package com.github.base.jdbcstudy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcstudy";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final int INITIAL_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 100;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }

        connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error creating connection: " + e.getMessage());
            return null;
        }
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection());
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized boolean releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
            return usedConnections.remove(connection);
        }
        return false;
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static void main(String[] args) throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int money = resultSet.getInt("money");
            String name = resultSet.getString("name");
            System.out.println("id: " + id + ", name: " + name + ", money: " + money);
        }

        resultSet.close();
        statement.close();

    }
}