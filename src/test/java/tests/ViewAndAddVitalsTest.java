package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ViewAndAddVitalsTest extends BaseTest{

    @Test
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
