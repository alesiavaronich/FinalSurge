package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class RoutesPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Routes']")
    private WebElement routesBreadcrumb;

    public RoutesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRoutesBreadcrumbVisible() {
        return routesBreadcrumb.isDisplayed();
    }
}
