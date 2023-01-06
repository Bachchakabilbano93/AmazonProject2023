package com.amazon;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonOps {

	static Menu Click;
	static Products Search;
	static DBOperationsAmazon db;

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {

		WebDriver driver = new ChromeDriver();
		Click = new Menu(driver);
		Click.Click_Menu();
		Search = new Products(driver);
		Search.Products_Flow();
		db = new DBOperationsAmazon();
		db.getConnection();
		db.AddLaptops(Search.textList);
		db.FetchSQLdata();
		db.FindElementInDatabase(Search.textList);

	}

}
