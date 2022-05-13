package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.DriverSetup;
import pageObjects.JavascriptUtil;

public class Signin extends DriverSetup {

	@Test(priority = 1)
	public void SigninPage() throws InterruptedException {

		try {
			driver.findElement(By.xpath("//a[@class='logged-out-user-menu-btn btn btn-secondary']")).click();

			driver.findElement(By.id("j_username")).sendKeys("saimumislam2@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.name("j_password")).sendKeys("38002113");
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,100)");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
			Thread.sleep(2000);

			// driver.findElement(By.xpath("//a[@id='js--authors']")).click();
			// Thread.sleep(5000);

			System.out.println("signin done");

			// driver.findElement(By.linkText("বই")).click();

			WebElement ele = driver.findElement(By.xpath("//a[@id='js--authors']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			Thread.sleep(2000);

			driver.findElement(By.linkText("হুমায়ূন আহমেদ")).click();
			Thread.sleep(2000);

			JavascriptUtil.scrollPageDown(driver);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("label[for='categoryIds_677']")).click();
			Thread.sleep(2000);

			JavascriptUtil.scrollPageDown(driver);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("label[for='categoryIds_718']")).click();
			
			WebElement page2 = driver.findElement(By.xpath("//img[@alt='Premer Uponash Somogro : Badal Diner Prothom Kodom Ful']"));
			Thread.sleep(2000);
			
			//js.executeScript("window.scrollTo(0,7500)");
			js.executeScript("arguments[0].scrollIntoView()", page2);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
			Thread.sleep(2000);
			
			WebElement add = driver.findElement(By.xpath("//img[contains(@alt,'Misir Ali Amonibas-3')]"));
			js.executeScript("arguments[0].scrollIntoView()", add);
			Thread.sleep(2000);
			
			add.click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[@id='js-cart-menu']//*[name()='svg']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[normalize-space()='Place Order']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[normalize-space()='Add new address']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//label[normalize-space()='Office']")).click();
			driver.findElement(By.xpath("//input[@id='phone2']")).sendKeys("01521302783");
			
			WebElement country = driver.findElement(By.xpath("//select[@id='js--add-country']"));
			Select country_dd = new Select(country);
			country_dd.selectByVisibleText("Bangladesh");
			Thread.sleep(2000);
			
			WebElement city = driver.findElement(By.xpath("//select[@id='js--add-city']"));
			Select city_dd = new Select(city);
			city_dd.selectByValue("2");
			Thread.sleep(2000);
			
			WebElement area = driver.findElement(By.xpath("//select[@id='js--add-area']"));
			Select area_dd = new Select(area);
			area_dd.selectByIndex(3);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("House No: 06, Road: Dhaka Housing, North Adabar.");
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
