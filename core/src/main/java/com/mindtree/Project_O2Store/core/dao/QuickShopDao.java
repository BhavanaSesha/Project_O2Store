package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class QuickShopDao {

    public int quickShopDetails(int id, String name, int price) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO quickshop" +
            "   VALUES " +
            " (?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/o2store", "root", "Amalapuram@9");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1,id );
            preparedStatement.setString(2,name );
            preparedStatement.setInt(3,price );

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error");
        }
        return result;
    }
    
    
    
    
}