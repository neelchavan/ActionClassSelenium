import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Maximize Window
		driver.manage().window().maximize();

		// Open website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		// Create Actions class for object a and pass driver to it
		Actions a = new Actions(driver);

		// Go to that link
		driver.findElement(By.className("blinkingText")).click();

		// If another tab is opened webdriver will not have access to that we have to
		// give it seperately so we have to switch the window.
		Set<String> windows = driver.getWindowHandles();

		// Now iterate through the window by iterator method
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();

		// It got the index of the second window now switch to it
		driver.switchTo().window(childId);

		// Select that email link
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
		System.out.println(email);

		// We grabbed the email now close this tab
		driver.close();

		// Now again switch to parent window
		driver.switchTo().window(parentId);

		// Now fill the login form
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("123456798");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		Thread.sleep(1000);

		// close tab
		driver.close();

	}

}
