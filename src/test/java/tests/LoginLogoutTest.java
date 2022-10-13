package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginLogoutTest extends BaseTest{

    @Test
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
