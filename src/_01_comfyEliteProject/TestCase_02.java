package _01_comfyEliteProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.awt.image.ImageWatched;
import utilities.Driver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestCase_02 {
    public static void main(String[] args) {

     /* Test Case 2: Validate ComfyElite Contact Us page "Connect With Us" section.
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see heading1 as "Connect With Us"
        And user should be able to see “Facebook” icon and hyperlink reference for it should be “https://www.facebook.com/103179127717601”
        And user should be able to see “Instagram” icon and hyperlink reference for it should be “https://www.instagram.com/comfyelite”
     */

        // ** Given user navigates to “https://comfyelite.com/”
        WebDriver driver = Driver.getDriver(); // setup driver object
        driver.get("https://comfyelite.com/");

        // ** When user clicks on “CONTACT US” link in the header
        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']")); // this element is 1/2 (index=1)
        contactUsLink.click();

        // ** Then user should be navigated to “CONTACT US” page
        System.out.println(driver.getCurrentUrl().equals("https://comfyelite.com/contact-us") ?
                "User IS on Contact Us page" : "User is NOT on Contact Us page");

        // ** And user should be able to see heading1 as "Connect With Us"
        WebElement h1TagLine = driver.findElement(By.cssSelector("h1[role='heading']"));
        System.out.println(h1TagLine.isDisplayed() ?
                "User IS able to see h1 TagLine" : "User is NOT able to see h1 TagLine");

        // ** And user should be able to see “Facebook” icon and hyperlink reference for it should be “https://www.facebook.com/103179127717601”
        // ** And user should be able to see “Instagram” icon and hyperlink reference for it should be “https://www.instagram.com/comfyelite”
        List<WebElement> socialMediaIcons = driver.findElements(By.xpath("//div[@data-aid='SOCIAL_SOCIAL_LINKS']/a"));
        //System.out.println(socialMediaIcons.size()); // 2; THIS IS TO SEE HOW MANY ELEMENTS ARE ON MY LIST
        String[] socials = {"facebook", "instagram"};
        String[] socialsLinks = {"https://www.facebook.com/103179127717601", "https://www.instagram.com/comfyelite"};

        for (int i = 0; i < socialMediaIcons.size(); i++){
            System.out.println(socialMediaIcons.get(i).isDisplayed() && socialMediaIcons.get(i).getAttribute("href").equals(socialsLinks[i]) ?
                    "User IS able to see " + socials[i] + " icon and hyperlink reference is VALID" :
                    "User is NOT able to see " + socials[i] + " icon and hyperlink reference is INVALID");
        }

        /*
        // ** And user should be able to see “Facebook” icon and hyperlink reference for it should be “https://www.facebook.com/103179127717601”
        WebElement fbIcon = driver.findElement(By.cssSelector("div[data-aid='SOCIAL_SOCIAL_LINKS']>a")); // ASK AKIN: //svg[@data-ux="IconSocial"]/..
        System.out.println(fbIcon.isDisplayed() && fbIcon.getAttribute("href").equals("https://www.facebook.com/103179127717601") ?
                "User IS able to see fb icon and hyperlink reference is VALID" : "User is NOT able to see fb icon and hyperlink reference is INVALID");

        // ** And user should be able to see “Instagram” icon and hyperlink reference for it should be “https://www.instagram.com/comfyelite”
        WebElement igIcon = driver.findElement(By.cssSelector("a[aria-label='Instagram Social Link']"));
        System.out.println(igIcon.isDisplayed() && igIcon.getAttribute("href").equals("https://www.instagram.com/comfyelite") ?
                "User IS able to see ig icon and hyperlink reference is VALID" : "User is NOT able to see ig icon and hyperlink reference is INVALID");
        */


        Driver.quitDriver();


    }
}
