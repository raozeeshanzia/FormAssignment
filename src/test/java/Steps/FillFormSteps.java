package Steps;

import Driverfactory.DriverFactory;
import Pages.*;
import Utils.ConfigReader;
import Utils.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FillFormSteps {
    public static ExcelReader data = new ExcelReader("./src/test/resources/testdata/data.xlsx");
    private Properties properties= ConfigReader.setProperties("./src/test/resources/config/personalInfo.properties");
    private GoogleFormPage formPage = new GoogleFormPage(DriverFactory.getDriver());
    private MultipleQuestionPage multiQuePage = new MultipleQuestionPage(DriverFactory.getDriver());
    private CheckBoxesPage checkBoxesPage = new CheckBoxesPage(DriverFactory.getDriver());
    private DropdownPage dropdownPage = new DropdownPage(DriverFactory.getDriver());
    private UploadFilePage uploadPage = new UploadFilePage(DriverFactory.getDriver());
    private DateTimePage dateTimePage = new DateTimePage(DriverFactory.getDriver());
    private ResultPage resultPage = new ResultPage(DriverFactory.getDriver());
    private String Sheetname = "testData";


    @Then("user enter username")
    public void userEnterUsername() {
        formPage.enterUserName(properties.getProperty("username"));
    }

    @Then("user enter cnic")
    public void userEnterCnic() {
        formPage.enterCNIC(properties.getProperty("cnicNumber"));
    }

    @Then("user enter contact number")
    public void userEnterContactNumber() {
        formPage.enterPhoneNumber(properties.getProperty("phoneNumber"));
    }

    @Then("user enter useremail")
    public void userEnterUseremail() {
        formPage.enterEmail(properties.getProperty("email"));

    }

    @Then("user choose ans of firebug question")
    public void userChooseAnsOfFirebugQuestion() {
        multiQuePage.enterFireBugAns(data.getCellData(Sheetname,1,2));

    }

    @Then("user choose answer of not locator question")
    public void userChooseAnswerOfNotLocatorQuestion() {
        multiQuePage.enterNotLocatorAns(data.getCellData(Sheetname,1,3));

    }

    @Then("user click on next button available on mutliple question")
    public void userClickOnNextButtonAvailableOnMutlipleQuestion() {
        multiQuePage.clickOnNextBtn();

    }

    @And("verify user is on checkBox Page")
    public void verifyUserIsOnCheckBoxPage() throws InterruptedException {
        checkBoxesPage.verifyUserIsOnCheckboxPage();
    }

    @Then("user user select answer of prime number")
    public void userUserSelectAnswerOfPrimeNumber() {
        String excelValue = data.getCellData(Sheetname,1,4);
        String[] ansOfPrimeNumber = excelValue.split(",");
        checkBoxesPage.selectPrimeNumber(ansOfPrimeNumber);

    }

    @Then("user user select answer of select number question")
    public void userUserSelectAnswerOfSelectNumberQuestion() {
        String excelValue = data.getCellData(Sheetname,1,5);
        String[] ansOfSelectNumber = excelValue.split(",");
        checkBoxesPage.selectNumber(ansOfSelectNumber);

    }

    @Then("user click on next button of checkbox page")
    public void userClickOnNextButtonOfCheckboxPage() {
        checkBoxesPage.clickOnNextBtn();
    }

    @Then("user choose capital of punjab")
    public void userChooseCapitalOfPunjab() {
        dropdownPage.chosePunCapital(data.getCellData(Sheetname,1,7));

    }

    @Then("user choose capital pakistan")
    public void userChooseCapitalPakistan() {
        dropdownPage.chosePakCapital(data.getCellData(Sheetname,1,6));
    }

    @Then("click on next button of dropdown page")
    public void clickOnNextButtonOfDropdownPage() {
        dropdownPage.clickOnNextBtn();

    }

    @And("verify user is on file upload page")
    public void verifyUserIsOnFileUploadPage() {
        String path = System.getProperty("user.dir");
        System.out.println("path::"+path);
    }

    @And("user upload pdf file")
    public void userUploadPdfFile() throws InterruptedException {
        uploadPage.uploadPDFFile();
    }

    @Then("upload images file")
    public void uploadImagesFile() throws InterruptedException, AWTException {
        uploadPage.uploadImageFile();
    }

    @Then("click on next button available on file upload page")
    public void clickOnNextButtonAvailableOnFileUploadPage() {
        uploadPage.clickOnnextBtn();
    }

    @Then("enter current time")
    public void enterCurrentTime() {
        dateTimePage.enterTime();
    }

    @Then("enter current date")
    public void enterCurrentDate() {
        dateTimePage.enterDate();
    }

    @Then("click on submit button")
    public void clickOnSubmitButton() {
        dateTimePage.clickOnSubmitBtn();
    }

    @Then("check result of question one and write correct answer in file")
    public void checkResultOfQuestionOneAndWriteCorrectAnswerInFile() {
        data.removeColumn(Sheetname,3);
        data.addColumn(Sheetname,"Correct Ans");
        resultPage.CheckMultiQuestionOneAndWriteFile(data);
        resultPage.CheckMultiQuestionTwoAndWriteFile(data);

    }

    @Then("click on view score button")
    public void clickOnViewScoreButton() {
        resultPage.clickOnViewScroeBtn();
    }

    @Then("check result of checkbox question and write answer in file")
    public void checkResultOfCheckboxQuestionAndWriteAnswerInFile() throws InterruptedException {
        resultPage.CheckBoxQuestionOneAndWriteFile(data);
        resultPage.CheckBoxQuestionTwoAndWriteFile(data);
    }

    @Then("check dropdown question and write answer in file")
    public void checkDropdownQuestionAndWriteAnswerInFile() {
        resultPage.DropDownQuestionOneAndWriteFile(data);
        resultPage.DropDownQuestionTwoAndWriteFile(data);
    }

    @Then("verify total score")
    public void verifyTotalScore() throws InterruptedException {
        Thread.sleep(5000);
        resultPage.verifyScore(Sheetname);
    }
}
