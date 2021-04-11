package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartDeleteDao {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	 public boolean removeAllData(String custId) {
		   int result = 0;
		   String customer_id = custId;
		   logger.info("to delete cookie value is"+customer_id);
		   String query1 = "delete from cart using cart inner join cart_customer on cart.cart_id = cart_customer.cart_id where cart_customer.customer_id=customer_id";
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

