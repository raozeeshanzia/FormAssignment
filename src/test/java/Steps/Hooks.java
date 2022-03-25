package Steps;

import Driverfactory.DriverFactory;
import Pages.GoogleFormPage;
import Utils.ConfigReader;
import Utils.ExcelReader;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {
    private DriverFactory driverFactory;
    private GoogleFormPage gooleLoginPage;
    private WebDriver driver;
    private Properties properties;
    private ConfigReader configReader;


    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        properties = configReader.setProperties("./src/test/resources/config/browser.properties");

    }
    @Before(order = 1)
    public void launchBrowser(){
        driverFactory = new DriverFactory();
        driver = driverFactory.setDriver(properties.getProperty("browser"));
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfSGh4qzssK1gnZ6JEUe1D4E3lmGCelVD0VZgdHs_y7K_U7rA/viewform");
        gooleLoginPage = new GoogleFormPage(driver);
        gooleLoginPage.Login(properties.getProperty("useremail"),properties.getProperty("password"));
    }

    @After(order = 0)
    public void closeBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
