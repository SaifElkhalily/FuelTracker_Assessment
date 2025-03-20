package stepDefinition;

import common.CommonHelper;
import common.CommonPO;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.WebDriverHolder;

public class CommonSD {
    private WebDriver driver;
    private CommonHelper commonHelper;
    private CommonPO commonPO;

    public CommonSD(WebDriverHolder holder) {
        this.driver = holder.getDriver();
        commonHelper = new CommonHelper(driver);
        commonPO = new CommonPO(driver);
    }

    @When("User sets the Car Number: {string}")
    public void setCarNumber(String carNumber) {
        int carNumberInt = Integer.parseInt(carNumber);
        commonHelper.setCarNumber(carNumberInt);
    }

    @When("User sets the Fuel in Liters: {string}")
    public void setFuelInLiters(String fuelInLiters) {
        int fuelInLitersInt = Integer.parseInt(fuelInLiters);
        commonHelper.setFuelInLiters(fuelInLitersInt);
    }

    @When("User sets the Fuel Cost: {string}")
    public void setFuelCost(String fuelCost) {
        double fuelCostDouble = Double.parseDouble(fuelCost);
        commonHelper.setFuelCost(fuelCostDouble);
    }

    @When("User sets the Fuel Type: {string}")
    public void setFuelType(String fuelType) {
        int fuelTypeInt = Integer.parseInt(fuelType);
        commonHelper.setFuelType(fuelTypeInt);
    }

    @When("User sets the Date {string} and Time {string}")
    public void setDateAndTime(String date, String time) {
        commonHelper.setDateAndTime(date, time);
    }

    @When("User sets the Company Id: {string}")
    public void setCompanyId(String companyId) {
        int companyIdInt = Integer.parseInt(companyId);
        commonHelper.setCompanyId(companyIdInt);
    }
    @When("User clicks on Edit button")
    public void clickEditButton() {
        commonHelper.clickEditButton();
    }
}
