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

public class ChooseProdTypeMenu {
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
    public void CategoriesForWalls() throws Exception {
        // open | / |
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);

        // теперь можно кликать
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();
        // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
        // click | link=VÃ¤rvid |
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[1]/a")).getText(), "PLAADID");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[3]/a")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[3]/a")).getText(), "Tapeedid");
        // assertElementPresent | id=wallpaper-tab |
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[4]/a")).click();
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[4]/a")).getText(), "Värvid");
    }
    @Test
    public void CategoriesForFloor() throws Exception {
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
        actions.moveToElement(canvasElement,750,830 ).click().build().perform();
        // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
        // click | link=VÃ¤rvid |
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/ul/li[1]/a")).getText(), "PLAADID");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[2]/a")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[2]/a")).getText(), "Põrandakatted");
    }
//    @Test тест работает не корректно, надо доработать,
    public void testSearch() throws Exception {
            driver.get(baseUrl);
            driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
            WebDriverWait wait = new WebDriverWait(driver, 7);
            WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            actions.moveToElement(canvasElement,750,830 ).click().build().perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//input[@value='']")).clear();
        driver.findElement(By.xpath("//input[@value='']")).sendKeys("bianco");
        // click | css=i.fa.fa-search |
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[1]/i")).click();
        // assertText | css=span.sku.ng-binding | exact:Kood: 602281
        String actualString = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]")).getText();
        Assert.assertTrue(actualString.contains("bianco"));
    }

    @Test
    public void testExpandFilter() throws Exception {
        // open | / |
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement,750,830 ).click().build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[1]/a")).click();
        // click | xpath=(//input[@type='text'])[2] |
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
        // assertElementPresent | //div[@id='title-menu']/div[2]/ul/li/div/ul/li[2]/span |
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/ul/li[3]/div/div/input")));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/ul/li[4]/div/div/input")));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[2]")));}

        @Test
        public void testCollapseFilter() throws Exception {
            // open | / |
            driver.get(baseUrl);
            driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
            WebDriverWait wait = new WebDriverWait(driver, 7);
            WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
            Thread.sleep(5000);

            // теперь можно кликать
            Actions actions = new Actions(driver);
            actions.moveToElement(canvasElement).click().build().perform();
            // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
            // click | xpath=(//input[@type='text'])[2] |
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
            // assertElementPresent | //div[@id='title-menu']/div[2]/ul/li/div/ul/li[2]/span |
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[2]")));
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
            Boolean isNotPresent = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[2]")).size()<0;}

            @Test
            public void testClearFilterViaClearButton() throws Exception {
                    driver.get(baseUrl);
            driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
    WebDriverWait wait = new WebDriverWait(driver, 7);
    WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
            Thread.sleep(5000);

    // теперь можно кликать
    Actions actions = new Actions(driver);
            actions.moveToElement(canvasElement).click().build().perform();
    // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
    // click | xpath=(//input[@type='text'])[2] |
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")));
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
                driver.findElement(By.xpath("//div[@id='title-menu']/div[2]/div/button")).click();

                // click | xpath=(//input[@type='text'])[4] |
                driver.findElement(By.xpath("(//input[@type='text'])[4]")).click();
                // click | //div[@id='title-menu']/div[2]/ul/li[3]/div/ul/li[2]/span |
                driver.findElement(By.xpath("//div[@id='title-menu']/div[2]/ul/li[3]/div/ul/li[2]/span")).click();
                // click | xpath=(//input[@type='text'])[5] |
                driver.findElement(By.xpath("(//input[@type='text'])[5]")).click();
                // click | //div[@id='title-menu']/div[2]/ul/li[4]/div/ul/li[10]/span |
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/ul/li[4]/div/ul/li[3]/span")).click();
                driver.findElement(By.xpath("//div[@id='title-menu']/div[2]/div/button[2]")).click();
                // assertValue | xpath=(//input[@type='text'])[2] | HIND
                Assert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value"), "HIND");
                // assertValue | xpath=(//input[@type='text'])[4] | VÃ„RV
                Assert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"), "VÄRV");
                // assertValue | xpath=(//input[@type='text'])[5] | SUURUS
                Assert.assertEquals(driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"), "SUURUS");
            }

            @Test
            public void testProductContent() throws Exception {
                    driver.get(baseUrl);
            driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
            driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
    WebDriverWait wait = new WebDriverWait(driver, 7);
    WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
            Thread.sleep(5000);

    // теперь можно кликать
    Actions actions = new Actions(driver);
            actions.moveToElement(canvasElement).click().build().perform();
    // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
    // click | xpath=(//input[@type='text'])[2] |
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
                // assertElementPresent | css=span.price.ng-binding |
                Assert.assertTrue(isElementPresent(By.cssSelector("#title-menu > div.product-container>div.products>div.item>div.col1>strong")));
                // assertElementPresent | css=strong.ng-binding |
                Assert.assertTrue(isElementPresent(By.cssSelector("#title-menu > div.product-container>div.products>div.item>div.col1>span.size")));
                // assertElementPresent | css=span.size.ng-binding |
                Assert.assertTrue(isElementPresent(By.cssSelector("#title-menu > div.product-container>div.products>div.item>div.col1>span.sku")));
                // assertElementPresent | css=span.sku.ng-binding |
                Assert.assertTrue(isElementPresent(By.cssSelector("#title-menu > div.product-container>div.products>div.item>div.col2>span.price")));
                // assertElementPresent | css=div.col1 > div |
                Assert.assertTrue(isElementPresent(By.cssSelector("div.col1 > div")));
                // click | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
                driver.findElement(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")).click();
                // assertElementPresent | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
                Assert.assertTrue(isElementPresent(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")));
                // assertText | //div[@id='title-menu']/div[3]/div/div/div[2]/button | REMOVE FROM CALCULATOR
                Assert.assertEquals(driver.findElement(By.xpath("//div[@id='title-menu']/div[3]/div/div/div[2]/button")).getText(), "EEMALDA KALKULAATORIST");
            }

            @Test

            public void testProductKER() throws Exception {
                driver.get(baseUrl);
                driver.findElement(By.cssSelector("div.navbar-item.lightblue > h3.ng-binding")).click();
                driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[2]/div")).click();
                driver.findElement(By.xpath("//div[@id='design-menu-navbar']/div/div[5]/div")).click();
                WebDriverWait wait = new WebDriverWait(driver, 7);
                WebElement canvasElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainCanvas")));
                Thread.sleep(5000);

                // теперь можно кликать
                Actions actions = new Actions(driver);
                actions.moveToElement(canvasElement).click().build().perform();
                // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));
                // click | xpath=(//input[@type='text'])[2] |
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
                Thread.sleep(5000);
    Assert.assertTrue(isElementPresent(By.cssSelector("//*[@id=\"title-menu\"]/div[@class=\"product-container\"]//div[@class=\"item\"]/div[@class=\"col1\" and strong[contains(.,'KER')]]/strong")));
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

