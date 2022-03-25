package Pages;

import Utils.Wait;
import Weblocators.MultipleQuestionElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleQuestionPage {
    private WebDriver driver;
    public MultipleQuestionPage(WebDriver driver){
        this.driver = driver;
    }

    private By FireBugQuestion = By.cssSelector(MultipleQuestionElement.useOfFireBug);
    private By nextBtn = By.cssSelector(MultipleQuestionElement.nextBtn);
    private By alertMessage = By.cssSelector(MultipleQuestionElement.alertMessage);

    public void enterFireBugAns(String ans){
        Wait.waitForPresenceOfElementVisibleBy(By.cssSelector(String.format(MultipleQuestionElement.useOfFireBug,ans)),driver);
        driver.findElement(By.cssSelector(String.format(MultipleQuestionElement.useOfFireBug,ans))).click();

    }

    public void enterNotLocatorAns(String ans){
        Wait.waitForPresenceOfElementVisibleBy(By.cssSelector(String.format(MultipleQuestionElement.typeOfLoc,ans)),driver);
        driver.findElement(By.cssSelector(String.format(MultipleQuestionElement.typeOfLoc,ans))).click();
    }

    public void verifyAlertMessage(){
        Wait.waitForPresenceOfElementVisibleBy(alertMessage,driver);
        Assert.assertEquals(driver.findElement(alertMessage).getText(),"This is a required question");
    }

    public void clickOnNextBtn(){
        Wait.waitForPresenceOfElementVisibleBy(nextBtn,driver);
        driver.findElement(nextBtn).click();
    }
}
