package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class WorkoutLibraryPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Workout Library']")
    private WebElement workoutLibraryBreadcrumb;

    public WorkoutLibraryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWorkoutLibraryBreadcrumbVisible() {
        return workoutLibraryBreadcrumb.isDisplayed();
    }

}
