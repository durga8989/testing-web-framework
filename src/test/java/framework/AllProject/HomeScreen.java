package framework.AllProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pages.LoginPage;

public class HomeScreen extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomeScreen.class.getName());
	
	@BeforeTest
	public void start() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

	}

	@Test
	public void HomeScreenNavigation() throws IOException, InterruptedException {
		userval = prop.getProperty("username");
		passwordval =prop.getProperty("password");

		LoginPage l = new LoginPage(driver);
		l.username().clear();
		l.username().sendKeys(userval);
		Thread.sleep(3000);
		l.password().clear();
		l.password().sendKeys(passwordval);
		Thread.sleep(3000);
		l.loginbutton().click();
		System.out.println("Logged-in successfully");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		l.hamburgericon().click();
		Thread.sleep(1000);
		l.PG().click();
		l.hamburgericon().click();
		l.Timetracking().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}