package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	private WebDriverWait wait10;
	private WebDriverWait wait40;
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
		this.executor = (JavascriptExecutor) this.driver;
	    this.wait10 = new WebDriverWait(driver, 10);
	    this.wait40 = new WebDriverWait(driver, 40);
		PageFactory.initElements(driver2, this);
		
	}
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	
	
	@FindBy(xpath = "//input[@id='mat-input-0']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement password;
	
	@FindBy(xpath="(//span[contains(text(),'Login')])[1]")
	WebElement loginbutton;
	
	@FindBy(xpath="//mat-icon[contains(text(),'menu')]")
	 WebElement hamburgericon;
	
	@FindBy(xpath="(//div[contains(text(),'PG')])[1]")
	WebElement PG;
	
	@FindBy(xpath="(//div[contains(text(),'Time Tracking')])[2]")
	WebElement Timetracking;
	
	

	public WebElement username() {
		return username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement loginbutton() {
		return loginbutton;
	}
	
	public WebElement hamburgericon() {
		return hamburgericon;
	}
	public WebElement PG() {
		return PG;
	}
	/*public WebElement hamburgericon2() {
		return hamburgericon;
	}*/
	
	public WebElement Timetracking() {
		return Timetracking;
	}
	public void Clickhamburgericon() {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgericon)).click();
		
	}
	public void clickPG() {
	    executor.executeScript("arguments[0].click();", PG);
	}
	public void clickhamburgericon2() {
	    executor.executeScript("arguments[0].click();", hamburgericon);
	}
	public void clickTimetracking() {
	    executor.executeScript("arguments[0].click();", Timetracking);
	}
	
	
	


}
