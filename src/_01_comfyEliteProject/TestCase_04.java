package _01_comfyEliteProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class TestCase_04 {
    public static void main(String[] args) {

    /* Test Case 4: Validate ComfyElite Contact Us page "SEND US A MESSAGE" form.
        Given user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And validate "First Name" input box
        And validate "Last Name" input box
        And validate "Email" input box
        And validate "Message" input box
    NOTE: Input validation includes input being displayed and user being able to send keys to input box. It also requires validating the given labels and placeholders.
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
        /*
        // ** And validate "First Name" input box
        WebElement inputFName = driver.findElement(By.cssSelector("input[data-aid='First Name']")); // ALSO CAN USE: xpath(//form[@data-ux="Form"]//input)[2]
        WebElement fNameLabel = driver.findElement(By.xpath("//label[text()='First Name*']"));
        inputFName.sendKeys("KALY");
        System.out.println(inputFName.isDisplayed() && fNameLabel.getText().equals("First Name*") && inputFName.getAttribute("value").equals("KALY") ?
                "User IS able to see first name input box, the input box label is VALID and it IS typeable" :
                "User is NOT able to see first name input box, the input box label is INVALID and it is NOT typeable");

        // ** And validate "Last Name" input box
        WebElement inputLName = driver.findElement(By.cssSelector("input[data-aid='Last Name']"));
        WebElement lNameLabel = driver.findElement(By.xpath("//label[text()='Last Name*']"));
        inputLName.sendKeys("NGO");
        System.out.println(inputLName.isDisplayed() && lNameLabel.getText().equals("Last Name*") && inputLName.getAttribute("value").equals("NGO") ?
                "User IS able to see last name input box, the input box label is VALID and it IS typeable" :
                "User is NOT able to see last name input box, the input box label is INVALID and it is NOT typeable");

        // ** And validate "Email" input box
        WebElement inputEmail = driver.findElement(By.cssSelector("input[data-aid='CONTACT_FORM_EMAIL']"));
        WebElement emailLabel = driver.findElement(By.xpath("//label[text()='Email*']"));
        inputEmail.sendKeys("chriskaly.ngo@gmail.com");
        System.out.println(inputEmail.isDisplayed() && emailLabel.getText().equals("Email*") && inputEmail.getAttribute("value").equals("chriskaly.ngo@gmail.com") ?
                "User IS able to see email input box, the input box label is VALID and it IS typeable" :
                "User is NOT able to see email input box, the input box label is INVALID and it is NOT typeable");

        // ** And validate "Message" input box
        WebElement messageTextArea = driver.findElement(By.cssSelector("textarea[role='textbox']"));
        messageTextArea.sendKeys("I LOVE SELENIUM");
        System.out.println(messageTextArea.isDisplayed() && messageTextArea.getAttribute("placeholder").equals("Message*") && messageTextArea.getText().equals("I LOVE SELENIUM") ?
                "User IS able to see message text area, the message label is VALID and it IS typeable" :
                "User is NOT able to see message text area, the message label is INVALID and it is NOT typeable");
        */
        // ** NOTE ID'S FOR THE INPUT BOXES ARE DYNAMIC BUT ALWAYS STARTSWITH/CONTAINS "INPUT" **


        List<WebElement> formInputBoxes = driver.findElements(By.cssSelector("input[id^='input']"));
        List<WebElement> formInputLabels = driver.findElements(By.xpath("//input[starts-with(@id, 'input')]/../label"));
        //System.out.println(formInputBoxes.size()); // 3 --> THIS IS TO CHECK IF THE LOCATOR FOUND 3 ELEMENTS
        //System.out.println(formInputLabels.size()); // 3
        String[] inputBox = {"first name", "last name", "email"};
        String[] inputLabels = {"First Name*", "Last Name*", "Email*"};
        String[] testDatas = {"Kaly", "Ngo", "chriskaly.ngo@gmail.com"};

        for (int i = 0; i < formInputBoxes.size(); i++){
            formInputBoxes.get(i).sendKeys(testDatas[i]);
            System.out.println(formInputBoxes.get(i).isDisplayed() && formInputLabels.get(i).getText().equals(inputLabels[i]) && formInputBoxes.get(i).getAttribute("value").equals(testDatas[i]) ?
                    "User IS able to see " + inputBox[i] + " input box, the input box label is VALID and it IS typeable" :
                    "User is NOT able to see " + inputBox[i] + " input box, the input box label is INVALID and it is NOT typeable");
        }



        Driver.quitDriver();

    }
}
