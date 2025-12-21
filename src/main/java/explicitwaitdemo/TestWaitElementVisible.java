package explicitwaitdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class TestWaitElementVisible {
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

//        set implicit wait = 10s
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ko nen mix giua implicit wait va explicit wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String projectDir = System.getProperty("user.dir");
        driver.get(projectDir + "/src/main/java/webbasic/delayelement/index.html");

        //Enter "Hello Selenium" on username textbox
        By byTxtUserName = By.id("username123");
//        WebElement txtUserName = driver.findElement(byTxtUserName);

        ZonedDateTime startTime = ZonedDateTime.now();

        try {
            WebElement txtUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserName));
            txtUserName.sendKeys("Hello Selenium");
        } catch (Exception e) {
            throw e;
        } finally {
            ZonedDateTime endTime = ZonedDateTime.now();
            long duration = ChronoUnit.SECONDS.between(startTime, endTime);
            System.out.println("Duration: " + duration); // 10s --> ko tim dc element throw TimeOutException exception
            driver.quit();
        }
    }
}
