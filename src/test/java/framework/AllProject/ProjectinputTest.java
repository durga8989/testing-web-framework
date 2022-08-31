package framework.AllProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.LoginPage;
import pages.Projectinput;

public class ProjectinputTest extends Base {
	public WebDriver driver;
	
	
	public static Logger log = LogManager.getLogger(ProjectinputTest.class.getName());
	
	@BeforeTest
	public void start() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("app launched");
		
	
		userval = prop.getProperty("username");
		passwordval =prop.getProperty("password");
		projectvalue = prop.getProperty("projectval");
		FromDate = prop.getProperty("FromDate");
		ToDate = prop.getProperty("ToDate");
		
		
		

	}

	@Test(retryAnalyzer=RetryAnalyser.class)
	public void TimesheetData() throws IOException, InterruptedException {

		wait = new WebDriverWait(driver, 60);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		LoginPage l = new LoginPage(driver);
		
		l.username().clear();
		
		l.username().sendKeys(userval);
		log.info("username enterred");
		
		Thread.sleep(3000);
		
		l.password().sendKeys(passwordval);
		log.info("Password entered");
		Thread.sleep(3000);
		l.loginbutton().click();
		System.out.println("Logged-in successfully");

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[contains(text(),'menu')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		l.clickPG();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		l.clickhamburgericon2();
		Thread.sleep(3000);
		l.clickTimetracking();

		Projectinput p = new Projectinput(driver);
		Thread.sleep(10000);
		// driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();

		p.ProjectdetailsValue();
		/*
		 * WebElement element1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='control19']")));
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		 * element1); //p.projectdetails().click();
		 */
		p.projectdetails().sendKeys(projectvalue);
		Thread.sleep(2000);
		/*
		 * WebElement element2 =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//mat-icon[contains(text(),'search')]")));
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		 * element2);
		 */
		driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]")).click();
		Thread.sleep(13000);
		// p.sendKeys(Keys.TAB);
		/*
		 * p.sendKeys(Keys.RETURN); p.sendKeys(Keys.SHIFT);
		 */
		// Thread.sleep(4000);
		// p.namevisibility();
		p.projectname();
		Thread.sleep(5000);

		p.dateIcon().click();
		p.dateselect();
		p.selectDate("1", "AUG", "2022");

		Thread.sleep(5000);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		p.clickdate2();
		// driver.findElement(By.xpath("//input[@data-mat-calendar='mat-datepicker-1']")).click();
		Thread.sleep(2000);
		p.dateIcon2().click();
		p.dateselect2();
		p.selectDate2("10", "AUG", "2022");
		p.nextbuttonclick();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}