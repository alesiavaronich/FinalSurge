package tests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;
import utils.RetryAnalyzer;

@Log4j
public class CustomizeActivityTypesTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void customizeActivityTypesTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectCustomizeActivityTypesOption()
                .isActivityTypesBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, "Breadcrumb is not visible");
    }
}
