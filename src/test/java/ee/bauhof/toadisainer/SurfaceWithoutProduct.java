package ee.bauhof.toadisainer;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SurfaceWithoutProduct {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "d:/distribs/selenium/geckodriver.exe");
        driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        baseUrl = "https://toadisainer.bauhof.ee";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void selectAndCheckSurface() throws Exception {
        // open | / |
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // click | //div[@id='design-menu-navbar']/div/div[2]/div/img |
//        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/img"))
//        ).click();

        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
//      driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/img")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
//        WebElement imgEl = driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/img"));
//        actions.moveToElement(imgEl).click().perform();
        // click | //div[@id='design-menu-navbar']/div/div[5]/div/img |

        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
//        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/img")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        // click | id=mainCanvas |
//        driver.findElement(By.id("mainCanvasWrapper")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);

        // ПОПРАВИЛ ЛОКАТОР (Кликаем по canvas, а не по div)
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));

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
