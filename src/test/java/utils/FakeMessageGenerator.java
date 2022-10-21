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

    public static String generateMinNum() {
        int num = new Faker().number().numberBetween(60, 90);
        if(num > 100) {
            num = num/10;
        }
        String strNum = String.valueOf(num);
        return strNum;
    }

    public static String generateMaxNum() {
        return String.valueOf(new Faker().number().numberBetween(90, 200));
    }
}
