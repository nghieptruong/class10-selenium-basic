package radiodemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestRadioUI {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Disable password save dialog
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");
        Thread.sleep(5000);

        //Approach 1 (cách tiep can 1): bắt element cho từng radio button
        //Chon bmw radio
//        By byRadBmw = By.id("bmwradio");
//        selectRadioButton(driver, byRadBmw);

        //chon Benz radio
//        By byRadBenz = By.id("benzradio");
//        selectRadioButton(driver, byRadBenz);

        //Approach 2 (cách tiep can 2): bắt động theo text
        selectRadioButtonByText(driver, "BMW");
        selectRadioButtonByText(driver, "Benz");
    }
    public static void selectRadioButton(WebDriver driver, By locator) {
        WebElement elementRadio = driver.findElement(locator);
        elementRadio.click();
    }

    public static void selectRadioButtonByText(WebDriver driver, String text) {
//        String locatorString = "//input[@type='radio' and normalize-space(following-sibling::text())='%s']"
        String locatorString = "//label[./child::text()=' %s ']/input[@type='radio']"; // xpath động (dynamic xpath)
        String selectedRadLocator = String.format(locatorString, text);
        By byRadElement = By.xpath(selectedRadLocator);
        WebElement elementRadio = driver.findElement(byRadElement);
        elementRadio.click();
    }

    public static void selectRadioButtonByValue(WebDriver driver, String value) {
        String valueLowercase = value.toLowerCase(); //chuyen doi sang lowercase
        String locatorString = "//input[@type='radio' and @value='%s']"; // xpath động (dynamic xpath)
        String selectedRadLocator = String.format(locatorString, valueLowercase);
        By byRadElement = By.xpath(selectedRadLocator);
        WebElement elementRadio = driver.findElement(byRadElement);
        elementRadio.click();
    }
}
