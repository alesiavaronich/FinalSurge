package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.HomePage;
import pagesAndComponents.LoginPage;

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
                .inputWorkoutDate("10/13/2022")
                .inputWorkoutTime("07:00 AM")
                .inputWorkoutName("Morning walk")
                .inputWorkoutDescription("Walking every morning at 7 am")
                .checkPlannedWorkoutBox()
                .inputPlannedDistance("2")
                .inputPlannedDuration("00:40:00")
                .inputDistance("2.5")
                .inputDuration("00:51:16")
                .selectHowIFeltRadio("good")
                .inputMinHR("65")
                .inputMaxHR("150")
                .saveFormDataSuccess()
                .isWorkoutDetailsBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbOnSaveDisplayed, " 'Workout Details' breadcrumb is not visible");
    }

    @Test
    public void isWorkoutDateMissingErrorDisplayedTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isErrorDisplayed = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .clearDateInput()
                .saveFormDataFailure()
                .isWorkoutDateErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Incorrect or missing error message.");
    }

    @Test
    public void validateWorkoutDateMissingErrorTextTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualErrorText = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .clearDateInput()
                .saveFormDataFailure()
                .getWorkoutDateErrorMessage();
        String expectedErrorText = "×\nPlease fix the following errors:\n*Please enter a value for Workout Date.";
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    @Test
    public void isInvalidPaceErrorDisplayedTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isErrorDisplayed = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .inputDistance("2")
                .inputDuration("15:00:00")
                .saveFormDataFailure()
                .isInvalidPaceErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Incorrect or missing error message.");
    }

    @Test
    public void validatePaceErrorTextTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualErrorText = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .inputDistance("2")
                .inputDuration("15:00:00")
                .saveFormDataFailure()
                .getInvalidPaceErrorMessage();
        String expectedErrorText = "×\nPlease fix the following errors:\n*Please enter a valid Pace in the format minutes:seconds (mm:ss).";
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    @Test
    public void isInvalidHeartrateErrorDisplayedTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isErrorDisplayed = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .inputMinHR("301")
                .saveFormDataFailure()
                .isHeartrateErrorMessageDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Incorrect or missing error message.");
    }

    @Test
    public void validateHeartrateErrorTextTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualErrorText = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .inputMinHR("301")
                .saveFormDataFailure()
                .getHeartrateErrorMessage();
        String expectedErrorText = "×\nPlease fix the following errors:\n*Minimum Heartrate cannot be greater than 300.";
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    @Test
    public void cancelUpdateTest() {
        //Precondition - login and add a new workout
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .saveFormDataSuccess();
        //Test - access calendar, access saved activity via update menu option, then cancel update
        HomePage homePage = new HomePage(driver);
        homePage.clickCalendarNavIcon()
                .selectActivity("10/23/2022")
                .selectUpdateWorkoutOption()
                .cancelUpdate();
    }

    @Test
    public void updateWorkoutTest() {
        //Precondition - login and add a new workout
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .saveFormDataSuccess();
        //Test - access calendar, access saved activity via update menu option, then update selected fields
        HomePage homePage = new HomePage(driver);
        homePage.clickCalendarNavIcon()
                .selectActivity("10/23/2022")
                .selectUpdateWorkoutOption()
                .inputDistance("3.2")
                .inputDuration("01:02:45")
                .updateFormData();
    }

    @Test
    public void deleteWorkoutTest() {
        //Precondition - login and add a new workout
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .saveFormDataSuccess();
        //Test - access activity via calendar, then delete activity
        HomePage homePage = new HomePage(driver);
        homePage.clickCalendarNavIcon()
                .selectActivity("10/13/2022")
                .selectQuickDeleteOption()
                .acceptFalseAlert();

    }


}
