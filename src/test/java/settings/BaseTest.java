package settings;

import settings.DriverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

abstract public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void suitSetup() throws MalformedURLException {
        this.driver = new DriverSetup("Chrome", false, true).getDriver();
        this.driver.get("https://store.steampowered.com/");
    }

    @AfterSuite
    public void suitTearDown(){
        this.driver.close();
        this.driver.quit();
    }

}
