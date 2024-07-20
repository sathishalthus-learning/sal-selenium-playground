package doc.selenium;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SD011_FirstScriptWithTestRunner {
	//
	/*
	 * Eight Basic Actions
	 */
	
	WebDriver driver;
	
	@BeforeEach
	void setup() {
		//
		// 1. Start Session
		driver = new ChromeDriver();
		
		//2. Establish a  Wait strategy
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@AfterEach
	void teardown() {
		//
        // 8. End Session
		driver.quit();
	}
	
	@Test
	public void basicSelenium(){
		
		// 3. Take Action on Browser
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		
		// 4. Request Information
        String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

		// 5. Find an element
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        
		// 6. Take action on element
        textBox.sendKeys("Selenium");
        submitButton.click();
        
        // 7. Request element information
        String message = driver.findElement(By.id("message")).getText();
        
        Assertions.assertEquals("Received!", message);
		
	}
	
}