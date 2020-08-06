package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunWithFrames
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		
		//I am inside a frame
		driver.switchTo().frame(0);		
		driver.findElementByXPath("//button[@id = 'Click']").click();
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//I am inside a nested frame
		WebElement frame1 = driver.findElementByXPath("//section[@class = 'innerblock']/div[2]/iframe[1]");
		driver.switchTo().frame(frame1);
		driver.switchTo().frame(0);
		driver.findElementByXPath("//button[@id = 'Click1']").click();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		
				
		int size = driver.findElementsByTagName("iframe").size();
		System.out.println(size);
		int size3=size;
			
		for(int i=0;i<size;i++)
		{
			driver.switchTo().frame(i);
			int size2 = driver.findElementsByTagName("iframe").size(); // 0 1 1
			size3 = size3+size2;		// 3 4 5
			driver.switchTo().defaultContent();			
		}
		System.out.println("Total no. of frames in the webpage : " + size3);
		
		driver.close();
				
		}

}
