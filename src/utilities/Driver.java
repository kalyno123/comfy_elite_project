package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // PRIVATE CONSTRUCTOR SO THIS OBJECT CAN'T BE CREATED OUTSIDE THIS CLASS (singleton)
    private Driver(){

    }

    // PRIVATE INSTANCE VARIABLE SO THIS ATTRIBUTE CAN'T BE MODIFIED OUTSIDE THIS CLASS (encapsulation)
    private static WebDriver driver;

    // PUBLIC GET DRIVER METHOD (encapsulation)
    public static WebDriver getDriver(){

        if (driver == null){ // if driver is not create (empty) then create a driver object ... otherwise just return the already existing driver.
            System.setProperty("webdriver.chromedriver", "/Users/ngo/IdeaProjects/Selenium_Intro/chromedriver"); // TELLING THE SYSTEM WHERE THE CHROME DRIVER IS LOCATED
            driver = new ChromeDriver(); // CREATE OBJECT OF WEB BROWSER (polymorphism)
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // WAITING FOR THE WEB ELEMENT TO LOAD
        }
        return driver;
    }

    // PUBLIC QUIT DRIVER METHOD
    public static void quitDriver(){
        if (driver != null){ // this method is to teardown driver completely
            driver.manage().deleteAllCookies(); // deleting stored data from session
            driver.quit();
            driver = null;
        }
    }




}
