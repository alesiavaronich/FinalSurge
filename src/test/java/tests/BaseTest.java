package tests;

import drivermanager.DriverFactory;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListenersWithAllureService;

@Log4j
@Listeners(TestListenersWithAllureService.class)
public class BaseTest {

    public WebDriver driver;
    public DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        log.info("An object of DriverFactory was created");
        driverManager = driverFactory.getManager(DriverType.CHROME);
        log.info("DriverFactory fetched Chrome driver type");
        driverManager.createDriver();
        log.info("A new driver instance was created");
        driverManager.setTimeout();
        log.info("A timeout was set up");
        driverManager.startMaximize();
        log.info("Browser window was maximized");
        driver = driverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
        log.info("Browser was closed");
    }
}
