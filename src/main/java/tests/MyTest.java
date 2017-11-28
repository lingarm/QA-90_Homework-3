package tests;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.BaseTest;

public class MyTest extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        EventFiringWebDriver driver = getConfiguredDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);

        try {
            loginPage.open();
            loginPage.fillEmailInput();
            loginPage.fillPassInput();
            loginPage.clickLoginBtn();

            dashBoardPage.clickCategory();
            dashBoardPage.clickAddCategory();
            dashBoardPage.addCategoryName();
            dashBoardPage.clickSaveCategory();
            dashBoardPage.isSuccessMessage();
            dashBoardPage.clickSortName();
            dashBoardPage.isCategoryAdded();
        }
        catch(Exception ex) {
            quitDriver(driver);
        }

        quitDriver(driver);
    }
}
