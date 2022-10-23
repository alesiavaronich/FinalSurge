package pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DailyVitalsPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Daily Vitals']")
    private WebElement dailyVitalsBreadcrumb;

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDailyVitalsBreadcrumbVisible() {
        return dailyVitalsBreadcrumb.isDisplayed();
    }
}
