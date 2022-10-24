package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ReportsPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Athlete Workout Report']")
    private WebElement reportsBreadcrumb;

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReportsBreadcrumbVisible() {
        return reportsBreadcrumb.isDisplayed();
    }
}
