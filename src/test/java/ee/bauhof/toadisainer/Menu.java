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
import java.awt.*;

import java.util.concurrent.TimeUnit;

public class Menu {
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
    public void MenuContent() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по div, а не по img)
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        // ПОПРАВИЛ ЛОКАТОР (Кликаем по canvas, а не по div)
        Thread.sleep(5000);
        Assert.assertTrue(isElementPresent(By.cssSelector("span.icon-Menu-icon")));
        // click | css=span.icon-Menu-icon |
        driver.findElement(By.cssSelector("span.icon-Menu-icon")).click();
        // assertElementPresent | id=close-set-menu |
        Thread.sleep(5000);
        Assert.assertTrue(isElementPresent(By.id("close-set-menu")));
        // assertElementPresent | link=Eemalda kÃµik tooted |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[4]/a")));
        // assertElementPresent | link=Suurenda vaadet |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[5]/a")));
        // assertElementPresent | link=Salvesta disain |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[6]/a")));
        // assertElementPresent | link=Minu disain |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[7]/a")));
        // assertElementPresent | link=Prindi |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[8]/a")));
        // assertElementPresent | link=Jaga disaini |
        Assert.assertTrue(isElementPresent(By.linkText("Jaga disaini")));
        // assertElementPresent | css=i.fa.fa-facebook-official |
        Assert.assertTrue(isElementPresent(By.cssSelector("i.fa.fa-facebook-official")));
        // assertElementPresent | css=i.fa.fa-pinterest-square |
        Assert.assertTrue(isElementPresent(By.cssSelector("i.fa.fa-pinterest-square")));
        // assertElementPresent | css=i.fa.fa-twitter |
        Assert.assertTrue(isElementPresent(By.cssSelector("i.fa.fa-twitter")));
        // assertElementPresent | css=i.fa.fa-envelope |
        Assert.assertTrue(isElementPresent(By.cssSelector("i.fa.fa-envelope")));

    }
    @Test
    public void clearScene()  throws Exception {
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);

        // теперь можно кликать
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div[1]/div/div[1]")).click();
        Thread.sleep(5000);
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[2]/div[2]/img")));
        Assert.assertTrue(isElementPresent(By.cssSelector("span.icon-Menu-icon")));
        // click | css=span.icon-Menu-icon |
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/a/span")).click();
        // assertElementPresent | id=close-set-menu |
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
        // click | css=span.icon-Menu-icon |
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/button[1]")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//div/img[contains(@src, 'Kitchen-Classic')]")));

    }
    @Test
    public void magnifityScene() throws Exception{
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // click | //div[@id='design-menu-navbar']/div/div[2]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div/h4")).click();
        // click | //div[@id='design-menu-navbar']/div/div[5]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[5]/a")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 7);
//        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(canvasElement).build().perform();
        try {
            //moves mouse to the middle of the screen
            new Robot().mouseMove((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
            //remember to use try-catch block (always, and remember to delete this)
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        Assert.assertTrue(isElementPresent(By.cssSelector("div.zoomLens")));
    }
@Test
public void saveDesign() throws Exception {
    driver.get(baseUrl);
    // click | css=div.navbar-item.lightblue > h3.ng-binding |
    driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
    driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
    WebDriverWait wait = new WebDriverWait(driver, 7);
    WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
    Thread.sleep(5000);

    // теперь можно кликать
    Actions actions = new Actions(driver);
    actions.moveToElement(canvasElement).click().build().perform();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div[1]/div/div[1]")).click();
    Thread.sleep(5000);
//    Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[2]/div[2]/img")));
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/a/span")).click();
    // click | css=span.icon-Menu-icon |
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[6]/a")).click();
    // assertElementPresent | id=close-set-menu |
    Thread.sleep(5000);
    driver.findElement(By.id("saveName")).clear();
    driver.findElement(By.id("saveName")).sendKeys("BLA BLA BLA");
    // click | //input[@value='Salvesta'] |
    driver.findElement(By.xpath("//input[@value='Salvesta']")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/a/span")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[7]/a")).click();
    Thread.sleep(3000);
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div[2]/div/div/h4")).getText(), "BLA BLA BLA");
    // click | css=span.icon-Menu-icon |
}
@Test
public void testMyDesigns() throws Exception {
    driver.get(baseUrl);
    // click | css=div.navbar-item.lightblue > h3.ng-binding |
    driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
    driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
    WebDriverWait wait = new WebDriverWait(driver, 7);
    WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
    Thread.sleep(5000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/a/span")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[1]/ul/li[7]/a")).click();
    Thread.sleep(3000);
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div[2]/div[2]/p[1]")).getText(),"Vali salvestatud disain või TAGASI Disainima");
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