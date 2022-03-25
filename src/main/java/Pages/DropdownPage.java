package Pages;

import Utils.Wait;
import Weblocators.DropdownElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DropdownPage {
    private WebDriver driver;
    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    private By punjabCap = By.cssSelector(DropdownElement.capitalPunjQues);
    private By pakCapital = By.cssSelector(DropdownElement.capitalPak);
    private By nextBtn = By.cssSelector(DropdownElement.nextBtn);


    public void chosePunCapital(String capital){
        Wait.waitForPresenceOfElementVisibleBy(punjabCap,driver);
       // Wait.waitForElementVisibleBy(punjabCap,driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(punjabCap));
        Wait.waitForPresenceOfElementClickableBy(punjabCap,driver);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(punjabCap)).doubleClick().perform();
        driver.findElement(punjabCap).click();
        Wait.waitForElementVisibleBy(By.cssSelector(String.format("[data-params*='Capital of Punjab'] div[role='listbox'] div[data-value='%s'][role='option']",capital)),driver);
        driver.findElement(By.cssSelector(String.format("[data-params*='Capital of Punjab'] div[role='listbox'] div[data-value='%s'][role='option']",capital))).click();
    }

    public void chosePakCapital(String capital){
        Wait.waitForPresenceOfElementVisibleBy(pakCapital,driver);
        Wait.waitForElementVisibleBy(pakCapital,driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(pakCapital));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(pakCapital)).doubleClick().perform();
        driver.findElement(pakCapital).click();
        Wait.waitForElementVisibleBy(By.cssSelector(String.format("[data-params*='Capital of Pakistan'] div[role='listbox'] div[data-value='%s'][role='option']",capital)),driver);
        driver.findElement(By.cssSelector(String.format("[data-params*='Capital of Pakistan'] div[role='listbox'] div[data-value='%s'][role='option']",capital))).click();
    }

    public void clickOnNextBtn(){
        Wait.waitForPresenceOfElementVisibleBy(nextBtn,driver);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(nextBtn)).click().perform();
        driver.findElement(nextBtn).click();

    }
}
