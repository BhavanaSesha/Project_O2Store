package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddToCartDeleteDao {
	 public boolean removeAllData(String customer_id1) {
		   int result = 0;
		   String customer_id = customer_id1;
		   String query1 = "delete  from cart using cart  inner join cart_customer on cart.cart_id = cart_customer.cart_id where cart_customer.customer_id=?";
		   Connection connection;
	       PreparedStatement statement;
	       Statement stmt1;
	       ResultSet resultset;
	       connection = DBUtil.getConnection();
	       try {
	    	   statement = connection.prepareStatement(query1);
	    	   
	    	   result = statement.executeUpdate();
	           
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	       if(result != 0) {
	    	   return true;
	       }
	       else
	    	   return false;
	   }
}

