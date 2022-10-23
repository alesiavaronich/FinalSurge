package pagesAndComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Locale;

public class CalendarPage extends BasePage{


    private String dateOfActivity = "//div[@data-date='%s']";

    @FindBy(xpath = "//ul[@role='menu']/li/a[@class='quick-delete']")
    private WebElement quickDeleteOption;

    @FindBy(xpath = "//ul[@role='menu']/li/a[@class='full-edit']")
    private WebElement updateWorkoutOption;

    @FindBy(xpath = "//div[@class='bootbox modal fade in']//div[@class='modal-footer']/a[text()='OK']")
    private WebElement falseAlert;

    @FindBy(xpath = "//div[@class='fc-header-center']//a[@id='dpMonth']")
    private WebElement currentMonthMenuHeader;


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPage selectActivity(String date) {
        String finalXpath = String.format(dateOfActivity, date);
        driver.findElement(By.xpath(finalXpath)).click();
        return this;
    }

    public void setExplicitlyWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public CalendarPage selectQuickDeleteOption() {
        quickDeleteOption.click();
        return this;
    }

    public UpdateWorkoutPage selectUpdateWorkoutOption() {
        updateWorkoutOption.click();
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




}
