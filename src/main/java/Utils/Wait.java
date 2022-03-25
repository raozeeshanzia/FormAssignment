package Utils;

import Driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Wait {
    public static void waitForElementVisible(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitForElementVisibleBy(By loc, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));

    }

    public static void waitForPresenceOfElementVisibleBy(By loc, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loc));

    }

    public static void waitForPresenceOfElementClickableBy(By loc, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loc));

    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }
}
