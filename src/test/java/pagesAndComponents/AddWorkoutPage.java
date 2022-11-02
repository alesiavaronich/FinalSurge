package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import models.NewWorkoutModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class AddWorkoutPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Add Workout']")
    private WebElement addWorkoutBreadcrumb;

    @FindBy(xpath = "//div[@id='blog_accordion_left']//a[@data-code='walk']")
    private WebElement walkAccordionGroup;

    @FindBy(xpath = "//input[@id='WorkoutDate']")
    private WebElement dateInput;

    @FindBy(xpath = "//input[@id='WorkoutTime']")
    private WebElement timeOfDayInput;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement workoutNameInput;

    @FindBy(xpath = "//textarea[@id='Desc']")
    private WebElement workoutDescriptionTextarea;

    @FindBy(xpath = "//input[@id='PlannedWorkout']")
    private WebElement plannedWorkoutCheckbox;

    @FindBy(xpath = "//input[@id='PDistance']")
    private WebElement plannedDistanceInput;

    @FindBy(xpath = "//input[@id='PDuration']")
    private WebElement plannedDurationInput;

    @FindBy(xpath = "//input[@id='Distance']")
    private WebElement distanceInput;

    @FindBy(xpath = "//input[@id='Duration']")
    private WebElement durationInput;

    @FindBy(xpath = "//input[@id='hf_great']")
    private WebElement feltGreatRadio;

    @FindBy(xpath = "//input[@id='hf_good']")
    private WebElement feltGoodRadio;

    @FindBy(xpath = "//input[@id='hf_normal']")
    private WebElement feltNormalRadio;

    @FindBy(xpath = "//input[@id='hf_poor']")
    private WebElement feltPoorRadio;

    @FindBy(xpath = "//input[@id='hf_terrible']")
    private WebElement feltTerribleRadio;

    @FindBy(xpath = "//input[@id='MinHR']")
    private WebElement minHrInput;

    @FindBy(xpath = "//input[@id='MaxHR']")
    private WebElement maxHrInput;

    @FindBy(xpath = "//input[@id='AvgHR']")
    private WebElement avgHrInput;

    @FindBy(xpath = "//input[@id='kCal']")
    private WebElement caloriesBurnedInput;

    @FindBy(xpath = "//input[@value='Add Workout']")
    private WebElement addWorkoutButton;

    @FindBy(xpath = "//div[contains(@class,'alert alert-error') and contains(.,'Please enter a value for Workout Date')]")
    private WebElement errorMessageMissingWorkoutDate;

    @FindBy(xpath = "//div[contains(@class,'alert alert-error') and contains(.,'Please enter a valid Pace')]")
    private WebElement errorMessageInvalidPace;

    @FindBy(xpath = "//div[contains(@class,'alert alert-error') and contains(.,'Minimum Heartrate cannot be greater than 300.')]")
    private WebElement errorMessageInvalidHeartRate;


    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }


    public AddWorkoutPage selectWalkAccordionGroup() {
        walkAccordionGroup.click();
        return this;
    }

    public AddWorkoutPage clearDateInput() {
        dateInput.clear();
        return this;
    }

    public AddWorkoutPage inputWorkoutDate(String date) {
        dateInput.clear();
        dateInput.sendKeys(date,Keys.TAB);
        return this;
    }

    public AddWorkoutPage inputWorkoutTime(String time) {
        timeOfDayInput.sendKeys(time);
        return this;
    }

    public AddWorkoutPage inputWorkoutName(String workoutName) {
        workoutNameInput.sendKeys(workoutName);
        return this;
    }

    public AddWorkoutPage inputWorkoutDescription(String desc) {
        workoutDescriptionTextarea.sendKeys(desc);
        return this;
    }

    public AddWorkoutPage checkPlannedWorkoutBox() {
        plannedWorkoutCheckbox.click();
        return this;
    }

    public AddWorkoutPage inputPlannedDistance(String dist) {
        plannedDistanceInput.sendKeys(dist);
        return this;
    }

    public AddWorkoutPage inputPlannedDuration(String dur) {
        plannedDurationInput.sendKeys(dur);
        return this;
    }

    public AddWorkoutPage inputDistance(String dist) {
        distanceInput.sendKeys(dist);
        return this;
    }

    public AddWorkoutPage inputDuration(String dur) {
        durationInput.sendKeys(dur);
        return this;
    }

    public AddWorkoutPage selectHowIFeltRadio(String condition) {
        switch (condition) {
            case "great": feltGreatRadio.click(); break;
            case "good": feltGoodRadio.click(); break;
            case "normal": feltNormalRadio.click(); break;
            case "poor": feltPoorRadio.click(); break;
            case "terrible": feltTerribleRadio.click(); break;
        }
        return this;
    }

    public AddWorkoutPage inputMinHR(String strNum) {
        minHrInput.sendKeys(strNum);
        return this;
    }

    public AddWorkoutPage inputMaxHR(String strNum) {
        maxHrInput.sendKeys(strNum);
        return this;
    }

    public boolean isAddWorkoutBreadcrumbVisible() {
        return addWorkoutBreadcrumb.isDisplayed();
    }

    public WorkoutDetailsPage saveFormDataSuccess() {
        addWorkoutButton.click();
        return new WorkoutDetailsPage(driver);
    }

    public AddWorkoutPage saveFormDataFailure() {
        addWorkoutButton.click();
        return this;
    }

    public boolean isWorkoutDateErrorMessageDisplayed() {
        return errorMessageMissingWorkoutDate.isDisplayed();
    }

    public String  getWorkoutDateErrorMessage() {
        return errorMessageMissingWorkoutDate.getText();
    }

    public boolean isInvalidPaceErrorMessageDisplayed() {
        return errorMessageInvalidPace.isDisplayed();
    }

    public String getInvalidPaceErrorMessage() {
        return errorMessageInvalidPace.getText();
    }

    public boolean isHeartrateErrorMessageDisplayed() {
        return errorMessageInvalidHeartRate.isDisplayed();
    }

    public String getHeartrateErrorMessage() {
        return errorMessageInvalidHeartRate.getText();
    }

    public WorkoutDetailsPage sendAddWorkoutForm(NewWorkoutModel newWorkoutModel) {
        dateInput.clear();
        dateInput.sendKeys(newWorkoutModel.getDate());
        timeOfDayInput.sendKeys(newWorkoutModel.getTimeOfDay());
        workoutNameInput.sendKeys(newWorkoutModel.getWorkoutName());
        workoutDescriptionTextarea.sendKeys(newWorkoutModel.getWorkoutDescription());
        distanceInput.sendKeys(newWorkoutModel.getDistance());
        durationInput.sendKeys(newWorkoutModel.getDuration());
        minHrInput.sendKeys(newWorkoutModel.getMinHr());
        maxHrInput.sendKeys(newWorkoutModel.getMaxHr());
        addWorkoutButton.click();
        return new WorkoutDetailsPage(driver);
    }
}
