package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Log4j
public class TopNavComponent extends BasePage{

    @FindBy(xpath = "//div[contains(text(), 'Welcome,')]")
    private WebElement userGreeting;

    @FindBy(xpath = "//div[@class='user-info']//ul//li//a[text()='Logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']")
    private WebElement workoutsDropdown;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Daily Vitals']")
    private WebElement dailyVitalsDropdown;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Gear & Routes']")
    private WebElement gearAndRoutesDropdown;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='Add Workout']")
    private WebElement addWorkoutOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='View Calendar']")
    private WebElement viewCalendarOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='Reports & Statistics']")
    private WebElement reportsAndStatisticsOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='Workout Library']")
    private WebElement workoutLibraryOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='HR/Power/Pace Zones']")
    private WebElement hrPowerPaceZonesOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Workouts']//ancestor::li//ul//li//a[text()='Customize Activity Types']")
    private WebElement customizeActivityTypesOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Daily Vitals']//ancestor::li//ul//li//a[text()='View & Add Vitals']")
    private WebElement viewAndAddVitalsOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Gear & Routes']//ancestor::li//ul//li//a[text()='Shoes']")
    private WebElement shoesOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Gear & Routes']//ancestor::li//ul//li//a[text()='Bikes']")
    private WebElement bikesOption;

    @FindBy(xpath = "//div[@id='fade-menu']//a[text()='Gear & Routes']//ancestor::li//ul//li//a[text()='Routes']")
    private WebElement routesOption;

    @FindBy(xpath = "//nav[@class='nav-icons']//ul/li/a[@href='Calendar.cshtml']")
    private WebElement calendarNavIcon;

    @FindBy(xpath = "//div[@class='user-info']//ul//li//a[text()='Settings']")
    private WebElement settingsLink;


    public TopNavComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isUserGreetingDisplayed() {
        return userGreeting.isDisplayed();
    }

    public LogoutPage clickLogoutLink() {
        logoutLink.click();
        return new LogoutPage(driver);
    }

    public TopNavComponent hoverOverWorkoutsDropdown() {
        Actions act = new Actions(driver);
        act.moveToElement(workoutsDropdown).perform();
        return this;
    }

    public AddWorkoutPage selectAddWorkoutOption() {
        addWorkoutOption.click();
        return new AddWorkoutPage(driver);
    }

    public CalendarPage selectViewCalendarOption() {
        viewCalendarOption.click();
        return new CalendarPage(driver);
    }

    public ReportsPage selectReportsAndStatisticsOption() {
        reportsAndStatisticsOption.click();
        return new ReportsPage(driver);
    }

    public WorkoutLibraryPage selectWorkoutLibraryOption() {
        workoutLibraryOption.click();
        return new WorkoutLibraryPage(driver);
    }

    public ActivityZonesPage selectHrPowerPaceZonesOption() {
        hrPowerPaceZonesOption.click();
        return new ActivityZonesPage(driver);
    }

    public ActivitiesPage selectCustomizeActivityTypesOption() {
        customizeActivityTypesOption.click();
        return new ActivitiesPage(driver);
    }

    public TopNavComponent hoverOverDailyVitalsDropdown() {
        Actions act = new Actions(driver);
        act.moveToElement(dailyVitalsDropdown).perform();
        return this;
    }

    public DailyVitalsPage selectViewAndAddVitalsOption() {
        viewAndAddVitalsOption.click();
        return new DailyVitalsPage(driver);
    }

    public TopNavComponent hoverOverGearAndRoutesDropdown() {
        Actions act = new Actions(driver);
        act.moveToElement(gearAndRoutesDropdown).perform();
        return this;
    }

    public ShoesPage selectShoesOption() {
        shoesOption.click();
        return new ShoesPage(driver);
    }

    public BikesPage selectBikesOption() {
        bikesOption.click();
        return new BikesPage(driver);
    }

    public RoutesPage selectRoutesOption() {
        routesOption.click();
        return new RoutesPage(driver);
    }

    public CalendarPage clickCalendarNavIcon() {
        calendarNavIcon.click();
        return new CalendarPage(driver);
    }

    public UserProfilePage clickSettingsLink() {
        settingsLink.click();
        return new UserProfilePage(driver);
    }




}
