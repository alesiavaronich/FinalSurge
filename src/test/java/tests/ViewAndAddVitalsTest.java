package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;
import utils.RetryAnalyzer;

@Log4j
public class ViewAndAddVitalsTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Access 'Daily Vitals' page")
    @Severity(SeverityLevel.NORMAL)
    @Step("Access 'Daily Vitals' page")
    public void accessDailyVitalsPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbDisplayed = loginPage.login()
                .hoverOverDailyVitalsDropdown()
                .selectViewAndAddVitalsOption()
                .isDailyVitalsBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbDisplayed, "Breadcrumb is not visible.");
    }


}
