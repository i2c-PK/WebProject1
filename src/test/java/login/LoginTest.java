package login;		

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
 

public class LoginTest  {
	
	
	private WebDriver driver;		
	
	@Test				
	public void testLogin() {	
		/*driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page"));*/
		
		  // Navigate to a web page
	    driver.get("http://localhost:8081/WebProject1/login.jsp");

	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement usernameElement     = driver.findElement(By.name("username"));
	    WebElement passwordElement     = driver.findElement(By.name("password"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	 
	    usernameElement.sendKeys("Ali");
	    passwordElement.sendKeys("Imran");
	 
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
	    String successMsg             = "This is valid user";
	    Assert.assertEquals (message, successMsg);
	 		
		
	}	
	
	@BeforeTest
	public void beforeTest() {	
		System.setProperty("webdriver.gecko.driver", "c:\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();  
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}
	
	
  public static void main(String[] args) {
 	  
	  System.setProperty("webdriver.gecko.driver", "c:\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
    // Create an instance of the driver
    WebDriver driver = new FirefoxDriver();
 
    // Navigate to a web page
    driver.get("localhost:8081/WebProject1/login.jsp");
 
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // Perform actions on HTML elements, entering text and submitting the form
    WebElement usernameElement     = driver.findElement(By.name("username"));
    WebElement passwordElement     = driver.findElement(By.name("password"));
    WebElement formElement        = driver.findElement(By.id("loginForm"));
 
    usernameElement.sendKeys("Ali");
    passwordElement.sendKeys("Imran");
 
    //passwordElement.submit(); // submit by text input element
    formElement.submit();        // submit by form element
 
 
    // Anticipate web browser response, with an explicit wait
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement messageElement = wait.until(
           ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
            );
 
    // Run a test
    String message                 = messageElement.getText();
    String successMsg             = "This is valid user";
    Assert.assertEquals (message, successMsg);
 
    // Conclude a test
    driver.quit();
 
  }
}