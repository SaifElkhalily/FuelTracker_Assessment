package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPO {
    WebDriver driver;
    public CommonPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy( how = How.XPATH, using = "//input[@name='carNumber']")
    public WebElement carNumberInputField;
    @FindBy( how = How.XPATH, using = "//input[@name='fuelInLiters']")
    public WebElement fuelInLitersInputField;
    @FindBy( how = How.XPATH, using = "//input[@name='fuelCost']")
    public WebElement fuelCostInputField;
    @FindBy( how = How.XPATH, using = "//input[@name='fuelType']")
    public WebElement fuelTypeInputField;
    @FindBy( how = How.XPATH, using = "//input[@name='dateAndTime']")
    public WebElement dateAndTimeInputField;

    public WebElement tableRow(String carNumber, String dateAndTime){
        String xpath = String.format("//tr[td[1]='%s' and td[4]='%s']", carNumber, dateAndTime);
        return driver.findElement(By.xpath(xpath));
    }
    @FindBy( how = How.XPATH, using = "//input[@name='companyId']")
    public WebElement companyIdInputField;
    @FindBy( how = How.XPATH, using = "//button[@type='submit']")
    public WebElement editButton;

    public WebElement deleteButton(String dateAndTime){
        String xpath = String.format("//tr[td[4]='%s']/td/button[text()='Delete']", dateAndTime);
        return driver.findElement(By.xpath(xpath));
    }
}
