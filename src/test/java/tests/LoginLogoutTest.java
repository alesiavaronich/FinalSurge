package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.LoginPage;
import utils.RetryAnalyzer;

@Log4j
public class LoginLogoutTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Successful login")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Login success")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean userGreeting = loginPage.login()
                .isUserGreetingDisplayed();
        Assert.assertTrue(userGreeting, " 'Welcome' box is not found.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Successful logout")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Logout success")
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualMessage = loginPage.login()
                .clickLogoutLink()
                .getLogoutText();
        String expectedMessage = "You have been successfully logged out of the system.";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect logout message or no logout message is displayed.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Login failure - login and password input fields are left blank")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Login failure")
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
