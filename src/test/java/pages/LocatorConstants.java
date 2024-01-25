package pages;

import org.openqa.selenium.By;

public class LocatorConstants {
    public static final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
    public static final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
    public static final String PARTICULAR_CLASS_XPATH = "//*[contains(@class,'%s')]";
    public static final String LOCATION_FROM_SEARCH_RESULT = "//*[@class='location-name' and text()='%s']";
}
