package implicitwaitdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class TestImplicitWaitDemo {
    public static void main(String[] args) {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // apply cho findElement và findElements

        driver.get("https://www.letskodeit.com/practice");

        By byRadBmw = By.id("bmwradio123");
        ZonedDateTime startTime = ZonedDateTime.now();

        try {
            WebElement element = driver.findElement(byRadBmw); // faied -> throw exception
        } catch (Exception e) {
            throw e;
        } finally {
            ZonedDateTime endTime = ZonedDateTime.now();
            long duration = ChronoUnit.SECONDS.between(startTime, endTime);
            System.out.println("Duration: " + duration); // 10s --> ko tim dc throw NoSuchElementException exception
        }


    }
}
