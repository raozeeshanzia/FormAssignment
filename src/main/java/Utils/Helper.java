package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Helper {

    public static void scrollPage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }
}
