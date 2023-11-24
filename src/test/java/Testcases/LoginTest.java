package Testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.utils.XMLSecurityPropertyManager.Property;

import file_util.File_Utility;
import pom.Login_Page;

public class LoginTest {
	
	WebDriver driver;
    File_Utility file = new File_Utility();
	@Test
	public void IRCTC() throws InterruptedException, IOException {
		
		
		String chrome= file.fetchdatafrompropfile("chromedriver");
		String path= file.fetchdatafrompropfile("chromepath"); 
		String url= file.fetchdatafrompropfile("url");
								
		System.setProperty(chrome,path);
		WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(url);
	    
	    Login_Page L = new Login_Page(driver);
	    L.Loginirtctc();
		
	}
}
