package Steps;

import Driverfactory.DriverFactory;
import Pages.GoogleFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GoogleFormSteps {
    private GoogleFormPage formPage = new GoogleFormPage(DriverFactory.getDriver());
    @Given("user is on automation assessment page")
    public void userIsOnAutomationAssessmentPage() {
        formPage.verifyUserIsOnAssessmentPage();
    }

    @Then("user enter username {string}")
    public void userEnterUsername(String name) {
        formPage.enterUserName(name);
    }

    @Then("user enter cnic {string}")
    public void userEnterCnic(String cnicNumber) {
        formPage.enterCNIC(cnicNumber);
    }

    @Then("user enter contact number {string}")
    public void userEnterContactNumber(String phoneNumber) {
        formPage.enterPhoneNumber(phoneNumber);
    }

    @Then("user enter useremail {string}")
    public void userEnterUseremail(String email) {
        formPage.enterEmail(email);
    }

    @And("verify successfully move to next page")
    public void verifySuccessfullyMoveToNextPage() {
        //formPage.clickOnNextBtn();
        formPage.verifyUserIsQuestionPage();
    }

    @And("verify this field is required message is display")
    public void verifyThisFieldIsRequiredMessageIsDisplay() {
        formPage.alertMessageIsDisplay("This is a required question");
    }

    @Then("user click on next button")
    public void userClickOnNextButton() {
        formPage.clickOnNextBtn();
    }

    @Given("user is on multiple Question Page")
    public void userIsOnMultipleQuestionPage() {
        formPage.clickOnNextBtn();
        formPage.verifyUserIsQuestionPage();
    }

    @And("verify that error message is display")
    public void verifyThatErrorMessageIsDisplay() {
          formPage.alertMessageIsDisplay("Must match pattern");
    }
}
