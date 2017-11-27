package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseTest;

import java.sql.Timestamp;

public class DashBoardPage extends BaseTest{
    private WebDriver driver;

    private By catalog = By.id("subtab-AdminCatalog");
    private By category = By.id("subtab-AdminCategories");
    private By addCategory = By.id("page-header-desc-category-new_category");
    private String categoryName ="Samus test category " + new Timestamp(System.currentTimeMillis()).getTime();
    private By categoryNameInput = By.id("name_1");
    private By categotySaveBtn = By.id("category_form_submit_btn");
    private By messageSuccess = By.xpath("//*[@class='alert alert-success']");
    private By sortNameBtn = By.xpath("//span[contains(text(), 'Имя')]/a[2]");
    private By myCategory = By.xpath("//td[contains(text(), '" + categoryName + "')]");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCategory() {
        explicitWaitAndMove(driver, catalog);
        explicitWaitAndClick(driver, category);
    }

    public void clickAddCategory() {
        explicitWaitAndClick(driver, addCategory);
    }

    public void addCategoryName() {
        explicitWaitAndSendKeys(driver, categoryNameInput, categoryName);
    }

    public void clickSaveCategory() {
        explicitWaitAndClick(driver, categotySaveBtn);
    }

    public void isSuccessMessage() {
        if(explicitWaitAndFind(driver, messageSuccess)) {}
        else {}
    }

    public void clickSortName() {
        explicitWaitAndClick(driver, sortNameBtn);
    }

    public void isCategoryAdded() {
        if(explicitWaitAndFind(driver, myCategory)) {}
        else {}
    }
}