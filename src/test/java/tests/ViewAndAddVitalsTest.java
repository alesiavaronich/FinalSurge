package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class ViewAndAddVitalsTest extends BaseTest{

    @Test
    public void customizeActivityTypesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverDailyVitalsDropdown()
                .selectViewAndAddVitalsOption();
    }
}
