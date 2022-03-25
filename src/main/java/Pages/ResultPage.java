package Pages;

import Utils.ExcelReader;
import Utils.Wait;
import Weblocators.FinalPageElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ResultPage {
    private WebDriver driver;
    private String Sheetname = "testData";
    public ResultPage(WebDriver driver){
        this.driver =driver;
    }

    private By viewScroeBtn = By.cssSelector(FinalPageElement.viewScroeBtn);
    private By mquestionOne = By.cssSelector(FinalPageElement.mquestionOne);
    private By mAnsOne = By.cssSelector(FinalPageElement.mcorrectAnsOne);
    private By mquestionTwo = By.cssSelector(FinalPageElement.mquestionTwo);
    private By mAnsTwo = By.cssSelector(FinalPageElement.mcorrectAnsTwo);
    private By checkBoxQuesOne = By.cssSelector(FinalPageElement.checkQuestionOne);
    private By checkBoxQuesTwo = By.cssSelector(FinalPageElement.checkQuestionTwo);
    private By checkAnsOne = By.cssSelector(FinalPageElement.checkAnsOneList);
    private By checkAnsTwo = By.cssSelector(FinalPageElement.checkAnsTwolist);
    private By DDQuesOne = By.cssSelector(FinalPageElement.dropDownQuestionOne);
    private By DDQuesTwo = By.cssSelector(FinalPageElement.dropDownQuestionTwo);
    private By DDAnsOne = By.cssSelector(FinalPageElement.dropDownAnsOne);
    private By DDAnsTwo = By.cssSelector(FinalPageElement.dropDownAnsTwo);
    private By finalSoreField = By.cssSelector(FinalPageElement.finalScore);



    public void clickOnViewScroeBtn(){
        Wait.waitForPresenceOfElementVisibleBy(viewScroeBtn,driver);
        String oldTab = driver.getWindowHandle();
        driver.findElement(viewScroeBtn).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));

    }

    public void swtichToTabs(){
        Set<String> handles=driver.getWindowHandles();
        String currentHandle= driver.getWindowHandle();
        for(String actual: handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
    }

    public void CheckMultiQuestionOneAndWriteFile(ExcelReader data){
        Wait.waitForPresenceOfElementClickableBy(mquestionOne,driver);
        String questionOne = driver.findElement(mquestionOne).getText();
        if(questionOne == data.getCellData(Sheetname,0,2)){
            //Wait.waitForPresenceOfElementVisibleBy(mAnsOne,driver);
            if (driver.findElements(mAnsOne).size() > 0){
                data.setCellData(Sheetname,"Correct Ans",2,driver.findElement(mAnsOne).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",2,data.getCellData(Sheetname,1,2));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsTwo,driver);
            if (driver.findElements(mAnsTwo).size()>0){
                data.setCellData(Sheetname,"Correct Ans",2,driver.findElement(mAnsOne).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",2,data.getCellData(Sheetname,1,2));
            }
        }
    }

    public void CheckMultiQuestionTwoAndWriteFile(ExcelReader data){
        Wait.waitForPresenceOfElementClickableBy(mquestionTwo,driver);
        String questionTwo = driver.findElement(mquestionTwo).getText();
        if(questionTwo == data.getCellData(Sheetname,0,3)){
           // Wait.waitForPresenceOfElementVisibleBy(mAnsTwo,driver);
            if (driver.findElements(mAnsTwo).size()>0){
                data.setCellData(Sheetname,"Correct Ans",3,driver.findElement(mAnsTwo).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",3,data.getCellData(Sheetname,1,3));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsOne,driver);
            if (driver.findElements(mAnsOne).size() > 0){
                data.setCellData(Sheetname,"Correct Ans",3,driver.findElement(mAnsOne).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",3,data.getCellData(Sheetname,1,3));
            }
        }
    }

    //check Box ans
    public void CheckBoxQuestionOneAndWriteFile(ExcelReader data) throws InterruptedException {
        Wait.waitForPresenceOfElementClickableBy(checkBoxQuesOne,driver);
        String questionOne = driver.findElement(checkBoxQuesOne).getText();
        if(questionOne.contains(data.getCellData(Sheetname,0,4))){
            if (driver.findElements(checkAnsOne).size() > 0){
                Wait.waitForPresenceOfElementVisibleBy(checkAnsOne,driver);
                Wait.waitForElementVisibleBy(checkAnsOne,driver);
                Thread.sleep(3000);
                List<WebElement> ans = driver.findElements(checkAnsOne);
                StringBuffer finalString = new StringBuffer();
                for (WebElement el:ans) {
                    finalString.append(el.getText()+" ");
                }
                for (int i=0;i<=ans.size();i++) {
                    data.setCellData(Sheetname,"Correct Ans",4, String.valueOf(finalString).trim().replace(" ",","));
                }
            }else {
                data.setCellData(Sheetname,"Correct Ans",4,data.getCellData(Sheetname,1,4));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsTwo,driver);
            if (driver.findElements(checkAnsTwo).size()>0){
                Wait.waitForPresenceOfElementVisibleBy(checkAnsTwo,driver);
                Wait.waitForElementVisibleBy(checkAnsTwo,driver);
                Thread.sleep(3000);
                List<WebElement> ans = driver.findElements(checkAnsTwo);
                StringBuffer finalString = new StringBuffer();
                for (WebElement el:ans) {
                    finalString.append(el.getText()+" ");
                }
                data.setCellData(Sheetname,"Correct Ans",4, String.valueOf(finalString).trim().replace(" ",","));
            }else {
                data.setCellData(Sheetname,"Correct Ans",4,data.getCellData(Sheetname,1,4));
            }
        }
    }

    public void CheckBoxQuestionTwoAndWriteFile(ExcelReader data) throws InterruptedException {
        Wait.waitForPresenceOfElementClickableBy(checkBoxQuesTwo,driver);
        String questionTwo = driver.findElement(checkBoxQuesTwo).getText();
        if(questionTwo.contains(data.getCellData(Sheetname,0,5))){
            if (driver.findElements(checkAnsTwo).size()>0){
                Wait.waitForPresenceOfElementVisibleBy(checkAnsTwo,driver);
                Wait.waitForElementVisibleBy(checkAnsTwo,driver);
                List<WebElement> ans = driver.findElements(checkAnsTwo);
                StringBuffer finalString = new StringBuffer();
                for (WebElement el:ans) {
                    finalString.append(el.getText()+" ");
                }
                data.setCellData(Sheetname,"Correct Ans",5, String.valueOf(finalString).trim().replace(" ",","));

            }else {
                data.setCellData(Sheetname,"Correct Ans",5,data.getCellData(Sheetname,1,5));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsOne,driver);
            if (driver.findElements(checkAnsOne).size() > 0){
                Wait.waitForPresenceOfElementVisibleBy(checkAnsOne,driver);
                Wait.waitForElementVisibleBy(checkAnsOne,driver);
                List<WebElement> ans = driver.findElements(checkAnsOne);
                StringBuffer finalString = new StringBuffer();
                for (WebElement el:ans) {
                    finalString.append(el.getText()+" ");
                }
                 data.setCellData(Sheetname,"Correct Ans",5, String.valueOf(finalString).trim().replace(" ",","));

            }else {
                data.setCellData(Sheetname,"Correct Ans",5,data.getCellData(Sheetname,1,5));
            }
        }
    }

    //dropdown
    public void DropDownQuestionOneAndWriteFile(ExcelReader data){
        Wait.waitForPresenceOfElementClickableBy(DDQuesOne,driver);
        String questionOne = driver.findElement(DDQuesOne).getText();
        if(questionOne == data.getCellData(Sheetname,0,6)){
            //Wait.waitForPresenceOfElementVisibleBy(mAnsOne,driver);
            if (driver.findElements(DDAnsOne).size() > 0){
                data.setCellData(Sheetname,"Correct Ans",6,driver.findElement(DDAnsOne).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",6,data.getCellData(Sheetname,1,6));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsTwo,driver);
            if (driver.findElements(DDAnsTwo).size()>0){
                data.setCellData(Sheetname,"Correct Ans",6,driver.findElement(DDAnsTwo).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",6,data.getCellData(Sheetname,1,6));
            }
        }
    }

    public void DropDownQuestionTwoAndWriteFile(ExcelReader data){
        Wait.waitForPresenceOfElementClickableBy(DDQuesTwo,driver);
        String questionTwo = driver.findElement(DDQuesTwo).getText();
        if(questionTwo == data.getCellData(Sheetname,0,7)){
            // Wait.waitForPresenceOfElementVisibleBy(mAnsTwo,driver);
            if (driver.findElements(DDAnsTwo).size()>0){
                data.setCellData(Sheetname,"Correct Ans",7,driver.findElement(DDQuesTwo).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",7,data.getCellData(Sheetname,1,7));
            }
        }else {
            //Wait.waitForPresenceOfElementVisibleBy(mAnsOne,driver);
            if (driver.findElements(DDAnsOne).size() > 0){
                data.setCellData(Sheetname,"Correct Ans",7,driver.findElement(DDAnsOne).getText());
            }else {
                data.setCellData(Sheetname,"Correct Ans",7,data.getCellData(Sheetname,1,3));
            }
        }

    }

    public void verifyScore(String sheetname){
        Wait.waitForElementVisibleBy(finalSoreField,driver);
        ExcelReader data = new ExcelReader("./src/test/resources/testdata/data.xlsx");
        var score = 0;
        for (int i=2;i<=data.getRowCount(sheetname);i++){
            if(data.getCellData(sheetname,1,i).trim() == data.getCellData(sheetname,2,i).trim()){
                if(i<4){
                    score = score + 5;
                }else if (i>=4 || i<=5 ){
                    score = score + 10;
                }else {
                    score = score + 5;
                }
            }
        }
        String actualValue = driver.findElement(finalSoreField).getText();
        String[] totalscore =actualValue.split("/");
        Assert.assertEquals(totalscore[0],String.valueOf(score));
    }
}

