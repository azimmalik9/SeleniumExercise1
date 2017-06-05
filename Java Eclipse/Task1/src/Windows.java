import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\OneDrive\\QAC\\Week 5\\HTML\\Window.html");
		String window1 = driver.getWindowHandle();
		System.out.println("First handle is: "+ window1);
		WebElement link = driver.findElement(By.linkText("Google Search"));
		link.click();
		
		String window2 = driver.getWindowHandle();
		System.out.println("Second Handle is: "+window2);
		System.out.println("# Handles so for: "
				+ driver.getWindowHandles().size());
		
		driver.switchTo().window(window1);
		
}
}
