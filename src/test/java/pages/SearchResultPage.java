package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class SearchResultPage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
//    private final By LOCATION_FROM_SEARCH_RESULT = By.xpath("//*[contains(@class,'location-name')]");
    private final By LOCATION_FROM_SEARCH_RESULT_LIST = By.xpath("//*[contains(@class,'locations-list')]");
    private final By LOCATION_FROM_SEARCH_RESULT_LONDON = By.xpath("//*[@class='location-name' and text()='London']");
//    private final ILabel locationText = elementFactory.getLabel(LOCATION_FROM_SEARCH_RESULT, "Choosing new work from list");
    private final IElement searchResult = elementFactory.getLabel(LOCATION_FROM_SEARCH_RESULT_LIST, "search result page");
    private final ILabel locationTextLondon = elementFactory.getLabel(LOCATION_FROM_SEARCH_RESULT_LONDON, "Choosing london from list");
    private final String IFRAME_ID = "google_ads_iframe_/6581/web/asi/interstitial/admin/search_0";
    //*[@id='google_ads_iframe_/6581/web/asi/interstitial/admin/search_0']
    //*[@id="google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0"]
    private final By POPUP_DISMISS = By.xpath("//*[@id='dismiss-button']");
    private final IButton dismissBtn = elementFactory.getButton(POPUP_DISMISS, "Dismiss popup button");


    public SearchResultPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "Find Your Location's Weather Forecast | AccuWeather")), "Search Result Page");
    }

    public void clickLocation(String city) {
        By LOCATION_FROM_SEARCH_RESULT = By.xpath(String.format(LocatorConstants.LOCATION_FROM_SEARCH_RESULT, city));
        ILabel locationText = elementFactory.getLabel(LOCATION_FROM_SEARCH_RESULT, "Choosing city from list");
        locationText.click();
    }

    public boolean isSearchPageDisplayed() {
        return searchResult.state().isDisplayed();
    }



    public void clickLocationLondon() {
        locationTextLondon.state().waitForClickable(Duration.ofSeconds(10));
        locationTextLondon.click();
    }


    public void clickPopupDismissBtn() {
        getBrowser().getDriver().switchTo().frame(IFRAME_ID);
        dismissBtn.click();
        getBrowser().getDriver().switchTo().defaultContent();
    }

}
