package com.selenium.training.pom.utils;

import java.sql.*;

/**
 * Created by Aby on 6/09/2017.
 */
public class Dao {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet = null;

    public void getResultFromQuery() throws ClassNotFoundException, SQLException {
        resultSet = null;
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        statement=connection.createStatement();

        resultSet=statement.executeQuery("");

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
}
