package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForAppear
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/appear.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'btn']/b")));
		
		String text = driver.findElementByXPath("//b[contains(text() , 'Voila')]").getText();
		System.out.println(text);
		
		if(text.contains("Voila"))
		{
			System.out.println("Got the text");
		}
		else
		{
			System.out.println("Didnot get the text");
		}
		driver.close();
		driver.quit();
	}

}
