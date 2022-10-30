package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.CalendarPage;
import pagesAndComponents.LoginPage;
import utils.RetryAnalyzer;

@Log4j
public class CalendarTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Access calendar, then validate that current month and year are displayed by default")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Validate Calendar")
    public void viewCalendarTest() {
        LoginPage loginPage = new LoginPage(driver);
        String currentMonthHeader = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectViewCalendarOption()
                .getCurrentMonthFromAppCalendar();

        CalendarPage calendar = new CalendarPage(driver);
        String currentCalendarMonthAndYear = calendar.getCurrentMonthAndYear();

        Assert.assertEquals(currentMonthHeader, currentCalendarMonthAndYear, "Incorrect month or year.");

    }
}
