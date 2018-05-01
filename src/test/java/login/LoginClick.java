package login;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
 

public class LoginClick  {
	
	
	private WebDriver driver;		
	
					
	public void testLogin() throws InterruptedException {
		//@Test
		/*driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page"));*/

		System.out.println("In testLogin()");
	    try {

		  // Navigate to a web page
	
	    driver.get("http://127.0.0.1:8081/WebProject1/login.jsp");

			Thread.sleep(5000);
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement usernameElement     = driver.findElement(By.name("username"));
	    WebElement passwordElement     = driver.findElement(By.name("password"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	 
	    usernameElement.sendKeys("Wrong User");
	    passwordElement.sendKeys("Wrong Pwd");
	 
	    //passwordElement.submit(); // submit by text input element
	    formElement.submit();        // submit by form element
	 
	 
	    // Anticipate web browser response, with an explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	           ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	            );
	 
	    //driver.findElement(By.xpath(".//*[@id='login']/a")).click();

        
	    // Run a test
	    String message                 = messageElement.getText();
	    AssertJUnit.assertTrue(true); 
	    String successMsg             = "This is In-valid user";
		
		System.out.println("Actul: " + message);
	    System.out.println("Expected: " + successMsg);
		
	    
	    AssertJUnit.assertEquals (message, successMsg);
	 		
		} 
	    catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
	    catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  Assert.fail("  ");
			 // throw e;
		}
		
	}	
	
	
	@BeforeClass
	public void beforeClassTest() {	
		
		try
		{		
		System.out.println("In beforeClassTest()");
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
	}
	
	@BeforeTest
	public void beforeTest() {	
		
		System.out.println("In beforeTest()");
		try
		{		
		System.setProperty("webdriver.gecko.driver", "c:\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
	}		
	@AfterTest
	public void afterTest() {
		System.out.println("In afterTest()");
		try
		{		
				driver.quit();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
	}
	
	  
	  
}