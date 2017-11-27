package tests;

import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.BaseTest;

public class MyTest extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getConfiguredDriver();
        LoginPage loginPage = new LoginPage(driver);

        try {
            loginPage.open();
            loginPage.fillEmailInput();
            loginPage.fillPassInput();
            loginPage.clickLoginBtn();
        }
        catch(Exception ex) {
            quitDriver(driver);
            System.out.print("Ex LoginPage");
        }

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        try {
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
            System.out.print("Ex DashBoardPage");
        }


        //quitDriver(driver);
    }
}
