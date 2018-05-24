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

public class CheckNewRoomScene {
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
    public void testCheckNewRoomScene() throws Exception {
        // open | / |
        driver.get(baseUrl + "/");
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // click | css=h4.ng-binding |
        driver.findElement(By.cssSelector("h4.ng-binding")).click();
        // verifyText | //div[@id='design-menu-navbar']/div/div[5]/div/h4 | Klassikaline romantika
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).getText(), "Klassikaline romantika");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[6]/div/h4 | Boheemlaslik etno
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[6]/div/h4")).getText(), "Boheemlaslik etno");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[7]/div/h4 | Modernne minimalism
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[7]/div/h4")).getText(), "Modernne minimalism");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=input.back |
        driver.findElement(By.cssSelector("input.back")).click();
        // click | //div[@id='design-menu-navbar']/div/div[2]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/h4")).click();
        // verifyText | //div[@id='design-menu-navbar']/div/div[5]/div/h4 | Klassikaline romantika
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).getText(), "Klassikaline romantika");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[6]/div/h4 | Boheemlaslik etno
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[6]/div/h4")).getText(), "Boheemlaslik etno");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[7]/div/h4 | Modernne minimalism
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[7]/div/h4")).getText(), "Modernne minimalism");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=input.back |
        driver.findElement(By.cssSelector("input.back")).click();
        // click | //div[@id='design-menu-navbar']/div/div[3]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[3]/div/h4")).click();
        // verifyText | //div[@id='design-menu-navbar']/div/div[5]/div/h4 | Klassikaline romantika
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).getText(), "Klassikaline romantika");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[6]/div/h4 | Boheemlaslik etno
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[6]/div/h4")).getText(), "Boheemlaslik etno");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[7]/div/h4 | Modernne minimalism
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[7]/div/h4")).getText(), "Modernne minimalism");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=input.back |
        driver.findElement(By.cssSelector("input.back")).click();
        // click | //div[@id='design-menu-navbar']/div/div[4]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[4]/div/h4")).click();
        // verifyText | //div[@id='design-menu-navbar']/div/div[5]/div/h4 | Klassikaline romantika
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).getText(), "Klassikaline romantika");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[6]/div/h4 | Boheemlaslik etno
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[6]/div/h4")).getText(), "Boheemlaslik etno");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // verifyText | //div[@id='design-menu-navbar']/div/div[7]/div/h4 | Modernne minimalism
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[7]/div/h4")).getText(), "Modernne minimalism");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=input.back |
        driver.findElement(By.cssSelector("input.back")).click();
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

