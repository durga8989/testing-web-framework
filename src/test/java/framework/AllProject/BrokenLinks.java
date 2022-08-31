package framework.AllProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks extends Base {

	


		@Test
		public void brokenlinks() throws IOException, InterruptedException {
			driver = initializeDriver();
			driver.get("https://www.atlassian.com/software/statuspage");
			
//			getApplicationUrl();
//			driver.get(getApplicationUrl());	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement>   linkslist =  driver.findElements(By.tagName("a"));
			linkslist.addAll(driver.findElements(By.tagName("href")));
			System.out.println(linkslist.size());
			
			/*
			check for the active links now*/
			List<WebElement> activelinks = new ArrayList<WebElement>();
			
			for(int i = 0;i<linkslist.size();i++) {
				if(linkslist.get(i).getAttribute("href")!= null){
					activelinks.add(linkslist.get(i));
				}
				
			}
			
			System.out.println("activelinks are"+activelinks.size());
			for(int j=0;j<activelinks.size();j++){
			HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			int responseCode = connection.getResponseCode();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+" : "+responseCode);
			}
			
			driver.close();
	}
		
}
