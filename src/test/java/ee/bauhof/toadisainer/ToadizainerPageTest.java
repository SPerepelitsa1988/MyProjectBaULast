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

public class ToadizainerPageTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://toadisainer.bauhof.ee/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testToadizainerPage() throws Exception {
        // open | / |
        driver.get(baseUrl + "/");
        // verifyText | css=div.navbar-item.lightblue > h3.ng-binding | Toadisainer
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Toadisainer");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // waitForElementPresent | css=div.ng-scope.first-step > p.ng-binding |
        for (int second = 0;; second++) {
            if (second >= 5)
            try { if (isElementPresent(By.cssSelector("div.ng-scope.first-step > p.ng-binding"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // verifyText | css=h4.ng-binding | Elutuba
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h4.ng-binding")).getText(), "Elutuba");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[2]/div/h4 | Köök
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/h4")).getText(), "Köök");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[3]/div/h4 | Vannituba
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[3]/div/h4")).getText(), "Vannituba");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[4]/div/h4 | Magamistuba
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[4]/div/h4")).getText(), "Magamistuba");
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

