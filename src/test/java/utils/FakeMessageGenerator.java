package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class FakeMessageGenerator {

    public static String generateBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        String dob = sdf.format(faker.date().birthday());
        return dob;
    }

    public static String generateWebsiteUrl() {
        return new Faker().internet().url();
    }
}
