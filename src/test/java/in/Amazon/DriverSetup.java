package in.Amazon;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class DriverSetup 
{
	WebDriver driver;
	

	
	public void getWebDriver(WebDriver driver)
	{
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}

}
