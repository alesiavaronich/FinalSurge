package pagesAndComponents;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Locale;

@Log4j
public class CalendarPage extends BasePage{


    private String activityByDate = "//div[@data-date='%s'][1]";
    private String updateWorkoutOption = "//div[@data-date='%s'][1]//a[text()='Update Workout']";
    private String quickDeleteOption = "//div[@data-date='%s'][1]//a[text()='Delete']";

    @FindBy(xpath = "//div[@class='bootbox modal fade in']//div[@class='modal-footer']/a[text()='OK']")
    private WebElement falseAlert;

    @FindBy(xpath = "//div[@class='fc-header-center']//a[@id='dpMonth']")
    private WebElement currentMonthMenuHeader;


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPage selectActivity(String date) {
        String finalXpath = String.format(activityByDate, date);
        driver.findElement(By.xpath(finalXpath)).click();
        return this;
    }

    public void setExplicitlyWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public CalendarPage selectQuickDeleteOption(String date) {
        String finalXpath = String.format(quickDeleteOption, date);
        driver.findElement(By.xpath(finalXpath)).click();
        return this;
    }

    public UpdateWorkoutPage selectUpdateWorkoutOption(String date) {
        String finalXpath = String.format(updateWorkoutOption, date);
        driver.findElement(By.xpath(finalXpath)).click();
        return new UpdateWorkoutPage(driver);
    }

    public CalendarPage acceptFalseAlert() {
        removeTimeout();
        setExplicitlyWait(falseAlert);
        falseAlert.click();
        setTimeout();
        return this;
    }

    public String getCurrentMonthFromAppCalendar() {
        return currentMonthMenuHeader.getText().toUpperCase(Locale.ROOT);
    }

    public String getCurrentMonthAndYear() {
        LocalDate currentDate = LocalDate.now();
        String currentMonth = String.valueOf(currentDate.getMonth());
        String currentYear = String.valueOf(currentDate.getYear());
        return currentMonth.concat(" ").concat(currentYear);
    }

    public CalendarPage refreshPage() {
        driver.navigate().refresh();
        return new CalendarPage(driver);
    }


}
