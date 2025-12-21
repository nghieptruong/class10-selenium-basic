package selectuidemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class TestSelectUIDemo {
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

        By bySelCar = By.id("carselect");
        selectDropdownByText(driver, bySelCar, "Benz");
    }
    public static void selectDropdownByText(WebDriver driver, By locator, String text) {
        WebElement elementSelectCar = driver.findElement(locator);
        Select selCar = new Select(elementSelectCar);
        selCar.selectByVisibleText(text);
    }
    public static void selectDropdownByValue(WebDriver driver, By locator, String value) {

    }
    public static void selectDropdownByIndex(WebDriver driver, By locator, int index) {

    }
}
