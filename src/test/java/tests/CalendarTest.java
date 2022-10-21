package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.LoginPage;

public class CalendarTest extends BaseTest{

    @Test
    public void viewCalendarTest() {
        LoginPage loginPage = new LoginPage(driver);
        String currentMonthHeader = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectViewCalendarOption()
                .getCurrentMonthFromAppCalendar();

        CalendarPage calendar = new CalendarPage(driver);
        String currentCalendarMonthAndYear = calendar.getCurrentMonthAndYear();

        Assert.assertEquals(currentMonthHeader, currentCalendarMonthAndYear, "Incorrect month or year.");

    }
}
