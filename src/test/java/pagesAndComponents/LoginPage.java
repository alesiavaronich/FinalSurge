package pagesAndComponents;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login_name") private WebElement loginNameInput;
    @FindBy(id = "login_password") private WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Login']") private WebElement loginButton;
    @FindBy(xpath = "//div[@class='formpad']//label[text()='Please enter your e-mail address.']") private WebElement loginNameErrorMessage;
    @FindBy(xpath = "//div[@class='formpad']//label[text()='Please enter a password.']") private WebElement passwordErrorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(Urls.FINAL_SURGE_LOGINPAGE);
        return this;
    }

    public LoginPage inputLoginName() {
        loginNameInput.sendKeys(Credentials.LOGIN);
        return this;
    }

    public LoginPage leaveLoginNameBlank() {
        loginNameInput.sendKeys("");
        return this;
    }

    public LoginPage inputPassword() {
        passwordInput.sendKeys(Credentials.PASSWORD);
        return this;
    }

    public LoginPage leavePasswordBlank() {
        passwordInput.sendKeys("");
        return this;
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

    public String getLoginNameErrorText() {
        return loginNameErrorMessage.getText();
    }

    public String getPasswordErrorText() {
        return passwordErrorMessage.getText();
    }

    public HomePage login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton();
        return new HomePage(driver);
    }


}
