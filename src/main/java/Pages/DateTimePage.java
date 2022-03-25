package Pages;

import Utils.Wait;
import Weblocators.DateTimeElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimePage {
    private WebDriver driver;
    public DateTimePage(WebDriver driver){
        this.driver = driver;
    }

    private By Hour = By.cssSelector(DateTimeElement.Hours);
    private By mint = By.cssSelector(DateTimeElement.Mint);
    private By dateField = By.cssSelector(DateTimeElement.date);
    private By submitBtn = By.cssSelector(DateTimeElement.submitBtn);

    public void enterTime(){
        String[] time = getTime();
        Wait.waitForElementVisibleBy(Hour,driver);
        Wait.waitForElementVisibleBy(mint,driver);
        driver.findElement(Hour).click();
        String js = "arguments[0].setAttribute('value','"+time[0]+"')";
        ((JavascriptExecutor) driver).executeScript(js, driver.findElement(Hour));
        Wait.waitForPresenceOfElementClickableBy(Hour,driver);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Hour)).click().perform();
        driver.findElement(Hour).sendKeys(time[0]);
        String mintvalue = "arguments[0].setAttribute('value','"+time[1]+"')";
        ((JavascriptExecutor) driver).executeScript(mintvalue, driver.findElement(mint));
        builder.moveToElement(driver.findElement(mint)).click().perform();
        driver.findElement(mint).sendKeys(time[1]);

    }

    public void enterDate(){
       String date = getDate();
       System.out.println("Date Value::"+date);
        Wait.waitForElementVisibleBy(dateField,driver);
        String js = "arguments[0].setAttribute('data-initial-value','"+date+"')";
        ((JavascriptExecutor) driver).executeScript(js, driver.findElement(dateField));
        driver.findElement(dateField).sendKeys(date);
    }

    public String[] getTime(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String dateValue = dateFormat.format(date);
        String[] gettime = dateValue.split(" ");
        String currentTime = gettime[1];
        String[] HourAndMint = currentTime.split(":");
        return HourAndMint;
    }

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String dateValue = dateFormat.format(date);
        String[] splitDate = dateValue.split(" ");
        String currentdate = splitDate[0].replace("/","");
        return currentdate;
    }

    public void clickOnSubmitBtn(){
        Wait.waitForElementVisibleBy(submitBtn,driver);
        driver.findElement(submitBtn).click();
    }
}
