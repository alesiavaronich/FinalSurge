package pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

    @FindBy(xpath = "//div[@class='alert alert-success']//strong") private WebElement logoutSuccessMessage;
    @FindBy(xpath = "//div[@class='alert alert-success']//strong") private WebElement logoutLabel;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public String getLogoutText() {
        return logoutSuccessMessage.getText();
    }

    public boolean isLogoutLabelDisplayed() {
        return logoutLabel.isDisplayed();
    }


}
