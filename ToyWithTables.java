package week4.day1.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToyWithTables 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/table.html");
		
		//Counting Number of columns
		List<WebElement> columns = driver.findElementsByXPath("//table//tr//th");
		int count = columns.size();
		System.out.println("Number of Columns : " + count);
		
		//Counting Number of rows
		List<WebElement> rows = driver.findElementsByXPath("//table//tr");
		int count1 = rows.size();
		System.out.println("Number of rows : " + count1);
		
		//Get the Progress value of 'Learn to interact with elements'
		String ProgressValue = driver.findElementByXPath("//table//tr[3]//td[2]").getText();
		System.out.println("The Progress Value of Learn to Interact with Elements : " + ProgressValue);
		
		//Check the Vital Task for least completed progress
		//1. Getting all the elements in second column(Progress Value) and store it in list.
		List<Integer> values = new ArrayList<Integer>();
		for(int i =2; i<= count1;i++)
		{
			String text = driver.findElementByXPath("//table//tr["+i+"]//td[2]").getText();
			int val = Integer.parseInt(text.replaceAll("[^a-zA-Z0-9]", ""));  
			values.add(val);
		}
		System.out.println(values);
		
		//2. Sorting an array.
		Collections.sort(values);
		System.out.println("After sorting the values in the list: " + values);
		
		//3. Getting least number using foreach loop
		int smallest = values.get(0);
		for(int x : values )
		{
		   if (x == smallest)
		   {
		      smallest = x;
		   }
		}
		System.out.println("The Least number in the list : " + smallest);
		
		//To click on checkbox of Progress value 30%
		driver.findElementByXPath("//td[contains(text(), '"+smallest+"')]/following::td/input").click();
		
	}

}
