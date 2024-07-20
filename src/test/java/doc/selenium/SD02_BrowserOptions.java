package doc.selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SD02_BrowserOptions {

	WebDriver driver;
	
	@BeforeEach
	void setup() {
		//
		ChromeOptions options = new ChromeOptions();
		//
		options.setPlatformName("windows");
		options.setBrowserVersion("125.0");
		options.setAcceptInsecureCerts(true);
		//
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setImplicitWaitTimeout(Duration.ofSeconds(3));
		options.setPageLoadTimeout(Duration.ofSeconds(5));
		options.setScriptTimeout(Duration.ofSeconds(5));
		//
	    options.addArguments("--start-maximized");
		//
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@AfterEach
	void teardown() {
		//
		driver.quit();
	}
	
	@Test
	public void chormeOptions(){
		
		// 1. Arrange
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        // 2. Act
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        textBox.sendKeys("Selenium");
        submitButton.click();
        //3. Assert
        String message = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals("Received!", message);
		
	}
}
