package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import models.UserProfileModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.EditUserProfilePage;
import pagesAndComponents.LoginPage;
import testdata.PrepareUserProfileData;
import utils.RetryAnalyzer;

public class EditUserProfileTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Access user profile via 'Settings' and fill out the 'User Profile' form by random data")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Edit User profile")
    public void editUserProfileTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login()
                .clickSettingsLink()
                .clickEditProfileButton();
        EditUserProfilePage editUserProfilePage = new EditUserProfilePage(driver);
        UserProfileModel userProfileModel = PrepareUserProfileData.getValidData();
        boolean isUsernameDisplayed = editUserProfilePage
                .sendEditUserProfileForm(userProfileModel)
                .isUsernameDisplayed();
        Assert.assertTrue(isUsernameDisplayed, "Username is missing");
    }
}
