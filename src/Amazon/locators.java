package Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locators {

	public WebDriver driver;

	@BeforeTest
	public void beforeTestStart() {
		System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Wait for 5 sec if something expected doesn't displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open website
		driver.get("https://amazon.com");

		// Close the dialog-box if displayed
		WebElement dialogBox = driver.findElement(By.xpath("//div[@role='alertdialog']"));
		if (dialogBox.isDisplayed()) {
			driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]")).click();
		}
	}

	@Test
	// Multiple ways of locating the elements in selenium
	// By xpath
	public void practiceXpaths1() {
		driver.findElement(By.xpath("//img[@alt='Headsets']")).click();
	}

	@Test
	public void practiceXpaths2() {
		for (int i = 0; i < 3; i++) {
			// Giving multiple attributes in one xpath.
			driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']")).click();
			// I you want to give multiple attr in one xpath e.g given below
			//driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded' and @xpath='1']")).click();
			// or
			//driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded'][@xpath='1']")).click();
		}
	}

	@Test
	public void searchIphone() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("iphone 12");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// Get the ratings
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='a-size-base s-underline-text']"));
		for(int i=1; i<ratings.size(); i++) {
			driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).get(i).click();
			driver.navigate().back();
		}
		}
		

	@AfterTest
	public void afterTestsEnds() throws InterruptedException {
		Thread.sleep(2);
		driver.close();
	}
}
