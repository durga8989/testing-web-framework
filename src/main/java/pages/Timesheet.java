package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Timesheet {
WebDriverWait wait;
	
	public WebDriver driver;
	JavascriptExecutor executor;
	
	public Timesheet(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		wait=new WebDriverWait(driver,60);
		executor = (JavascriptExecutor)this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[contains(text(),'Select')])[1]")
	WebElement TaskName; 
	
	public WebElement TaskName() {
		return TaskName;
	}

}
