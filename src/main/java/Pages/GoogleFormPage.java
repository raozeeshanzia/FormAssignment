package Pages;

import Utils.Wait;
import Weblocators.GoogleFormElement;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class GoogleFormPage {

    private static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public GoogleFormPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailField= By.cssSelector(GoogleFormElement.email);
    private By cnicField = By.cssSelector(GoogleFormElement.cnic);
    private By nameField = By.cssSelector(GoogleFormElement.name);
    private By phoneNumberField = By.cssSelector(GoogleFormElement.phoneNumber);
    private  By googleEmailField = By.cssSelector(GoogleFormElement.gooEmail);
    private  By googlePasswordField = By.cssSelector(GoogleFormElement.gooPassword);
    private By emailNextBtn = By.cssSelector(GoogleFormElement.emailNextId);
    private  By passwordNextBtn = By.cssSelector(GoogleFormElement.passwordNextBtn);
    private By questionPageHeading = By.cssSelector(GoogleFormElement.questionHeadingPage);
    private By firstPageHeading = By.cssSelector(GoogleFormElement.firstPageHeading);
    private By firstPageNextBtn = By.cssSelector(GoogleFormElement.firstPageNextbtn);
    private By clearFormBtn = By.cssSelector(GoogleFormElement.clearFormbtn);
    private By alertMeaasge = By.cssSelector(GoogleFormElement.alertMessage);
    private By popUpClearBtn = By.cssSelector(GoogleFormElement.secondClearBtn);

    //this method is used to enter username
    public void enterUserName(String username){
        Wait.waitForElementVisibleBy(nameField,driver);
        WebElement usernameField = driver.findElement(nameField);
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(nameField));
        usernameField.sendKeys(username);
    }

    //this method is used for enter cnic number
    public void enterCNIC(String cnicNumber){
        Wait.waitForElementVisibleBy(cnicField,driver);
        WebElement cnicText = driver.findElement(cnicField);
        cnicText.sendKeys(cnicNumber);
    }

    //this method is used for enter phone number
    public void enterPhoneNumber(String contact){
        Wait.waitForElementVisibleBy(phoneNumberField,driver);
        WebElement contactField = driver.findElement(phoneNumberField);
        contactField.sendKeys(contact);
    }


    //this method is used for enter email in tha first page
    public void enterEmail(String email){
        Wait.waitForElementVisibleBy(emailField,driver);
        WebElement emailenterField = driver.findElement(emailField);
        emailenterField.sendKeys(email);
    }

    //this method is used for verification that user is on assessment page
    public void verifyUserIsOnAssessmentPage(){
      //  WebElement page = driver.findElement(firstPageHeading);
        Wait.waitForElementVisibleBy(firstPageHeading,driver);
        Assert.assertEquals(driver.findElement(firstPageHeading).getText(),"Automation Assessment");
        scrollPage();
    }

    //this method is used to scroll Page
    public void scrollPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        clickOnClearFormBtn();
    }

    //this method is used to verify that user is on question page
    public void verifyUserIsQuestionPage(){
        Wait.waitForElementVisibleBy(questionPageHeading,driver);
        Wait.waitForPresenceOfElementVisibleBy(questionPageHeading,driver);
        WebElement questPage = driver.findElement(questionPageHeading);
        Assert.assertTrue(questPage.isDisplayed());
    }

    //this method is used to click on next btn available on first page
    public void clickOnNextBtn(){
        Wait.waitForElementVisibleBy(firstPageNextBtn,driver);
        WebElement firstNextbtn = driver.findElement(firstPageNextBtn);
        firstNextbtn.click();
    }

    //this method is used for clear already fill data of google form
    public void clickOnClearFormBtn(){

        Wait.waitForElementVisibleBy(clearFormBtn,driver);
        WebElement clearBtn = driver.findElement(clearFormBtn);
        clearBtn.click();
        Wait.waitForElementVisibleBy(popUpClearBtn,driver);
        WebElement clearPopUpBtn = driver.findElement(popUpClearBtn);
        clearPopUpBtn.click();
    }

    //this method is used to initial login
    public void Login(String email,String password){
        driver.findElement(googleEmailField).sendKeys(email);
        driver.findElement(emailNextBtn).click();
        Wait.waitForElementVisibleBy(googlePasswordField,driver);
        driver.findElement(googlePasswordField).sendKeys(password);
        driver.findElement(passwordNextBtn).click();
    }

    //this method is used to verify alert Message is displaye
    public void alertMessageIsDisplay(String message){
        WebElement alert = driver.findElement(alertMeaasge);
        Wait.waitForElementVisible(alert,driver);
        Assert.assertEquals(alert.getText(),message);
    }

}
