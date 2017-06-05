import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class LoginTest {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main	(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com");
		final String userName = "azim.malik9@gmail.com";
		final String password = "dfgd!";

		WebElement usernameBox = driver.findElement(By.name("email"));
		WebElement passwordBox = driver.findElement(By.name("pass"));
		WebElement saveBtn = driver.findElement(By.id("u_0_q"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();
				
		boolean jr1 = false;
		TimeUnit SECONDS;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(30, SECONDS)
				 .pollingEvery(5, SECONDS)
				 .ignoring(NoSuchElementException.class);
				WebElement foo = (WebElement) wait.until((Function<? super WebDriver, T>) new Function<WebDriver, WebElement>() 
				{ 
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name("q"));
				 	}
				 }); 

		if (jr1)
			System.out.println("Passed");
		else
			System.out.println("Failed");

		driver.close();
		System.exit(0);
	}
	private static boolean isElementPresent(By by) {
		  try {
		    driver.findElement(by);
		    return true;
		  } catch (NoSuchElementException e) {
		    return false;
		  }
		}
}


