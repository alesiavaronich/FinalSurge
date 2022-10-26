package tests;

import models.UserProfileModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndComponents.EditUserProfilePage;
import pagesAndComponents.LoginPage;
import testdata.PrepareUserProfileData;

public class EditUserProfileTest extends BaseTest{

    @Test
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
