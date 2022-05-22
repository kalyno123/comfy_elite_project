package _01_comfyEliteProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase_05 {
    public static void main(String[] args) throws InterruptedException {

    /* Test Case 5: Validate ComfyElite Contact Us page "Sign up for our email list.
        for updates, promotions, and more." Checkbox
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate the check-box for "Sign up for our email list for updates, promotions, and more."
    Note: Check-box validation includes check-box being selected and deselected by user.
    */

        // ** Given user navigates to “https://comfyelite.com/”
        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");

        // ** When user clicks on “CONTACT US” link in the header
        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']")); // this element is 1/2 (index=1)
        contactUsLink.click();

        // ** Then user should be navigated to “CONTACT US” page
        System.out.println(driver.getCurrentUrl().equals("https://comfyelite.com/contact-us") ?
                "User IS on Contact Us page" : "User is NOT on Contact Us page");

        Thread.sleep(2000);
        // ** And validate the check-box for "Sign up for our email list for updates, promotions, and more."
        WebElement signUpCheckBox = driver.findElement(By.xpath("(//input[@role='textbox'])[4]"));
        WebElement checkBox = driver.findElement(By.xpath("(//div[@data-ux='Element'])[2]"));

        Thread.sleep(2000);
        System.out.println(checkBox.isDisplayed() ? "User IS able to see the checkbox to subscribe" : "User is NOT able to see the checkbox to subscribe");
        System.out.println(!signUpCheckBox.isSelected() ? "Check box IS deselected" : "Check box IS selected");// should return false(deselected) here

        checkBox.click(); // clicking on the checkbox to select it
        Thread.sleep(2000);
        System.out.println(signUpCheckBox.isSelected() ? "Check box IS selected" : "Check box IS deselected");// should return true(selected) here

        checkBox.click();
        Thread.sleep(2000);
        System.out.println(!signUpCheckBox.isSelected() ? "Check box IS deselected" : "Check box IS selected");// should return false(deselected) here



        Driver.quitDriver();

    }
}
