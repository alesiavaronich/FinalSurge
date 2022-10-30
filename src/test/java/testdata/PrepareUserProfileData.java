package testdata;

import lombok.extern.log4j.Log4j;
import models.UserProfileModel;
import utils.FakeMessageGenerator;

@Log4j
public class PrepareUserProfileData {

    public static String lastName = FakeMessageGenerator.generateLastName();
    public static String firstName = FakeMessageGenerator.generateFirstName();

    public static UserProfileModel getValidData() {
        log.info("getValidData method starts generating test data to populate Edit User Profile form");
        return UserProfileModel
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthday(FakeMessageGenerator.generateBirthDate())
                .city(FakeMessageGenerator.generateCity())
                .zip(FakeMessageGenerator.generateZip())
                .build();
    }
}
