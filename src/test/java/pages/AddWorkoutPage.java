package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddWorkoutBreadcrumbVisible() {
        return addWorkoutBreadcrumb.isDisplayed();
    }

    public void selectWalkAccordionGroup() {
        walkAccordionGroup.click();
    }

    public void inputWorkoutDate(String date) {
        dateInput.sendKeys(date);
    }

    public void inputWorkoutTime(String time) {
        timeOfDayInput.sendKeys(time);
    }

    public void inputWorkoutName(String workoutName) {
        workoutNameInput.sendKeys(workoutName);
    }

    public void inputWorkoutDescription(String desc) {
        workoutDescriptionTextarea.sendKeys(desc);
    }

    public void checkPlannedWorkoutBox() {
        plannedWorkoutCheckbox.click();
    }


}
