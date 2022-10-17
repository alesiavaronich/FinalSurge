package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddWorkoutTest extends BaseTest {

    @Test
    public void accessAddWorkoutPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .isAddWorkoutBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, " 'Add Workout' breadcrumb is not visible.");
    }

    @Test
    public void addNewWorkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbOnSaveDisplayed = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/11/2022")
                .inputWorkoutTime("07:00 AM")
                .inputWorkoutName("Morning walk")
                .inputWorkoutDescription("Walking every morning at 7 am")
                .checkPlannedWorkoutBox()
                .inputPlannedDistance("2")
                .inputPlannedDuration("00:40:00")
                .inputDistance("2.5")
                .inputDuration("00:51:16")
                .selectHowIFeltRadio("good")
                .inputMinHR()
                .inputMaxHR()
                .saveFormData()
                .isAddWorkoutBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbOnSaveDisplayed, " 'View and Edit your workout' breadcrumb is not visible");
    }


}
