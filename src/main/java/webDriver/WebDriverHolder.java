package webDriver;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // Store WebDriver

    public WebDriver getDriver() { // Return WebDriver
        return driver.get();
    }

    public void setDriver(WebDriver driverInstance) { // Accept WebDriver
        driver.set(driverInstance);
    }

    public void removeDriver() {
        driver.remove();
    }

    public void quitDriver() {
        WebDriver currentDriver = getDriver();
        if (currentDriver != null) {
            currentDriver.quit();
            removeDriver();
        }
    }
}
