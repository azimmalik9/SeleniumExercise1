import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieTest {
static WebDriver driver;
	
	public static void main(String[] args){
		
			System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.com/account/login");
		final String userName = "azim.malik@qa.com";
		final String password = "Bismillah1!";
		
WebElement signOut = driver.findElement(By.className("action-menu"));

		WebElement usernameBox = driver.findElement(By.name("maincontent_0$TextUserName"));
		WebElement passwordBox = driver.findElement(By.name("maincontent_0$TextPassword"));
		WebElement saveBtn = driver.findElement(By.name("maincontent_0$IBLogin"));
		
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();
		
	writeToFile();
	
	WebElement loader = driver.findElement(By.className("head"));
	if (loader.getText().equals("My learning"))	
		signOut.click();
	
	//readFromFile();
		
		
    } 
		

	private static void writeToFile() {
		try{
		File f = new File("browser.data");
		
		f.delete();
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	
		BufferedWriter bos  = new BufferedWriter(new FileWriter(f));
		
	

		
		for(Cookie ck : driver.manage().getCookies()) {
			try {
				bos.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()
				+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bos.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
			bos.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}

	}
	
	private static void readFromFile() {
		File f = new File("browser.data");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line;
		try {
			while((line = br.readLine())!= null){
				StringTokenizer str = new StringTokenizer(line,";");
				while(str.hasMoreTokens()){
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					
					if(!(dt=str.nextToken()).equals("null")){
						expiry = new Date(dt);
						}
					boolean isSecure = new Boolean(str.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.manage().addCookie(ck);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
