package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class AddBikesTest extends BaseTest{

    @Test
    public void addBikesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverGearAndRoutesDropdown()
                .selectBikesOption();
    }
}
