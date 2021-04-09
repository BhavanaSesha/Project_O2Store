package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuickShopDeleteDao {
	 public boolean removeAllData(int id) {
		   int result = 0;
		   int id1 = id;
		   String query1 = "delete from quickshop where id1=id1";
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
