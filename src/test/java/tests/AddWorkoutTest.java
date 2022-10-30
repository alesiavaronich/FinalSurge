package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.NewWorkoutModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.AddWorkoutPage;
import pagesAndComponents.LoginPage;
import pagesAndComponents.TopNavComponent;
import testdata.PrepareNewWorkoutData;
import utils.RetryAnalyzer;

@Log4j
public class AddWorkoutTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Access 'Add Workout' page.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Accessing workouts page")
    public void accessAddWorkoutPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isBreadcrumbVisible = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .isAddWorkoutBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbVisible, " 'Add Workout' breadcrumb is not visible.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Add new walk workout using a model and randomly generated test data.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Adding new workout")
    public void addNewWorkoutWithModelTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddWorkoutPage addWorkoutPage = loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup();
        NewWorkoutModel newWorkoutModel = PrepareNewWorkoutData.getValidData();
        boolean isBreadcrumbOnSaveDisplayed = addWorkoutPage
                .sendAddWorkoutForm(newWorkoutModel)
                .isWorkoutDetailsBreadcrumbVisible();
        Assert.assertTrue(isBreadcrumbOnSaveDisplayed, " 'Workout Details' breadcrumb is not visible.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with date missing. Expecting an error message to appear.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with date missing. Validating an error message.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with invalid pace: " +
            "calculated automatically, based on distance and duration." +
            "Expecting an error message to appear.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with invalid pace: " +
            "calculated automatically, based on distance and duration." +
            "Validating an error message.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with invalid heartrate. Max value for minHR is 300. Expecting an error message to appear.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Attempt to save a workout with invalid heartrate. Max value for minHR is 300. Validating an error message.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Adding new workout")
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Save a new walk workout, then access it via Calendar, attempt to update, then cancel update.")
    @Severity(SeverityLevel.NORMAL)
    @Step("Updating new workout")
    public void cancelUpdateTest() {
        log.info("Precondition - login and add a new workout");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .saveFormDataSuccess();

        log.info("Test - access calendar, access saved activity via update menu option, then cancel update");

        TopNavComponent topNavComponent = new TopNavComponent(driver);
        topNavComponent.clickCalendarNavIcon()
                .refreshPage()
                .selectActivity("10/23/2022")
                .selectUpdateWorkoutOption("10/23/2022")
                .cancelUpdate();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Save a new walk workout, then access it via Calendar and update distance and duration.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Updating new workout")
    public void updateWorkoutTest() {
        log.info("Precondition - login and add a new workout");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/21/2022")
                .saveFormDataSuccess();

        log.info("Test - access calendar, access saved activity via update menu option, then update selected fields");

        TopNavComponent topNavComponent = new TopNavComponent(driver);
        topNavComponent.clickCalendarNavIcon()
                .selectActivity("10/21/2022")
                .selectUpdateWorkoutOption("10/21/2022")
                .inputDistance("3.2")
                .inputDuration("01:02:45")
                .updateFormData();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Save a walk workout, then delete it by accessing it via Calendar.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Deleting new workout")
    public void deleteWorkoutTest() {
        log.info("Precondition - login and add a new workout");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .hoverOverWorkoutsDropdown()
                .selectAddWorkoutOption()
                .selectWalkAccordionGroup()
                .inputWorkoutDate("10/23/2022")
                .saveFormDataSuccess();

        log.info("Test - access activity via calendar, then delete activity");

        TopNavComponent topNavComponent = new TopNavComponent(driver);
        topNavComponent.clickCalendarNavIcon()
                .selectActivity("10/23/2022")
                .selectQuickDeleteOption("10/23/2022")
                .acceptFalseAlert();

    }


}
