package framework.AllProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Timesheet;

public class TimesheetTest extends Base {
	public WebDriver driver;
	public static String TaskInput;
	public static Logger log = LogManager.getLogger(ProjectinputTest.class.getName());

	@BeforeTest
	public void start() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void timesheet() throws IOException {
		wait = new WebDriverWait(driver, 60);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// TaskInput = prop.getProperty("TaskInput");
		Timesheet t = new Timesheet(driver);
		t.TaskName().click();
		WebElement TaskInput = driver.findElement(By.xpath("xpath expression"));
		String TaskNamevalue = prop.getProperty("TaskInput ");
		TaskInput.sendKeys(TaskNamevalue);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
