package com.amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {

	WebDriver driver;
	List<String> textList = new ArrayList<String>();

	public Products(WebDriver driver) {
		this.driver = driver;
	}

	private String URL = "https://www.amazon.in/";
	private By SearchBox = By.id("twotabsearchtextbox");
	private By SearchButton = By.id("nav-search-submit-button");
	private By LaptopTypes = By.xpath("//div[contains(@class,'s-card-container')]");
	private By Laptops = By.xpath(".//a[contains(@class,'s-underline-link-text')]");

	public void Products_Flow() throws InterruptedException {

		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(SearchBox).click();
		driver.findElement(SearchBox).sendKeys("Dell Laptop");
		driver.findElement(SearchButton).click();
		Thread.sleep(2000);

		List<WebElement> lstDiv = driver.findElements(LaptopTypes);
		for (WebElement parentDiv : lstDiv) {
			List<WebElement> lstLnks = parentDiv.findElements(Laptops);
			if (lstLnks.size()> 0) {
				System.out.println(lstLnks.get(0).getText());
				if(!lstLnks.get(0).getText().isEmpty())
				{
					textList.add(lstLnks.get(0).getText());
				}
			}

		}



	}

}
