package week4.day1.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AUIDragAndDrop
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//Get into the frame
		WebElement e = driver.findElementByTagName("iframe");
		driver.switchTo().frame(e);
		
		//Create WebElement for source, target
		WebElement source = driver.findElementById("draggable");
		WebElement target = driver.findElementById("droppable");
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		Thread.sleep(2000);
	}

}
