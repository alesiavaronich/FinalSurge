package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class WorkoutLibraryTest extends BaseTest{

    @Test
    public void workoutLibraryTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .hoverOverWorkoutsDropdown()
                .selectWorkoutLibraryOption();
    }

}
