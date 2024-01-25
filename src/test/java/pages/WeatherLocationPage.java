package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WeatherLocationPage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final By LOCATION_FROM_PAGE_HEADER = By.xpath("//*[@class='header-loc']");
    private final ILabel locFromPageHeader = elementFactory.getLabel(LOCATION_FROM_PAGE_HEADER, "name of the location");


    public WeatherLocationPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "New York, NY Weather Forecast | AccuWeather")), "New York weather Page");
    }

    public String actualLocation() {
        return locFromPageHeader.getText();
    }

    public void toMainPage() {
        By MAIN_PAGE_LOCATOR = By.xpath(String.format(LocatorConstants.PARTICULAR_CLASS_XPATH, "header-logo"));
        ILabel toMainPage = elementFactory.getLabel(MAIN_PAGE_LOCATOR, "Choosing city from list");
        locFromPageHeader.getText();
        toMainPage.click();
    }
}
