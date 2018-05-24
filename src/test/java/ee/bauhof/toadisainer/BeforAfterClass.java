package ee.bauhof.toadisainer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

 class BeforeAfterClass {
        protected WebDriver driver;
        protected String baseUrl;


        @Parameters("browser")
        @BeforeClass(alwaysRun = true)
        public void setUp(String browser) throws Exception {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:/Program Files/Selenium/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:/Program Files/Selenium/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            baseUrl = "http://toadisainer.bauhof.ee";
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }


        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
        }
    }

