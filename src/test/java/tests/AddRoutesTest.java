package tests;

import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

public class AddRoutesTest extends BaseTest{

    @Test
    public void addRoutesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverGearAndRoutesDropdown()
                .selectRoutesOption();
    }
}
