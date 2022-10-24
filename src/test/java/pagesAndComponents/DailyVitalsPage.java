package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
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
