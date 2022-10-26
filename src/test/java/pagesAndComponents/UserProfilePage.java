package pagesAndComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(xpath = "//a[@id='ProfileEditLink']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//*[@id=\"EditProfile\"]//small[text()='Name:']//parent::p")
    private WebElement userName;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditUserProfilePage clickEditProfileButton() {
        editProfileButton.click();
        return new EditUserProfilePage(driver);
    }

    public String getName() {
        String name = userName.getText();
        return name.replace("Name: ", "");
    }

    public boolean isUsernameDisplayed() {
        return userName.isDisplayed();
    }
}
