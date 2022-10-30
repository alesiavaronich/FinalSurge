package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class FakeMessageGenerator {

    public static String generateBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        String dob = sdf.format(faker.date().birthday());
        return dob;
    }

    public static String generateCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        String currentMonth = String.valueOf(currentDate.getMonthValue());
        String currentDay = String.valueOf(currentDate.getDayOfMonth());
        String currentYear = String.valueOf(currentDate.getYear());
        return currentMonth.concat("/").concat(currentDay).concat("/").concat(currentYear);
    }

    public static String generateWorkoutDescription() {
        return new Faker().lorem().sentence();
    }

    public static String generateDistance() {
        return String.valueOf(new Faker().number().numberBetween(1, 5));
    }

    public static String generateMinNum() {
        return String.valueOf(new Faker().number().numberBetween(60, 90));
    }

    public static String generateMaxNum() {
        return String.valueOf(new Faker().number().numberBetween(90, 200));
    }

    public static String generateFirstName() {
        return new Faker().name().firstName();
    }

    public static String generateLastName() {
        return new Faker().name().lastName();
    }

    public static String generateCity() {
        return new Faker().address().city();
    }

    public static String generateZip() {
        return new Faker().address().zipCode();
    }
}
