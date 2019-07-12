package seleniumWebDriver;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test2 {

	public static void execute2() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximaze the web browser
		driver.manage().window().maximize();
	
		//navigate to google.com URL
		driver.navigate().to("https://www.google.com");
		
		//insert input cheese in search input area and click Enter to search for input value 
		WebElement googleSearch = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
		googleSearch.sendKeys("cheese");
		googleSearch.sendKeys(Keys.ENTER);
		
		//collect the result of search
		String res=driver.findElement(By.cssSelector("#resultStats")).getText();
		System.out.println(res);
		
		//replace all from "Око 992.000.000 резултата (0,42 секунде/и)" except 992.000.000 to empty "" 
		int num =Integer.parseInt(res.replaceAll("\\D",""));
		System.out.println(num);
		 

		//compare results with 777
		Assertions.assertEquals(777, num);
		
		//if num is bigger then 777 we print message "There is too much chees on the internet"
		if (num>777) {
			message();
		}
		
		driver.close();
		driver.quit();
	}	
	
	
	//method to return the assertion message
	private static String message () {
	    return "There is too much chees on the internet";
	}
}
