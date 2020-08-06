package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForDisappear
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/disapper.html");
		
		//Syntax: WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id = 'btn']/b")));
		
		String text = driver.findElementByXPath("//div[@class = 'disappear']//p/strong").getText();
		System.out.println(text);
		
		if(text.contains("disappeared"))
		{
			System.out.println("Got the text");
		}
		else
		{
			System.out.println("Didnot get the text");
		}
	}

}
