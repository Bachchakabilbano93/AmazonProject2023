package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Menu {

	WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}

	private String URL = "https://www.amazon.in/";
	private By Mobiles = By.xpath("//a[contains(text(),'Mobiles')]");
	private By BestSellers = By.linkText("Best Sellers");
	private By Fashion = By.xpath("//a[contains(text(),'Fashion')]");

	public void Click_Menu() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(Mobiles).click();
		Thread.sleep(2000);
		driver.findElement(BestSellers).click();
		Thread.sleep(2000);
		driver.findElement(Fashion).click();
		Thread.sleep(2000);

	}

}
