package tests;

import drivermanager.DriverFactory;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListenersWithAllureService;

@Log4j
@Listeners(TestListenersWithAllureService.class)
public class BaseTest {

    public WebDriver driver;
    public DriverManager driverManager;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;
        } else if (browser.equals("edge")) {
            type = DriverType.EDGE;
        } else if (browser.equals("remote")) {
            type = DriverType.REMOTE;
        }

        log.info("An object of DriverFactory was created");
        driverManager = driverFactory.getManager(type);
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
