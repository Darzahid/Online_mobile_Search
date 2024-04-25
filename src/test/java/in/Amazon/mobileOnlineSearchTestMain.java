package in.Amazon;


	
import java.io.IOException;

import java.util.Scanner;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;
	public class mobileOnlineSearchTestMain 
	{
		
		  static WebDriver driver;
		onlineMobileSearchP1  oms1;
		onlineMobileSearchP2  oms2;
		DriverSetup ds;
		String count,range,act_Text,pattern,patt ;
		
		
		
//		Setting up the browser
		
			public void createWebDriver() 
			{
				 
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the browser you want to use Chrome/Edge:");
				String browser = sc.next().toLowerCase();
				
				if(browser.equals("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(browser.equals("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				ds = new DriverSetup();
				ds.getWebDriver(driver);
				sc.close();
				
				
			}
		
//			Entering and Browsing the Search String in search box
			
			public void testSearch() {
				oms1=new onlineMobileSearchP1(driver);
				oms1.search();
			}
			
//         validating the result String whether it contains the entered search String
		
			
			public void validateSearchText() 
			{
				oms2=new onlineMobileSearchP2(driver);
				  act_Text =oms2.searchResult();
				 System.out.println("Search result: "+act_Text);
				 if(act_Text.contains("mobile smartphones under 30000"))
				 {
					 System.out.println("the search string-Test Passed");
					 }else
					 {
						 System.out.println("the search string-Test Failed");
					 }
				 
			        
					 
			}
			
//			validating the number of pages(example:-1-16)
			
			public void validateNoOfPages() 
			{
				 String [] arr = act_Text.split(" ");
			        patt= "[0-9-]+";
			        range=arr[0];
			        System.out.println("Number of pages: "+range);

			        if(range.matches(patt))
			        {
			        	System.out.println("Number of pages,Test passed");
			        }
			        else
			        {
			        	System.out.println("Number of pages,Test failed");
			        }
			        
				
			}
			
//			validating number of items 
			
			public void validateNoOfitems() 
			{
				String [] arr = act_Text.split(" ");
		         pattern = "[0-9]+";
		        if(act_Text.contains("over"))
		        {
		        	
		        	count=arr[3];
		        }
		        else
		        {
		        	
		        	count=arr[2];
		        }
		        System.out.println("Number of items: "+count);
		        count = count.replaceAll(",", "");
		        if(count.matches(pattern))
		        {
		        	System.out.println("Number of items,Test passed");
		        }
		        else
		        {
		        	System.out.println("Number of items,Test failed");
		        }
		        
		        
			}
			
//			checking whether the sort list displays proper count 
			
			public void testCountSortList()
			{  
			  int act_count=oms2.countSortList();
			
			  int exp_count =4;
			  if(act_count==exp_count)
			  {
				  System.out.println("sortList Count "+(act_count)+" ,Test Passed");
			  }
			  else
			  {
				  System.out.println("sortList Count "+(act_count)+" ,Test Failed");
			  }
			}
			
//			selecting the "Newest Arrivals" from the sort list
			
			 public void testSortList() {
				
				
				 oms2.sortList("Newest Arrivals");
			}
			 
//			 checking whether the "Newest Arrivals"option is selected properly or not
			 
			public void testSelectedOption() {
				
				 String option =oms2.verifySelectedOption();
				 System.out.println("Selected option is: "+option);
				 if(option.equals("Newest Arrivals"))
				 {
					 System.out.println("Newest Arrivals selected,Test Passed");
				 }
				 else
				 {
					 System.out.println("Newest Arrivals not selected,Test Failed");
				 }
			}
			
			
			
//			closing the browser
			
			 public void closeBrowser() 
			{
				driver.quit();
				System.out.println("Browser is closed..");
			
		
		}
			
			
			
			public static void main(String [] args) throws IOException 
			{
				 mobileOnlineSearchTestMain m = new mobileOnlineSearchTestMain();
				 m.createWebDriver();
				 m.testSearch();
				 m.validateSearchText();
				 m.validateNoOfPages();
				 m.validateNoOfitems();
				 m.testCountSortList(); 
			     m.testSortList();
	             m.testSelectedOption();
	             m.closeBrowser();
			}

	
		
	}




