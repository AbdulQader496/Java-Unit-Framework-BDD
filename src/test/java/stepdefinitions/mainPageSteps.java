package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class mainPageSteps {

    private MainPage mainPage = new MainPage();

    @Given("I Consent to data usage")
    public void FinalTask() {
        step("Consent to data usage");
        mainPage.clickConsentBtn();

    }
}
