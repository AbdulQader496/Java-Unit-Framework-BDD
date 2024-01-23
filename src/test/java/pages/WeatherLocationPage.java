package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WeatherLocationPage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final By LOCATION_FROM_PAGE_HEADER = By.xpath("//*[@class='header-loc' and contains(text(),'New York')]");
    private final By LOCATION_FROM_PAGE_HEADER_RECENT = By.xpath("//*[@class='header-loc' and contains(text(),'London')]");
    private final ILabel locFromPageHeader = elementFactory.getLabel(LOCATION_FROM_PAGE_HEADER, "name of the location");
    private final ILabel locFromRecentPageHeader = elementFactory.getLabel(LOCATION_FROM_PAGE_HEADER_RECENT, "name of the location");

    public WeatherLocationPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "New York, NY Weather Forecast | AccuWeather")), "New York weather Page");
    }

    public String actualLocation() {
        return locFromPageHeader.getText();
    }

    public String actualRecentLocation() {
        return locFromRecentPageHeader.getText();
    }
}
