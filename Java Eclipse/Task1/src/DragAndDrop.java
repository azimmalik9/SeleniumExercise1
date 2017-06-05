import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	
	static WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\Users\\Administrator\\OneDrive\\QAC\\Week 5\\HTML\\DragAndDrop.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		
		builder.dragAndDropBy(draggable,175, 0).perform();
		
		if (droppable.getText().equals("Dropped!"))
			System.out.println("---Passed---");
		else
			System.out.println("---Failed---");
		

}
}
