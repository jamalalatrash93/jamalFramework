package jamalFW.jamalFW;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jelatrash/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void myTest() throws InterruptedException {

//		navigate("");
//		actionMethod("");
//		click("");

	}

	@After
	public void closeDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void click(String Selector) {
		visibilityOf(Selector);
		driver.findElement(By.cssSelector(Selector)).click();
	}

	public void sendKeys(String Selector, String textValue) {
		visibilityOf(Selector);
		driver.findElement(By.cssSelector(Selector)).sendKeys(textValue);
	}

	public void select(String Selector, String optionText) {
		visibilityOf(Selector);
		WebElement dropList = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(Selector))));
		Select dropdown = new Select(dropList);
		dropdown.selectByValue(optionText);
	}

	public void invisibilityOf(String Selector) {
		visibilityOf(Selector);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(Selector))));
	}

	public void visibilityOf(String Selector) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(Selector))));
	}

	public void actionMethod(String Selector) {
		visibilityOf(Selector);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(Selector));

		action.moveToElement(element).build().perform();

	}

}
