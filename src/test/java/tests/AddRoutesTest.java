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
public class AddRoutesTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Access 'Routes' page")
    @Severity(SeverityLevel.NORMAL)
    @Step("Access 'Routes' page")
    public void accessRoutesPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.login()
                .hoverOverGearAndRoutesDropdown()
                .selectRoutesOption()
                .isRoutesBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, "Breadcrumb is not visible");
    }
}
