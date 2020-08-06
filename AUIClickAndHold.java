package week4.day1.assignments;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AUIClickAndHold
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		
		WebElement ele = driver.findElementByTagName("iframe");
		driver.switchTo().frame(ele);
		
		WebElement Item1 = driver.findElementByXPath("//li[text() = 'Item 1']");
		Point location = driver.findElementByXPath("//li[text() = 'Item 4']").getLocation();
		int X = location.getX();
		int Y = location.getY();
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(Item1, X, Y).perform();
		Thread.sleep(2000);

	}

}
