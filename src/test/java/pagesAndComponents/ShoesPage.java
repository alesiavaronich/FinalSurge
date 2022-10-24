package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ShoesPage extends BasePage{

    @FindBy(xpath = "//ul[@id='breadcrumbs']//li//a[text()='Shoes']")
    private WebElement shoesBreadcrumb;

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoesBreadcrumbVisible() {
        return shoesBreadcrumb.isDisplayed();
    }
}
