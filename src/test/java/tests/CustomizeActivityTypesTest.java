package tests;

import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

public class CustomizeActivityTypesTest extends BaseTest{

    @Test
    public void customizeActivityTypesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectCustomizeActivityTypesOption();
    }
}
