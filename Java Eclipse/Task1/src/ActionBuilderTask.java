import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class ActionBuilderTask {

	private static final TimeUnit SECONDS = null;
	static WebDriver driver;
	static boolean pageLoaded;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\OneDrive\\QAC\\Week 5\\HTML\\Sortable.html");
		
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(30, SECONDS)
				 .pollingEvery(5, SECONDS)
				 .ignoring(NoSuchElementException.class);
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
				{ 
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name("one"));
				 	}
				 }); 
				
System.out.println(foo);*/

try{	
	
		pageLoaded = true;
			
	WebElement one = driver.findElement(By.name("one"));
	WebElement two = driver.findElement(By.name("two"));
	WebElement three = driver.findElement(By.name("three"));
	WebElement four = driver.findElement(By.name("four"));
	WebElement five = driver.findElement(By.name("five"));
	WebElement six = driver.findElement(By.name("six"));
	WebElement seven = driver.findElement(By.name("seven"));
	WebElement eight = driver.findElement(By.name("eight"));
	WebElement nine = driver.findElement(By.name("nine"));
	WebElement ten = driver.findElement(By.name("ten"));
	WebElement eleven = driver.findElement(By.name("eleven"));
	WebElement twelve = driver.findElement(By.name("twelve"));
	
		Actions builder = new Actions(driver); 
		builder.dragAndDrop(two, three).perform();
		builder.dragAndDrop(eleven, three).perform();

		boolean correctPositionOfTwo = false;
		boolean correctPositionOfThree = false;
		
		if(two.getLocation().x < three.getLocation().x)
			correctPositionOfTwo = true;
			System.out.println(correctPositionOfTwo);
			
			if(three.getLocation().x > eleven.getLocation().x)
				correctPositionOfThree = true;
			System.out.println(correctPositionOfThree);
		
}
	

catch(Exception e){
	e.printStackTrace();
	pageLoaded=false;
}

		

System.out.println("Page loaded = " + pageLoaded);


	}
}
