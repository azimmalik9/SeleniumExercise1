import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\OneDrive\\QAC\\Week 5\\HTML\\Frames.html");
	
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(0);
		WebElement txt = driver.findElement(By.name("1"));
		txt.sendKeys("I'm Frame One");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		txt = driver.findElement(By.name("2"));
		txt.sendKeys("I'm Frame Two");
	}
}
