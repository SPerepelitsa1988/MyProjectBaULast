package ee.bauhof.toadisainer;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalcPageWithProduct  {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://toadisainer.bauhof.ee/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test22222() throws Exception {
        // open | / |
        driver.get(baseUrl + "/");
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // click | //div[@id='design-menu-navbar']/div/div[2]/div/img |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/img")).click();
        // click | //div[@id='design-menu-navbar']/div/div[5]/div/img |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/img")).click();
        // click | id=mainCanvas |
        driver.findElement(By.id("mainCanvasWrapper")).click();
        // waitForElementPresent | css=div.design-visualiser.ng-scope |
        for (int second = 0;; second++) {
            if (second >= 60);
            try { if (isElementPresent(By.cssSelector("div.design-visualiser.ng-scope"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // click | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
        driver.findElement(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")).click();
        // storeElementPresent | css=strong.ng-binding |
    }


    @AfterClass (alwaysRun = true)
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



