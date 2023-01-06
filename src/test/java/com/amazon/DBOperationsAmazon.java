package com.amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOperationsAmazon {

	Connection conn;
	Statement statement;
	ResultSet rs;
	PreparedStatement ps;
	List<String> DBtext = new ArrayList<String>();

	public void getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amazon", "root", "root");

		statement = conn.createStatement();
		
	}

	public void AddLaptops(List<String> text) throws SQLException {

		for (int i = 0; i < text.size(); i++) {

			if (i<7) {

				ps = conn.prepareStatement("insert into Product values(?)");
				ps.setString(1, text.get(i));
				ps.executeUpdate();

			}

		}

	}

	public void FetchSQLdata() throws SQLException {

		String qry = "select * from Product";
		rs = statement.executeQuery(qry);
		while (rs.next()) {

			DBtext.add(rs.getString(1));

		}

	}
	
	public void FindElementInDatabase(List<String> elementList) {
		
		int count = 0;
		for (String databaseElement : DBtext) {
			
			if(elementList.contains(databaseElement))
			{
				count++;
				System.out.println("Individual laptop: " + databaseElement);
			}
		}
		System.out.println("Total laptops available in database: " + count);
				
	}

}
