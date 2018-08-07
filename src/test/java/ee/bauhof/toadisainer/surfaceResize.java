package ee.bauhof.toadisainer;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class surfaceResize {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "d:/distribs/selenium/geckodriver.exe");
//        driver = new FirefoxDriver();
         driver = new ChromeDriver();
        baseUrl = "https://toadisainer.bauhof.ee";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void addNewProductAndVerifyCalcPage() throws Exception {
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
        // WebElement mainSceneElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-scene-holder")));

        // WebElement mainSceneWrapperElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main-scene-holder > div.main.scene-wrapper")));
//        wait.until(ExpectedConditions.visibilityOf(canvasElement));

        // ЗДЕСЬ ПОКА НЕ ПОЛУЧИЛОСЬ ИЗБАВИТЬСЯ ОТ sleep
        // НУЖНО НАЙТИ ПРАВИЛЬНОЕ УСЛОВИЕ ПРОДОЛЖЕНИЯ
        Thread.sleep(5000);

        // теперь можно кликать
        Actions actions = new Actions(driver);
        actions.moveToElement(canvasElement).click().build().perform();

//        WebElement search = driver.findElement(By.cssSelector("#title-menu > div.search-menu > div > input"));
        // waitForElementPresent | css=div.design-visualiser.ng-scope |

        // ЦИКЛ, В КОТОРОМ SLEEP ****> НИКОГДА ТАК НЕ ДЕЛАЙ
//        for (int second = 0;; second++) {
//            if (second >= 60);
//            try { if (isElementPresent(By.cssSelector("div.design-visualiser.ng-scope"))) break; } catch (Exception e) {}
//            Thread.sleep(1000);
//        }

        // ВМЕСТО ЦИКЛА ИСПОЛЬЗУЕМ ЯВНЫЕ ОЖИДАНИЯ
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.design-visualiser.ng-scope")));

        // click | //div[@id='title-menu']/div[3]/div/div/div[2]/button |
//        actions.moveToElement(canvasElement,430,100 ).click().build().perform();
        // storeElementPresent | css=strong.ng-binding |

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div[1]/div/div[1]")).click();
        Thread.sleep(500);
        // verifyText | css=div.room-head > h4.ng-binding | Vali sobiv ruumi kuju
//        actions.moveToElement(canvasElement).click().build().perform();
        actions.moveToElement(canvasElement,1330,400 ).clickAndHold().moveByOffset(1000, 400).release().perform();
        Thread.sleep(30000);

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
