package pagesAndComponents;

import models.UserProfileModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserProfilePage extends BasePage{

    @FindBy(xpath = "//input[@id='fname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='BDay']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@id='City']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='Zip']")
    private WebElement zipInput;

    @FindBy(xpath = "//input[@id='saveButtonProfile']")
    private WebElement saveChangesButton;

    public EditUserProfilePage(WebDriver driver) {
        super(driver);
    }

    public UserProfilePage sendEditUserProfileForm(UserProfileModel userProfileModel) {
        firstNameInput.clear();
        firstNameInput.sendKeys(userProfileModel.getFirstName());
        lastNameInput.clear();
        lastNameInput.sendKeys(userProfileModel.getLastName());
        birthdayInput.clear();
        birthdayInput.sendKeys(userProfileModel.getBirthday());
        cityInput.clear();
        cityInput.sendKeys(userProfileModel.getCity());
        zipInput.clear();
        zipInput.sendKeys(userProfileModel.getZip());
        saveChangesButton.click();
        return new UserProfilePage(driver);
    }






}
