package in.Amazon;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class onlineMobileSearchP1 
{
	public WebDriver driver;
	public WebElement searchBox;
	
	

	//Constructor
	onlineMobileSearchP1(WebDriver driver){
		this.driver=driver;
	}
	
	    //locators
		By search_text=By.id("twotabsearchtextbox");
		

		  
		//Action methods
		public void search(){
			searchBox = driver.findElement(search_text);
	        searchBox.sendKeys("mobile smartphones under 30000");
	        searchBox.submit();
		}
		
		
		
		
}
