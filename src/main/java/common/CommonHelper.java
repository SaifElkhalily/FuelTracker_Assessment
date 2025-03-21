package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

import static org.testng.AssertJUnit.*;

public class CommonHelper {
    public WebDriver driver;
    public CommonPO commonPO;
    public Utils utils;
    public JavascriptExecutor js;
    Actions actions;
    public CommonHelper(WebDriver driver){
        this.driver = driver;
        commonPO = new CommonPO(driver);
        utils = new Utils(driver);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
    public void setCarNumber(int carNumber){
        utils.waitForVisibility(commonPO.carNumberInputField);
        commonPO.carNumberInputField.sendKeys(String.valueOf(carNumber));
    }
    public void setFuelInLiters(int fuelInLiters){
        commonPO.fuelInLitersInputField.sendKeys(String.valueOf(fuelInLiters));
    }
    public void setFuelCost(double fuelCost){
        commonPO.fuelCostInputField.sendKeys(String.valueOf(fuelCost));
    }
    public void setFuelType(int fuelType){
        commonPO.fuelTypeInputField.sendKeys(String.valueOf(fuelType));
    }
    public void setDateAndTime(String date, String time) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = arguments[1];", commonPO.dateAndTimeInputField, dateAndTime);
        WebElement dateAndTime = commonPO.dateAndTimeInputField;
        actions.sendKeys(dateAndTime, date).perform();
        actions.sendKeys(dateAndTime,Keys.RIGHT).perform();
        actions.sendKeys(dateAndTime, time).perform();
    }
    public void setCompanyId(int companyId){
        utils.waitForVisibility(commonPO.companyIdInputField);
        commonPO.companyIdInputField.sendKeys(String.valueOf(companyId));
    }
    public void clickEditButton(){
        utils.waitForElementToBeClickable(commonPO.editButton);
        commonPO.editButton.click();
    }

    public void savedData(String carNumber, String date) {
        try {
            WebElement savedData = commonPO.tableRow(carNumber, date);
            assertTrue("Data was saved successfully.", true);
            System.out.println("Data has been saved successfully");
        } catch (NoSuchElementException e) {
            fail("Data was not saved");
        }
    }

    public void deleteData(String date) {
        WebElement deleteButton = commonPO.deleteButton(date);
        deleteButton.click();
    }

    public void deletedData(String carNumber, String date) {
        try {
            WebElement deletedData = commonPO.tableRow(carNumber, date);
            fail("Data was not deleted successfully.");
                System.out.println("Data has not been deleted");
        } catch (Exception e) {
            System.out.println("Data has been deleted successfully");
        }
    }
}
