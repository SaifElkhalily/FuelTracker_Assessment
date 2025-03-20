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
    public WebElement valueOfDateAndTime(String dateAndTime){
        String xpath = String.format("//input[@name='dateAndTime' and @value='^(20\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d)$']", dateAndTime);
        return driver.findElement(By.xpath(xpath));
    }
    @FindBy( how = How.XPATH, using = "//input[@name='companyId']")
    public WebElement companyIdInputField;
    @FindBy( how = How.XPATH, using = "//button[@type='submit']")
    public WebElement editButton;
}
