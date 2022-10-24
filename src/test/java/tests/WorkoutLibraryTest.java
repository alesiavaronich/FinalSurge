package tests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

@Log4j
public class WorkoutLibraryTest extends BaseTest{

    @Test
    public void workoutLibraryTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectWorkoutLibraryOption()
                .isWorkoutLibraryBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, "Breadcrumb is not visible");
    }

}
