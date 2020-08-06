//Goto HomePage

package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearningWindows
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Window.html");
		/*		
		//-----------------------------------------------------------------------------
		//Goto Home Page
		driver.findElementByXPath("//button[text() = 'Open Home Page']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		System.out.println("No of windows in Goto Home Page : " + listHandles.size());
		String newWindow = listHandles.get(1);
		
		driver.switchTo().window(newWindow);
		driver.findElementByXPath("//h5[text() = 'Button']").click();
		String baseWindow = listHandles.get(0);
		driver.switchTo().window(baseWindow);
		//------------------------------------------------------------------------------
		*/
		
		/*
		//------------------------------------------------------------------------------
		//Open Multiple Windows
		driver.findElementByXPath("//button[text() = 'Open Multiple Windows']").click();
		Set<String> wHandles = driver.getWindowHandles();
		List<String> lHandles = new ArrayList<String>(wHandles);
		System.out.println("Number of opened windows : " + lHandles.size() );
		
		//Close All windows Except BaseWindow
		String bWindow = lHandles.get(0);
		for (String eachHandle : lHandles) 
		{
			driver.switchTo().window(eachHandle);
			if(!eachHandle.equals(bWindow))
			{
				driver.switchTo().window(eachHandle).close();
			}
		}
		//-------------------------------------------------------------------------------
        */
		
		/*
		//-------------------------------------------------------------------------------
		//Close All Window, Except this window
		driver.findElementByXPath("//button[text() = 'Do not close me ']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String mainWindow = listHandles.get(0);
		for (String eachWindow : listHandles)
		{
			driver.switchTo().window(eachWindow);
			if(!eachWindow.equals(mainWindow))
			{
				System.out.println(driver.getTitle());
			}
			else
			{
				driver.switchTo().window(mainWindow).close();
			}

		}
		//----------------------------------------------------------------------------------
		*/
		
		//Wait for 5 seconds to open a window
		driver.findElementByXPath("//button[text() = 'Wait for 5 seconds']").click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				
	}

}
