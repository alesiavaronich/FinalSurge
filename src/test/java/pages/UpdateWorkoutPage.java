package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateWorkoutPage extends BasePage{

    @FindBy(xpath = "//input[@value='Update Workout']")
    private WebElement updateWorkoutButton;

    @FindBy(xpath = "//a[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='Distance']")
    private WebElement distanceInput;

    @FindBy(xpath = "//input[@id='Duration']")
    private WebElement durationInput;

    public UpdateWorkoutPage(WebDriver driver) {
        super(driver);
    }

    public WorkoutDetailsPage updateFormData() {
        updateWorkoutButton.click();
        return new WorkoutDetailsPage(driver);
    }

    public WorkoutDetailsPage cancelUpdate() {
        cancelButton.click();
        return new WorkoutDetailsPage(driver);
    }

    public UpdateWorkoutPage inputDistance(String dist) {
        distanceInput.clear();
        distanceInput.sendKeys(dist);
        return this;
    }

    public UpdateWorkoutPage inputDuration(String dur) {
        durationInput.clear();
        durationInput.sendKeys(dur);
        return this;
    }
}
