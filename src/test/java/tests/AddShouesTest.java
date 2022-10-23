package tests;

import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

public class AddShouesTest extends BaseTest{

    @Test
    public void addShoesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverGearAndRoutesDropdown()
                .selectShoesOption();
    }
}
