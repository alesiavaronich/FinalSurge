package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class BikesPage extends BasePage{

    //Report a bug - Shoes page was copied and pasted. Therefore, most of the ID and class names refer to shoes, not bikes!
    //Anticipating further page updates. Page objects and tests would need to be updated to reflect correct IDs, classes etc.

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Bikes']")
    private WebElement bikesBreadcrumb;

    public BikesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBikesBreadcrumbVisible() {
        return bikesBreadcrumb.isDisplayed();
    }
}
