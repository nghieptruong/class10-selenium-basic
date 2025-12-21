package handlewindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HandleWindowsDemo {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //luu lai ID cua main windows (parent window)
        String idMainWindow = driver.getWindowHandle();
        System.out.println("ID main window = " + idMainWindow);

        By byBtnOpenWindow = By.id("openwindow");
        WebElement btnOpenWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnOpenWindow));
        btnOpenWindow.click();

        //sau khi New windows pops up
        //Get all windows ID
        Set<String> allWindowsIds = driver.getWindowHandles();
        System.out.println("All Windows ID: " + allWindowsIds);

        //Lặp cái Set
        //High level action:
        //          switchToWindows(String id)
        //          switchToWindows(String expectedTitle)
        //          switchToNewWindow()
        for(String id : allWindowsIds) {
            if(!id.equals(idMainWindow)) {
                driver.switchTo().window(id);
                //compare title
                break;
            }
        }

        //search box đang ở trên windows mới
        By byTxtSearchbox = By.xpath("//input[@id='search']");
        WebElement txtSearchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtSearchbox));
        txtSearchbox.sendKeys("Java Course");

        Thread.sleep(3000);

        driver.quit();
    }
}
