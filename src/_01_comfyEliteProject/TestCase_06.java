package _01_comfyEliteProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase_06 {
    public static void main(String[] args) {
    /* Test Case 6: Validate ComfyElite Contact Us page "SEND" button.
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate "SEND" button is displayed and clickable
        And validate button text is displayed as “SEND”
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

        // ** And validate "SEND" button is displayed and clickable
        WebElement sendButton = driver.findElement(By.cssSelector("button[data-aid='CONTACT_SUBMIT_BUTTON_REND']"));
        System.out.println(sendButton.isDisplayed() && sendButton.isEnabled() ?
                "User IS able to see the send button and it's clickable" : "User NOT able to see the send button and it's NOT clickable");

        // ** And validate button text is displayed as “SEND”
        System.out.println(sendButton.getText().equals("SEND") ?
                "Send Button label is VALID" : "Send Button label is INVALID");


        Driver.quitDriver();

    }
}
