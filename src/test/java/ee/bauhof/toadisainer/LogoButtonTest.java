package ee.bauhof.toadisainer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogoButtonTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        baseUrl = "http://toadisainer.bauhof.ee/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogoButton() throws Exception {
        // open | / |
        driver.get(baseUrl + "/");
        // waitForElementPresent | css=div.navbar-item.lightblue > h3.ng-binding |
        for (int second = 0;; second++) {
            if (second >= 60) ;
            try { if (isElementPresent(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // verifyText | css=div.ng-scope.first-step > p.ng-binding | Vali uus toa tÃ¼Ã¼p
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.ng-scope.first-step > p.ng-binding")).getText(), "Vali uus toa tÃ¼Ã¼p");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=span.icon-Bauhof-Logo |
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("span.icon-Bauhof-Logo")).getText(), "");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=span.icon-Bauhof-Logo |
        driver.findElement(By.cssSelector("span.icon-Bauhof-Logo")).click();
        // click | css=h2.ng-binding |
        driver.findElement(By.cssSelector("h2.ng-binding")).click();
        // verifyText | css=h2.ng-binding | Olen ise oma kodu kujundaja!
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h2.ng-binding")).getText(), "Olen ise oma kodu kujundaja!");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
