package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[contains(text(), 'Welcome,')]") private WebElement userGreeting;
    @FindBy(xpath = "//div[@class='user-info']//ul//li//a[text()='Logout']") private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserGreetingDisplayed() {
        return userGreeting.isDisplayed();
    }

    public LogoutPage clickLogoutLink() {
        logoutLink.click();
        return new LogoutPage(driver);
    }
}
