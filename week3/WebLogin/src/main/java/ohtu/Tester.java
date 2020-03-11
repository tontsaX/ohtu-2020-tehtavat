package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "chromedriver"); 
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

//        logInValidUserAndPassword(driver);

//        logInValidUserAndInvalidPassword(driver);
        
        createNewUserAndLogOut(driver);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
    
    private static void logInValidUserAndPassword(WebDriver driver) {
    	WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        
        element.submit();
        
    	sleep(3);
    }
    
    private static void logInValidUserAndInvalidPassword(WebDriver driver) {
    	WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        
        element.submit();
        
    	sleep(3);
    }
    
    private static void createNewUserAndLogOut(WebDriver driver) {
    	WebElement element = driver.findElement(By.linkText("register new user"));
    	element.click();
    	
    	sleep(2);
    	
    	Random r = new Random();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("taneli"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("ilenat");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ilenat");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        
        element.submit();
        
        sleep(2);
        
        logoutAfterSignUp(element, driver);
        
        sleep(3);
    }
    
    private static void logoutAfterSignUp(WebElement element, WebDriver driver) {
    	element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
}
