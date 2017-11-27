package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;


public abstract class BaseTest {
    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        /*switch (browser) {
            case "chrome":
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseTest.class.getResource( "/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
            case "firefox":
            case "ie":
            case "internet explorer":
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseTest.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }*/
        System.setProperty(
                "webdriver.chrome.driver",
                new File(BaseTest.class.getResource( "/chromedriver.exe").getFile()).getPath());
        return new ChromeDriver();
    }

    public static WebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static boolean explicitWaitAndFind(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        if(driver.findElement(element).isDisplayed()) {return true;}
        else {return false;}
    }

    public static void explicitWaitAndClick(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public static void explicitWaitAndMove(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element), 1, 1).build().perform();
    }

    public static void explicitWaitAndSendKeys(WebDriver driver, By element, String message) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(message);
    }

    /*public static String getAlertMessage(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        String message = "";
        try{
            message = driver.findElement(element).getText();
        }
        catch(Exception ex){}
        return message;
    }*/

    public static void quitDriver(WebDriver driver) {
        driver.quit();
    }
}