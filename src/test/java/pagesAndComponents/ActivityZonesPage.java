package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ActivityZonesPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Activity Zones']")
    private WebElement activityZonesBreadcrumb;

    public ActivityZonesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isActivityZonesBreadcrumbVisible() {
        return activityZonesBreadcrumb.isDisplayed();
    }
}
