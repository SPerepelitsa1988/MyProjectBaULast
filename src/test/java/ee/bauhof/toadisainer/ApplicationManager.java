package ee.bauhof.toadisainer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class ApplicationManager {
    protected WebDriver driver;
    protected String baseUrl;
    private final Properties properties;

    public ApplicationManager() {
        this.properties = new Properties();
        try {
            String propertyFile = System.getProperty("configFile", "src/main/resources/test.properties");
            properties.load(new FileReader(new File(propertyFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String browser) {

        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
            driver = new ChromeDriver();
        } else if (browser.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
            driver = new FirefoxDriver();
        }

        baseUrl = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void stop() {
        driver.quit();
    }


}
