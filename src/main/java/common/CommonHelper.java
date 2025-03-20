package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class CommonHelper {
    private WebDriver driver;
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
        //actions.moveToElement(commonPO.editButton).click().perform();
        utils.waitForElementToBeClickable(commonPO.editButton);
        commonPO.editButton.click();
    }
}
