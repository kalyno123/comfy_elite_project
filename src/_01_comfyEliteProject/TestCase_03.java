package _01_comfyEliteProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase_03 {
    public static void main(String[] args) {

    /*Test Case 3: Validate ComfyElite Contact Us page "Contact Us" "SEND US A MESSAGE" form headings.
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see heading2 as "Contact Us"
        And user should be able to see heading4 as "SEND US A MESSAGE"
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

        // ** And user should be able to see heading2 as "Contact Us"
        WebElement h2ContactUs = driver.findElement(By.cssSelector("h2[data-aid='CONTACT_SECTION_TITLE_REND']"));
        System.out.println(h2ContactUs.isDisplayed() ? "User IS able to see Contact Us heading" : "User NOT able to see Contact Us heading");

        // ** And user should be able to see heading4 as "SEND US A MESSAGE"
        WebElement h4SendMsg = driver.findElement(By.cssSelector("div[id=bs-9] h4"));
        System.out.println(h4SendMsg.isDisplayed() ? "User IS able to see SEND US A MESSAGE heading" : "User NOT able to see SEND US A MESSAGE heading");




        Driver.quitDriver();

    }
}
