package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddWorkoutTest extends BaseTest {

    @Test
    public void addWorkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .isAddWorkoutBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, " 'Add Workout' breadcrumb is not visible.");
    }
}
