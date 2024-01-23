package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class MainPage extends Form {

    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final By CONSENT_AGREE = By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "I Understand"));
    private final By INPUT_TEXT = By.xpath("//*[@class='search-input']");
    private final By RECENT_LOCATION = By.xpath("//*[@class='recent-location-item featured-location  ']");

    //*[@class='recent-location-item featured-location  ']
    //*[@id="google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0"]
    private final String IFRAME_ID = "google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0";
    private final By POPUP_DISMISS = By.xpath("//*[@id='dismiss-button']");
    private final IButton dismissBtn = elementFactory.getButton(POPUP_DISMISS, "Dismiss popup button");
    private IButton consentBtn = elementFactory.getButton(CONSENT_AGREE, "consent agreed button");
    private ITextBox textField =  elementFactory.getTextBox(INPUT_TEXT, "Input text");
    private ILabel recentLocation =  elementFactory.getLabel(RECENT_LOCATION, "name of recent location");
    private final By CURRENT_LOCATION = By.xpath("//*[text()='Use your current location']");
    private final ILabel currentLocationLbl = elementFactory.getLabel(CURRENT_LOCATION, "use your current location locator");

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "Local, National, & Global Daily Weather Forecast | AccuWeather")), "Main Page");
    }
    public void clickConsentBtn() {
        consentBtn.click();
    }
    public void clickSearchBox() {
        textField.click();
    }
    public void inputText(String city){
        textField.clearAndType(city);
        textField.submit();
    }

    public void recentLocation() {
        recentLocation.state().waitForDisplayed();
        recentLocation.click();
    }


    public String useCurrentLocationOption() {
        currentLocationLbl.state().waitForDisplayed();
        return currentLocationLbl.getText();
    }
    public void clickPopupDismissBtn() {
        getBrowser().getDriver().switchTo().frame(IFRAME_ID);
        dismissBtn.click();
        getBrowser().getDriver().switchTo().defaultContent();
    }
}
