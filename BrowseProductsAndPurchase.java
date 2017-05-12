package Selenium.ExtentReport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowseProductsAndPurchase {
	// where to create the report file
	ExtentReports report = new ExtentReports(
			"C:\\Users\\Administrator\\OneDrive\\QAC\\Week 5\\Java Eclipse\\SeleniumProject\\automationreport.html",
			true);
	ExtentTest test;
	WebDriver driver;

	WebElement flightLink;
	WebElement flightPage;
	WebElement departFrom;
	WebElement arriveIn;

	// pass scenario
	@Test(priority = 1, enabled = true)
	public void verifyPageLoadFromTitle() {
		// init/start the test
		test = report.startTest("Verify page load");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("http://newtours.demoaut.com/index.php");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Welcome: Mercury Tours")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		report.endTest(test);
		report.flush();
	}

	@Test(priority = 2, enabled = true)
	public void selectProductPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/index.php");
		test = report.startTest("Select product page");
		// add a note to the test
		test.log(LogStatus.INFO, "Product page opened");

		flightLink = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a"));
		flightLink.click();
		// sign-in to view products
		final String userName = "azim1";
		final String password = "test";

		WebElement usernameBox = driver.findElement(By.name("userName"));
		WebElement passwordBox = driver.findElement(By.name("password"));
		WebElement saveBtn = driver.findElement(By.name("login"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		String productPageTitle = driver.getTitle();
		System.out.println(productPageTitle);
		flightPage = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));

		if (flightPage.isDisplayed())
			// report the test as a pass
			test.log(LogStatus.PASS, "verify select product");
		else {
			test.log(LogStatus.FAIL, "verify select product");
		}
		report.endTest(test);
		report.flush();

	}

	@Test(priority = 3, enabled = true)
	public void addProductToBasket() {
		test = report.startTest("Add Product To Basket");
		// add a note to the test
		test.log(LogStatus.INFO, "Product added to basket");
		Select ddl_departFrom = new Select(driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select")));
		Select ddl_toPort = new Select(driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select")));
		ddl_departFrom.selectByVisibleText("Portland");
		ddl_toPort.selectByVisibleText("New York");

		String departFrom = ddl_departFrom.getFirstSelectedOption().getText();
		String arriveTo = ddl_toPort.getFirstSelectedOption().getText();
		WebElement flightSearch = driver.findElement(By.name("findFlights"));

		flightSearch.click();

		if (driver
				.findElement(By
						.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font"))
				.getText().contains(departFrom) & driver
						.findElement(By
								.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font"))
						.getText().contains(arriveTo))
		// report the test as a pass
		{
			test.log(LogStatus.PASS, "verify addProductToBasket");
		} else
			test.log(LogStatus.FAIL, "verify addProductToBasket");

		report.endTest(test);
		report.flush();

	}

	@Test(priority = 3, enabled = true)
	public void proceedToCheckout() {
		test = report.startTest("Proceed to checkout");
		// add a note to the test
		test.log(LogStatus.INFO, "Product added to checkout");
		List<WebElement> chkoutFlight = driver.findElements(By.name("outFlight"));

		// This will tell you the number of Check Boxes are present
		int iSize = chkoutFlight.size();
		String sValue = null;
		// Start the loop from first Check Box to last Check Box
		for (int i = 0; i < iSize; i++) {
			// Store the Check Box name to the string variable, using 'Value'
			// attribute
			sValue = chkoutFlight.get(i).getAttribute("value");

			// Select the Check Box it the value of the Check Box is same what
			// you are looking for
			if (sValue.equalsIgnoreCase("Blue Skies Airlines$561$97$7:10")) {				

				// This will take the execution out of for loop
				break;
			}
		}
		System.out.println(sValue);

		WebElement reserveFlights = driver.findElement(By.name("reserveFlights"));
		reserveFlights.click();

		if (sValue.equals("Blue Skies Airlines$561$97$7:10"))
			// report the test as a pass
			test.log(LogStatus.PASS, "verify addProductToBasket");
		else
			test.log(LogStatus.FAIL, "verify addProductToBasket");

		report.endTest(test);
		report.flush();
	}

	@Test(priority = 4, enabled = true)
	public void checkout() {
		test = report.startTest("Confirm payment at checkout");
		// add a note to the test
		test.log(LogStatus.INFO, "Input payment details");

		final String passFirst0 = "azim1";
		final String passLast0 = "test";
		final String creditnumber = "1234";

		WebElement firstName = driver.findElement(By.name("passFirst0"));
		WebElement lastName = driver.findElement(By.name("passLast0"));
		WebElement cardNumber = driver.findElement(By.name("creditnumber"));
		WebElement checkoutBtn = driver.findElement(By.name("buyFlights"));

		firstName.sendKeys(passFirst0);
		lastName.sendKeys(passLast0);
		cardNumber.sendKeys(creditnumber);
		checkoutBtn.click();
	}
}
