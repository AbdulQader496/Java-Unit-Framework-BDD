package utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    private final String PATH_OF_THE_PROJECT = System.getProperty("user.dir");
    public final String RESOURCE_FILE_PATH = PATH_OF_THE_PROJECT + "\\src\\test\\resources\\";
    private final String ENV_FILE_PATH = RESOURCE_FILE_PATH + "env.json";
    private final String PROD_ENV_FILE_PATH = RESOURCE_FILE_PATH + "prodenv.json";
    private final String EXPECTED_LOCATION_FILE_PATH = RESOURCE_FILE_PATH + "expectedLocationData.json";
    private final String EXPECTED_OPTION_FILE_PATH = RESOURCE_FILE_PATH + "expectedOption.json";
    private final String ERROR_MSG = "File with environment settings not found or incorrect";
    private Gson gson = new Gson();


    private Env getEnvironment() {
        try {
            return gson.fromJson(new FileReader(ENV_FILE_PATH), Env.class);
        }
        catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public EnvData getEnvData() {
        try {
            if (getEnvironment().getEnv().equals("prod")) {
                return gson.fromJson(new FileReader(PROD_ENV_FILE_PATH), EnvData.class);
            }
            AqualityServices.getLogger().info("Env is not set");
            throw new RuntimeException(ERROR_MSG);
        }
        catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public ExpectedLocationData getExpectedLocationData() {
        try {
            return gson.fromJson(new FileReader(EXPECTED_LOCATION_FILE_PATH), ExpectedLocationData.class);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public ExpectedOptionData getExpectedOptionData() {
        try {
            return gson.fromJson(new FileReader(EXPECTED_OPTION_FILE_PATH), ExpectedOptionData.class);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }
}
