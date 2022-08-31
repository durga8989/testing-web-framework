package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Projectinput{
	WebDriverWait wait;
	
	public WebDriver driver;
	JavascriptExecutor executor;
	
	public Projectinput(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		wait=new WebDriverWait(driver,60);
		executor = (JavascriptExecutor)this.driver;
		PageFactory.initElements(driver2, this);
	}
	
	
	
	@FindBy(xpath = "//input[@id='control19']")
	WebElement projectdetails;
	
	
	@FindBy(xpath="(//div[contains(text(),'Time Tracking')])[2]")
	WebElement Timetracking;
	
	@FindBy(xpath="//span[contains(text(),'Testing and Validation|Fincluez Internal Testing G')]")
	WebElement options;
	
	@FindBy(xpath="//mat-icon[contains(text(),'menu')]")
	WebElement hamburgericon;
	
	@FindBy(xpath="//span[contains(text(),'Testing and Validation|Fincluez Internal Testing G')]")
	WebElement name;
	
	@FindBy(xpath="(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[2]")
	WebElement dateIcon;
	
	@FindBy(xpath="//span[@id='mat-calendar-button-0']")
	WebElement dateselect;
	
	@FindBy(xpath="(//button[@class='mat-focus-indicator mat-icon-button mat-button-base'])[3]")
	WebElement dateIcon2;
	
	@FindBy(xpath="//span[@id='mat-calendar-button-1']")
	WebElement dateselect2;
	
	@FindBy(xpath="//input[@data-mat-calendar='mat-datepicker-1']")
	WebElement inputdate2click;
	
	@FindBy(xpath="(//mat-icon[contains(text(),'navigate_next')])[1]")
	WebElement nextbuttonclick;



	
	public WebElement projectdetails() {
		return projectdetails;
	}


	public void sendKeys(Keys enter) {
		}
	
	public WebElement name() {
		return name;
	}
	
	public WebElement options() {
		return options;
	}
	
	public WebElement hamburgericon() {
		return hamburgericon;
	}
	
	public void ProjectdetailsValue() {
	    wait.until(ExpectedConditions.visibilityOf(projectdetails));
	}
	public void projectname() {
	
	   executor.executeScript("arguments[0].scrollIntoView();", name);
		//executor.executeScript("document.getElementbyId('mat-option-7').focus();",name);
		//executor.executeScript("element.focus();", name);
	    name.click();
	}
	
	public void clickdate2() {
		   executor.executeScript("arguments[0].click();", inputdate2click);
			//executor.executeScript("document.getElementbyId('mat-option-7').focus();",name);
			//executor.executeScript("element.focus();", name);
		   inputdate2click.click();
		}
	
	public void namevisibility() {
	    wait.until(ExpectedConditions.visibilityOf(name));
	}
	
	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}
	
	
	public  void selectDate(String day, String month, String year) throws InterruptedException
	{ 
		
	String monthYearVal=driver.findElement(By.xpath("//span[@id='mat-calendar-button-0']")).getText();
	System.out.println(monthYearVal);
	
	while(!(getMonthYear(monthYearVal)[0].equals(month) 
			&&
			getMonthYear(monthYearVal)[1].equals(year))) {
		driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
		monthYearVal =driver.findElement(By.xpath("")).getText();
		
	}
	driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]")).click();
	//div[contains(text(),'3')]
	
	}
	
	
	
	public  void selectDate2(String day, String month, String year) throws InterruptedException
	{ 
		
	String monthYearVal=driver.findElement(By.xpath("//span[@id='mat-calendar-button-1']")).getText();
	System.out.println(monthYearVal);
	
	while(!(getMonthYear(monthYearVal)[0].equals(month) 
			&&
			getMonthYear(monthYearVal)[1].equals(year))) {
		driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
		monthYearVal =driver.findElement(By.xpath("")).getText();
		
	}
	driver.findElement(By.xpath("(//div[contains(text(),'"+day+"')])[2]")).click();
	//div[contains(text(),'3')]
	
	}
	
	public WebElement dateIcon() {
		return dateIcon;
	}
	
	public WebElement dateIcon2() {
		return dateIcon2;
	}
	
	public void dateselect() {
	    wait.until(ExpectedConditions.visibilityOf(dateselect));
	}
	public void dateselect2() {
	    wait.until(ExpectedConditions.visibilityOf(dateselect2));
	}
	public void nextbuttonclick() {
		 executor.executeScript("arguments[0].click();", nextbuttonclick);
		 nextbuttonclick.click();
	}
	
}
