package _01_comfyEliteProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.*;

public class TestCase_01 {
    public static void main(String[] args) {

    /* Test Case 1: Validate ComfyElite Contact Us Page heading section.
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see ComfyElite logo
        And user should be able to see heading2 as “High quality comfy pillows and accessories for travel, office and home.”
        NOTE: THIS IS TEST CASE IS WRITTEN IN BEHAVIOR DRIVEN DEVELOPMENT(BDD) FORMAT(FRAMEWORK).
            BDD framework i.e. Behavior Driven Development is a software development approach that allows the tester/business analyst
            to create test cases in simple text language (English). The simple language used in the scenarios helps even non-technical
            team members to understand what is going on in the software project.
    */

        // **Given user navigates to “https://comfyelite.com/”
        WebDriver driver = Driver.getDriver(); // setup driver object
        driver.get("https://comfyelite.com/");

        // ** When user clicks on “CONTACT US” link in the header
        WebElement contactUsLink = driver.findElement(By.cssSelector("a[href='/contact-us']")); // this element is 1/3 (index=1)
        contactUsLink.click();

        // ** Then user should be navigated to “CONTACT US” page
        //String actualContactUsPage = driver.getCurrentUrl();
        //String expectedContactUsPage = "https://comfyelite.com/contact-us";
        System.out.println(driver.getCurrentUrl().equals("https://comfyelite.com/contact-us") ?
                "User IS on Contact Us page" : "User is NOT on Contact Us page");

        // And user should be able to see ComfyElite logo
        WebElement comfyEliteLogo = driver.findElement(By.cssSelector("img[data-ux='ImageLogo']"));
        System.out.println(comfyEliteLogo.isDisplayed() ?
                "User IS able to see ComfyElite logo" : "User is NOT able to see ComfyElite logo");

        //And user should be able to see heading2 as “High quality comfy pillows and accessories for travel, office and home.”
        WebElement h2TagLine = driver.findElement(By.id("dynamic-tagline-48605"));
        System.out.println(h2TagLine.isDisplayed() ?
                "User IS able to see h2 TagLine" : "User is NOT able to see h2 TagLine");





        Driver.quitDriver();








    }
}
