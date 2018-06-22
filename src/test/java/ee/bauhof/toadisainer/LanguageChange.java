package ee.bauhof.toadisainer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class LanguageChange {
private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://toadisainer.bauhof.ee/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testEST() throws Exception {
        // open | / |
        driver.get(baseUrl);
        // click | css=li.active |
        driver.findElement(By.xpath("//nav/div/ul/li[1]")).click();
        // verifyText | css=div.navbar-item.lightblue > h3.ng-binding | Toadisainer
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Toadisainer");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=#desing-visualizer-tab-id > h3.ng-binding | Kalkulaator
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).getText(), "Kalkulaator");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=h3.sum-and-check.ng-binding | KokkuvÃµte
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).getText(), "KokkuvÃµte");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=h2.ng-binding | Olen ise oma kodu kujundaja!
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h2.ng-binding")).getText(), "Olen ise oma kodu kujundaja!");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
        @Test
        public void testENG() throws Exception {
            driver.get(baseUrl);
            // click | //nav/div/ul/li[2] |
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/nav/div[1]/ul/li[2]")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            // verifyText | css=div.navbar-item.lightblue > h3.ng-binding | Visualizer
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Visualizer");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            // verifyText | css=#desing-visualizer-tab-id > h3.ng-binding | Calculator
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).getText(), "Calculator");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            // verifyText | css=h3.sum-and-check.ng-binding | Summary
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).getText(), "Summary");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            // verifyText | css=h2.ng-binding | My home is my creation!
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector("h2.ng-binding")).getText(), "My home is my creation!");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
        }
        @Test
        public void testRUS() throws Exception{
            driver.get(baseUrl);
        // click | //nav/div/ul/li[3] |
        driver.findElement(By.xpath("//nav/div/ul/li[3]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(("li.active"))));
//            WebDriverWait wait = new WebDriverWait(driver, 10);
        // verifyText | css=div.navbar-item.lightblue > h3.ng-binding | Ð’Ð¸Ð·ÑƒÐ°Ð»Ð°Ð¹Ð·ÐµÑ€
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Ð’Ð¸Ð·ÑƒÐ°Ð»Ð°Ð¹Ð·ÐµÑ€");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=#desing-visualizer-tab-id > h3.ng-binding | ÐšÐ°Ð»ÑŒÐºÑƒÐ»ÑÑ‚Ð¾Ñ€
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).getText(), "ÐšÐ°Ð»ÑŒÐºÑƒÐ»ÑÑ‚Ð¾Ñ€");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=h3.sum-and-check.ng-binding | Ð¡ÑƒÐ¼Ð¼Ð° Ð·Ð°ÐºÐ°Ð·Ð°
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).getText(), "Ð¡ÑƒÐ¼Ð¼Ð° Ð·Ð°ÐºÐ°Ð·Ð°");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | css=h2.ng-binding | ÐœÐ¾Ð¹ Ð´Ð¾Ð¼ - Ð¼Ð¾Ñ‘ Ñ‚Ð²Ð¾Ñ€ÐµÐ½Ð¸Ðµ!
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("h2.ng-binding")).getText(), "ÐœÐ¾Ð¹ Ð´Ð¾Ð¼ - Ð¼Ð¾Ñ‘ Ñ‚Ð²Ð¾Ñ€ÐµÐ½Ð¸Ðµ!");
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

