package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class CalendarTest extends BaseTest{

    @Test
    public void viewCalendarTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectViewCalendarOption();
    }
}
