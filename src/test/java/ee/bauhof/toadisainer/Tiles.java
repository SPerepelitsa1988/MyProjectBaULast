package ee.bauhof.toadisainer;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tiles {
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
    public void testTileTabAllElementsArePresent() throws Exception {
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        Assert.assertTrue(isElementPresent(By.xpath("//input[@value='']")));
        // assertElementPresent | css=i.fa.fa-search |
        Assert.assertTrue(isElementPresent(By.cssSelector("i.fa.fa-search")));
        // assertElementPresent | //div[@id='title-menu']/div[2]/div/button |
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='title-menu']/div[2]/div/button")));
        // assertElementPresent | xpath=(//input[@type='text'])[2] |
        Assert.assertTrue(isElementPresent(By.xpath("(//input[@type='text'])[2]")));
        // assertElementPresent | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")));
        // assertText | id=default-tab-option | Plaadid
        Assert.assertEquals(driver.findElement(By.id("default-tab-option")).getText(), "PLAADID");
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[2]/a")));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[3]/a")));
    }
    @Test
    public void testTileFilter() throws Exception {
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/ul/li[1]/div/div/input")));
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value"), "HIND");
    }
    @Test
    public void testTileAppropriateProductsForFloorInProductList() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по canvas, а не по div)
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        // ЗДЕСЬ ПОКА НЕ ПОЛУЧИЛОСЬ ИЗБАВИТЬСЯ ОТ sleep
        // НУЖНО НАЙТИ ПРАВИЛЬНОЕ УСЛОВИЕ ПРОДОЛЖЕНИЯ
        Thread.sleep(5000);

        // теперь можно кликать
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement, 750, 830).click().build().perform();
        // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
        // click | link=VÃ¤rvid |
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[1]/a")).getText(), "PLAADID");
        String actualString = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]")).getText();
        Assert.assertTrue(actualString.contains("PÕRANDAPLAAT"));}

        @Test
        public void testTileAppropriateProductsForWallInProductList() throws Exception {
            driver.get(baseUrl);
            // click | css=div.navbar-item.lightblue > h3.ng-binding |
            driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
            WebDriverWait wait = new WebDriverWait(driver, 7);
            WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            actions.moveToElement(canvasElement).click().build().perform();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
            Thread.sleep(5000);
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[1]/a")).getText(), "PLAADID");
            String actualString = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]")).getText();
            Assert.assertTrue(actualString.contains("SEINAPLAAT"));
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