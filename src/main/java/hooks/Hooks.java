package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverFactory;
import webDriver.WebDriverHolder;
import static helpers.PropertiesLoader.readPropertyFile;

public class Hooks {

    private String url = System.getProperty("url",readPropertyFile("url"));
    private String browser = System.getProperty("browser",readPropertyFile("browser"));
    private WebDriverFactory factory = new WebDriverFactory();
    private WebDriverHolder holder = new WebDriverHolder();

    @Before
    public void setUp(){
        WebDriver driver = factory.createDriver(browser); // Use factory to create driver
        holder.setDriver(driver);
        driver.get(url);
    }
    @After
    public void tearDown() {
        holder.quitDriver();
    }
}
