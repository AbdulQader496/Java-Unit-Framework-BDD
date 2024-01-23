package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SettingsTestData;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class Hooks {

    protected Browser browser = AqualityServices.getBrowser();

    @Before
    public void setup() {
        step("Starting browser");
        browser = AqualityServices.getBrowser();
        browser.maximize();
        step("Navigating to the website");
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void teardown() {
        step("Closing/Ending test");
        browser.quit();
    }
}
