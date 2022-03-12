import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Maximize Window
		driver.manage().window().maximize();

		// Open website
		driver.get("https://www.amazon.com/");

		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

		// Create Actions class for object a and pass driver to it
		Actions a = new Actions(driver);

		// Now move to element by mouse (if we do not use built and perform this step
		// will not be executed)
		// a.moveToElement(move).build().perform();

		// Now go to the search bar and enter some text in capital letters by holding
		// the shift key.
		a.moveToElement(input).click().keyDown(Keys.SHIFT).sendKeys("mobile").build().perform();

		// Now to select that text
		a.moveToElement(input).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
		Thread.sleep(1500);
		
		// close tab
		driver.close();

	}

}
