package pom;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.swing.JOptionPane;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file_util.File_Utility;

public class Login_Page {

	WebDriver driver;
	File_Utility file = new File_Utility();

	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@class='search_btn loginText ng-star-inserted']")
	WebElement Login;
	@FindBy(xpath = "//input[@placeholder='User Name']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passowrd;
	@FindBy(xpath = "//input[@id='captcha']")
	WebElement captcha;
	@FindBy(xpath = "(//button[@class='search_btn train_Search'])[2]")
	WebElement signup;
	@FindBy(xpath = "//a[@href='https://www.bus.irctc.co.in/']")
	WebElement Buses;
	@FindBy(xpath = "//span[text()=' Hotels']")
	WebElement Hotels;
	@FindBy(xpath = "//input[@id='filterText']")
	WebElement entercity;

	public void Loginirtctc() throws InterruptedException, IOException {

		String user = file.fetchdatafrompropfile("username");
		String pass = file.fetchdatafrompropfile("password");

		Login.click();
		username.sendKeys(user);
		passowrd.sendKeys(pass);
		String str = JOptionPane.showInputDialog("Enter your captcha");
		captcha.sendKeys(str);
		Thread.sleep(1000);
		if (signup.isDisplayed()) {
			System.out.println("Displayed");
		} else {
			System.out.println("Not displayed");
		}
		signup.click();
	}

	public void windowhandle() throws InterruptedException {

		String parentWh = driver.getWindowHandle();
		System.out.println(parentWh);
		Buses.click();
		Set<String> s = driver.getWindowHandles();
		java.util.Iterator<String> it = s.iterator();
		while (it.hasNext()) {

			String childwh = it.next();
			if (!parentWh.equalsIgnoreCase(childwh));				
			String ss = driver.switchTo().window(childwh).getTitle();
			System.out.println(ss);
		}
		Hotels.click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWh);
	}

}
