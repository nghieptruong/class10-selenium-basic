package checkboxdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestCheckbox {
    public static void main(String[] args) throws InterruptedException {
        /*
        Yeu cau: viet 1 function selectCheckbox(boolean status)
           ==> status = true ==> checked
            if(checkbox is selected)
                do nothing
            else
                tick

           ==> status = false ==> unchecked (untick)
           if(checkbox is selected)
                untick
            else
                do nothing
         */

        //Step 1: Go to https://the-internet.herokuapp.com/checkboxes
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

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(5000); // hard wait (wait tĩnh)

        //Step 2: Tick checkbox 1
        By byChkCheckbox1 = By.xpath("//input[@type='checkbox' and normalize-space(following-sibling::text())='checkbox 1']");
        selectCheckbox(driver, byChkCheckbox1, true);
        Thread.sleep(3000);

        //Step 3: Untick checkbox 1
        selectCheckbox(driver, byChkCheckbox1, false);
        Thread.sleep(3000);

        //Step 4: Tick checkbox 2
        By byChkCheckbox2 = By.xpath("//input[@type='checkbox' and normalize-space(following-sibling::text())='checkbox 2']");
        selectCheckbox(driver, byChkCheckbox2, true);
        Thread.sleep(3000);

        //Step 5: Untick checkbox 2
        selectCheckbox(driver, byChkCheckbox2, false);
        Thread.sleep(3000);

        driver.quit();
    }

    /**
     * selectCheckbox: Tick/Untick checkbox based on status
     * @param driver
     * @param locator
     * @param status (true/false)
     *               status = true -> ticked
     *               status = false -> unticked
     */
    public static void selectCheckbox(WebDriver driver, By locator, boolean status) {
        WebElement elementCheckbox = driver.findElement(locator);
        if(elementCheckbox.isSelected() != status) {
            elementCheckbox.click();
        }
    }
}
