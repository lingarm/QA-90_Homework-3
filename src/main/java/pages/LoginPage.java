package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Properties;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.id("email");
    private By passInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");
    private String email = "webinar.test@gmail.com";
    private  String password = "Xcg7299bnSmMuRLp9ITw";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(Properties.getBaseAdminUrl());
    }

    public void fillEmailInput() {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassInput() {
        driver.findElement(passInput).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
