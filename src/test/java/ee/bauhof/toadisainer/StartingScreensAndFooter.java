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

public class StartingScreensAndFooter {
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
    public void testMainPage() throws Exception {
        driver.get(baseUrl);

        // assertText | css=h2.ng-binding | Olen ise oma kodu kujundaja!
        Assert.assertEquals(driver.findElement(By.cssSelector("h2.ng-binding")).getText(), "Olen ise oma kodu kujundaja!");
        // assertText | //div[@id='main-scene-holder']/div[2]/div/h1[2] | Toadisainer
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='main-scene-holder']/div[2]/div/h1[2]")).getText(), "TOADISAINER");
        // assertElementPresent | css=span.icon-Bauhof-Logo |
        Assert.assertTrue(isElementPresent(By.cssSelector("span.icon-Bauhof-Logo")));
        // assertText | css=li.active | EST
        Assert.assertEquals(driver.findElement(By.cssSelector("li.active")).getText(), "EST");
        // assertText | //nav/div/ul/li[2] | ENG
        Assert.assertEquals(driver.findElement(By.xpath("//nav/div/ul/li[2]")).getText(), "ENG");
        // assertText | //nav/div/ul/li[3] | RUS
        Assert.assertEquals(driver.findElement(By.xpath("//nav/div/ul/li[3]")).getText(), "RUS");
        // assertElementPresent | //a/img |
        Assert.assertTrue(isElementPresent(By.xpath("//a/img")));
        // assertText | //nav/div/a/span | Ã•ppevideo
        Assert.assertEquals(driver.findElement(By.xpath("//nav/div/a/span")).getText(), "Õppevideo");
        // assertText | css=div.navbar-item.lightblue > h3.ng-binding | Toadisainer
        Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Toadisainer");
        // assertText | css=#desing-visualizer-tab-id > h3.ng-binding | Kalkulaator
        Assert.assertEquals(driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).getText(), "Kalkulaator");
        // assertText | css=h3.sum-and-check.ng-binding | KokkuvÃµte
        Assert.assertEquals(driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).getText(), "Kokkuvõte");
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/div[1]/div[1]/div[2]/div[1]/img")));


    }
    @Test
    public void testLogoButton() throws Exception {
        // open | / |
        driver.get(baseUrl);
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
    @Test
    public void testCheckNewRoomScene() throws Exception {
        // open | / |
        driver.get(baseUrl);
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

    @Test
    public void testToadizainerPage() throws Exception {
        // open | / |
        driver.get(baseUrl);
        // verifyText | css=div.navbar-item.lightblue > h3.ng-binding | Toadisainer
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).getText(), "Toadisainer");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();

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
    @Test
    public void testOpenScenePage() throws Exception {

        // open | / |
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        // click | css=h4.ng-binding |
        driver.findElement(By.cssSelector("h4.ng-binding")).click();
        // click | //div[@id='design-menu-navbar']/div/div[5]/div/h4 |
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div/h4")).click();
        // assertElementPresent | css=h3.design-visualiser-hint.ng-binding |
        Assert.assertTrue(isElementPresent(By.cssSelector("h3.design-visualiser-hint.ng-binding")));
    }
    @Test
    public void clickCalcFromBasePage() throws Exception {
        // open | / |
        driver.get(baseUrl);
        // click | css=#desing-visualizer-tab-id > h3.ng-binding |
        driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).click();
        // verifyText | css=p.ng-binding | Puuduvad tooted koguste arvutamiseks. Palun alusta disainimist valides "Toadisainer" ja tutvu Bauhofi toodetega.
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("p.ng-binding")).getText(), "Puuduvad tooted koguste arvutamiseks. Palun alusta disainimist valides \"Toadisainer\" ja tutvu Bauhofi toodetega.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void addNewProductAndVerifyCalcPage() throws Exception {
        // open | / |
        driver.get(baseUrl);
        // click | css=div.navbar-item.lightblue > h3.ng-binding |
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
//        driver.findElement(By.id("mainCanvasWrapper")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);

        // теперь можно кликать
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        // click | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
        driver.findElement(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")).click();
        // storeElementPresent | css=strong.ng-binding |
        driver.findElement(By.cssSelector("#desing-visualizer-tab-id > h3.ng-binding")).click();
        // verifyText | css=div.room-head > h4.ng-binding | Vali sobiv ruumi kuju
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div.room-head > h4.ng-binding")).getText(), "Vali sobiv ruumi kuju");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }
    @Test
    public void SummaryPageWithoutProduct() throws Exception {

        // open | / |
        driver.get(baseUrl);
        // click | css=h3.sum-and-check.ng-binding |
        driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).click();
        // assertElementPresent | css=div.item-content.active > p.ng-binding |
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/span/nav/div[4]/div/p")));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/span/nav/div[4]/div/p")));}

    @Test
    public void SummaryPageWithProduct() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));

        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        driver.findElement(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")).click();
        driver.findElement(By.cssSelector("h3.sum-and-check.ng-binding")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("div.products.checkout-item > h4.ng-binding")));
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

