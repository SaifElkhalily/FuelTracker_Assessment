package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public ChromeDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        addChromeArguments(options);
        return new ChromeDriver(options);
    }

    public FirefoxDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        addFirefoxArguments(options);
        return new FirefoxDriver(options);
    }

    private void addChromeArguments(ChromeOptions options) {
        //options.addArguments("--headless"); // Example: Headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        //options.addArguments("--start-fullscreen");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("enable-automation");
        options.addArguments("disable-features=NetworkService");
        // ... other arguments
    }

    private void addFirefoxArguments(FirefoxOptions options) {
        //options.addArguments("--headless"); // Example: Headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        //options.addArguments("--start-fullscreen");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-sandbox");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("enable-automation");
        options.addArguments("disable-features=NetworkService");
        // ... other Firefox-specific arguments
    }


    public WebDriver createDriver(String browserName) {
        return switch (browserName.toLowerCase()) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }
}
