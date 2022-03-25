package Pages;

import Utils.Helper;
import Utils.Wait;
import Weblocators.CheckBoxElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class CheckBoxesPage {
    private WebDriver driver;
    public CheckBoxesPage(WebDriver driver){
        this.driver = driver;
    }

    private By selectNumberAns = By.cssSelector(CheckBoxElement.selectNUmber);
    private By checkboxPageHeading = By.cssSelector(CheckBoxElement.checkBoxHeading);
    private By nextBtn = By.cssSelector(CheckBoxElement.nextBtn);

    public void selectPrimeNumber(String[] rightAns){
        for (String ans:rightAns) {
            Wait.waitForPresenceOfElementVisibleBy(By.cssSelector(String.format(CheckBoxElement.primeNumber,ans)),driver);
            Wait.waitForElementVisibleBy(By.cssSelector(String.format(CheckBoxElement.primeNumber,ans)),driver);
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(By.cssSelector(String.format(CheckBoxElement.primeNumber,ans)))).click().perform();

          //  driver.findElement(By.cssSelector(String.format(CheckBoxElement.primeNumber,ans))).click();
        }
    }

    public void selectNumber(String[] rightAns){
        for (String ans:rightAns) {
            Wait.waitForPresenceOfElementVisibleBy(By.cssSelector(String.format(CheckBoxElement.selectNUmber,ans)),driver);
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(By.cssSelector(String.format(CheckBoxElement.selectNUmber,ans)))).click().perform();
            //driver.findElement(By.cssSelector(String.format(CheckBoxElement.selectNUmber,ans))).click();
        }
    }

    public void clickOnNextBtn(){
        Wait.waitForPresenceOfElementVisibleBy(nextBtn,driver);
        driver.findElement(nextBtn).click();
    }

    public void verifyUserIsOnCheckboxPage() throws InterruptedException {
        Wait.waitForPresenceOfElementVisibleBy(checkboxPageHeading,driver);
        Wait.waitForElementVisibleBy(checkboxPageHeading,driver);
        Helper.scrollPage(driver);
        Assert.assertTrue(driver.findElement(selectNumberAns).isDisplayed());
        //Assert.assertEquals(driver.findElement(checkboxPageHeading).getText(),"Page 3 of 6");
    }

}
