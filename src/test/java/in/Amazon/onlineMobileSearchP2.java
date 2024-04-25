package in.Amazon;




import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class onlineMobileSearchP2
{
	public WebDriver driver;
	public List<WebElement>options;
	WebElement searchResults;
	

	public String s_option;
	
	//Constructor
		onlineMobileSearchP2(WebDriver driver)
		{
			this.driver=driver;
		}
		
		//locators
		By search_result=By.className("a-section");
		By sort_list=By.className("a-dropdown-label");
		By sortbox = By.className("a-dropdown-item");
		By option=By.className("a-dropdown-prompt");
		
		
		//Action methods
		public String searchResult() {
			searchResults = driver.findElement(search_result);
	        String searchText = searchResults.getText();
	        return searchText;
	        
		}

		public int countSortList()
		{
			driver.findElement(sort_list).click();
			
			options=driver.findElements(sortbox);
			return options.size();
			
		}
		public void sortList(String text)
		{
			 
			for(int i =0;i<options.size();i++)
			{
				
				if(options.get(i).getText().equals(text))
				{
					options.get(i).click();
				}
			}

		}
		
		public String verifySelectedOption() 
		{
			

          		s_option=driver.findElement(option).getText();

			return s_option;
      	}
		

		

}
