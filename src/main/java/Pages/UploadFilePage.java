package Pages;

import Utils.Wait;
import Weblocators.UploadFileElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class UploadFilePage {
    private WebDriver driver;
    public UploadFilePage(WebDriver driver){
        this.driver = driver;
    }

    private By uploadPdfBtn = By.cssSelector(UploadFileElements.uploadPDFFile);
    private By uploadImageBtn = By.cssSelector(UploadFileElements.uploadImage);
    private By nextBtn = By.cssSelector(UploadFileElements.nextBtn);

    public void uploadImageFile() throws AWTException, InterruptedException {
        Wait.waitForPresenceOfElementVisibleBy(uploadImageBtn,driver);
        driver.findElement(uploadImageBtn).click();
        Wait.waitForPresenceOfElementVisibleBy(By.xpath("(//iframe)[2]"),driver);
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);
        Wait.waitForElementVisible(driver.findElement(By.xpath("//div[text()='My Drive']")),driver);
        driver.findElement(By.xpath("//div[text()='My Drive']")).click();
        Thread.sleep(3000);
        List<WebElement> imges = driver.findElements(By.cssSelector("div[aria-label='khi2Lahr.PNG']"));
        imges.get(imges.size()-1).click();
        Thread.sleep(3000);
        Wait.waitForElementVisibleBy(By.xpath("//div[@aria-disabled='false'and text()='Select']"),driver);
        driver.findElement(By.xpath("//div[@aria-disabled='false'and text()='Select']")).click();
        driver.switchTo().defaultContent();

    }

    public void uploadPDFFile() throws InterruptedException {
        Wait.waitForPresenceOfElementVisibleBy(uploadPdfBtn,driver);
        driver.findElement(uploadPdfBtn).click();
        Wait.waitForPresenceOfElementVisibleBy(By.xpath("(//iframe)[4]"),driver);
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(iframe);
        Wait.waitForElementVisible(driver.findElement(By.xpath("//div[text()='My Drive']")),driver);
        driver.findElement(By.xpath("//div[text()='My Drive']")).click();
        Thread.sleep(3000);
        List<WebElement> pdf = driver.findElements(By.cssSelector("div[aria-label='Automation Assignment.pdf']"));
        pdf.get(0).click();
        Wait.waitForElementVisibleBy(By.xpath("//div[@aria-disabled='false'and text()='Select']"),driver);
        driver.findElement(By.xpath("//div[@aria-disabled='false'and text()='Select']")).click();
        driver.switchTo().defaultContent();

    }

    public void clickOnnextBtn(){
        Wait.waitForElementVisibleBy(nextBtn,driver);
        driver.findElement(nextBtn).click();
    }

}


