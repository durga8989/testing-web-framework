package framework.AllProject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import framework.AllProject.Configuration_Library;
import framework.AllProject.DataManager;


import framework.AllProject.*;

public class Base {
	public BufferedReader reader;
	public WebDriver driver;
	public Properties prop;
	public String propertyFilePath = "C:\\Users\\durga\\eclipse-workspace\\AllProject\\configs\\configuration.properties";
	public static String url;
	public static String userval;
	public static String passwordval;
	public static String projectvalue;
	public static String FromDate;
	public static String ToDate;
	WebDriverWait wait;
	DataManager datamanager;
	String testCaseName = getClass().getSimpleName();
	
	
	public  WebDriver initializeDriver() throws IOException {
		
		//BufferedReader reader;
		
		
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();
			
			try {
				prop.load(reader);
				
				/*mvn test -Dbrowser=chrome*/
				
				//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
				String browserName = prop.getProperty("browser"); // comment this line if you are sending parameter from Maven
				System.out.println(browserName);
				
				
				
				if (browserName.equalsIgnoreCase("chrome")) {

					System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\durga\\eclipse-workspace\\AllProject\\Resources\\chromedriver.exe");
					driver = new ChromeDriver();
					 
					
				} else if (browserName.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver",
							"C:\\Users\\durga\\eclipse-workspace\\AllProject\\Resources\\geckodriver.exe");
					driver = new FirefoxDriver();

				} else if (browserName.equalsIgnoreCase("msedge")) {
					System.setProperty("webdriver.edge.driver",
							"C:\\Users\\durga\\eclipse-workspace\\AllProject\\Resources\\msedgedriver.exe");
					driver = new EdgeDriver();
				}
				
				
				
				//reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
				} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	
		
	
		return driver;
		
	
		 //WebDriver wait	
	}
	public void ExplicitWait(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	/*Capture Screenshot*/
	
	public String  captureScreenshot(WebDriver driver,String ImageName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Images\\"+ImageName+".jpg";
		FileUtils.copyFile(scrFile, new File(destination));
		return destination;
	}

	

	

}
