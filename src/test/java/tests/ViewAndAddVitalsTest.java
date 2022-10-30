package tests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;
import utils.RetryAnalyzer;

@Log4j
public class ViewAndAddVitalsTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void accessDailyVitalsPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbDisplayed = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverDailyVitalsDropdown()
                .selectViewAndAddVitalsOption()
                .isDailyVitalsBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbDisplayed, "Breadcrumb is not visible.");
    }


}
