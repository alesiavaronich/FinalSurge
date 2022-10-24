package tests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.CalendarPage;
import pagesAndComponents.LoginPage;

@Log4j
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
