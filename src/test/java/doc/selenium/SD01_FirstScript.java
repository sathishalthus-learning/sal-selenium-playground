package doc.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SD01_FirstScript {
	//
	public static void main(String[] args) {
		
		/*
		 * Eight Basic Actions
		 */
		
		// 1. Start Session
		WebDriver driver = new ChromeDriver();
		
		//2. Establish a  Wait strategy
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

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
        System.out.println(message);
        
        // 8. End Session
		driver.quit();
	}
}