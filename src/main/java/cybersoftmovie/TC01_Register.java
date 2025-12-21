package cybersoftmovie;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TC01_Register {
    public static void main(String[] args) throws InterruptedException {

        UUID uuid = UUID.randomUUID();

        String account = uuid.toString(); // unique
        String email = account + "@example.com"; // unique
        System.out.println(account);
        System.out.println(email);

        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            //disable automation bar
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            // Disable password save dialog
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            //Step 1: Go to https://demo1.cybersoft.edu.vn/
            driver.get("https://demo1.cybersoft.edu.vn/");

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            wait.withTimeout(Duration.ofSeconds(60));
//            wait.pollingEvery(Duration.ofSeconds(1));
//            wait.ignoring(NotFoundException.class);

            // viet kieu . la chaining
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NotFoundException.class);

            //Step 2: Click 'Đăng Ký' link on the top right
            By byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
            WebElement lnkRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkRegister));
            lnkRegister.click();

            //Step 3: Enter account name
            By byTxtAccount = By.id("taiKhoan");
            WebElement txtAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccount));
            txtAccount.sendKeys(account);

            //Step 4: Enter password
            By byTxtPassword = By.id("matKhau");
            WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
            txtPassword.sendKeys("Test123456@");

            //Step 5: Enter confirm password
            By byTxtConfirmPassword = By.id("confirmPassWord");
            WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
            txtConfirmPassword.sendKeys("Test123456@");

            //Step 6: Enter full name
            By byTxtFullName = By.id("hoTen");
            WebElement txtFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullName));
            txtFullName.sendKeys("John Johnson");

            //Step 7: Enter email
            By byTxtEmail = By.id("email");
            WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
            txtEmail.sendKeys(email);

            //Step 8: Click 'Đăng Ky' button
            By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
            WebElement btnRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRegister));

            btnRegister.click();

            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
