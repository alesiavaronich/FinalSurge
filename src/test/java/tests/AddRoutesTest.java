package tests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

@Log4j
public class AddRoutesTest extends BaseTest{

    @Test
    public void addRoutesTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverGearAndRoutesDropdown()
                .selectRoutesOption()
                .isRoutesBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, "Breadcrumb is not visible");
    }
}
