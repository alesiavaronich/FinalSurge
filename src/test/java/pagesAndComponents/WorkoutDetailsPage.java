package pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkoutDetailsPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Workout Details']")
    private WebElement workoutDetailsBreadcrumb;

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWorkoutDetailsBreadcrumbVisible() {
        return workoutDetailsBreadcrumb.isDisplayed();
    }


}
