package tests;

import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

public class ReportsAndStatisticsTest extends BaseTest{

    @Test
    public void reportsAndStatisticsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectReportsAndStatisticsOption();
    }
}
