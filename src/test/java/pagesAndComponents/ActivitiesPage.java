package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ActivitiesPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Activity Types']")
    private WebElement activityTypesBreadcrumb;

    public ActivitiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isActivityTypesBreadcrumbVisible() {
        return activityTypesBreadcrumb.isDisplayed();
    }
}
