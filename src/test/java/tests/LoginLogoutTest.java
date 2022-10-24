package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;

@Log4j
public class LoginLogoutTest extends BaseTest{

    @Test
    @Description("Successful login")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean userGreeting = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .isUserGreetingDisplayed();
        Assert.assertTrue(userGreeting, " 'Welcome' box is not found.");
    }

    @Test
    @Description("Successful logout")
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualMessage = loginPage.openLoginPage()
                .inputLoginName()
                .inputPassword()
                .clickLoginButton()
                .clickLogoutLink()
                .getLogoutText();
        String expectedMessage = "You have been successfully logged out of the system.";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect logout message or no logout message is displayed.");
    }

    @Test
    @Description("Login failure - login and password input fields are left blank")
    public void loginWithoutNameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().leaveLoginNameBlank().leavePasswordBlank().clickLoginButton();
        String actualLoginErrorText = loginPage.getLoginNameErrorText();
        String expectedLoginErrorText = "Please enter your e-mail address.";
        String actualPasswordErrorText = loginPage.getPasswordErrorText();
        String expectedPasswordErrorText = "Please enter a password.";
        Assert.assertEquals(actualLoginErrorText, expectedLoginErrorText, "Login error message is incorrect");
        Assert.assertEquals(actualPasswordErrorText, expectedPasswordErrorText, "Password error message is incorrect");
    }


}
