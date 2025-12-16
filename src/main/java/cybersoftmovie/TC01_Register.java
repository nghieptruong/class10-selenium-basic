package cybersoftmovie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

            Thread.sleep(3000);

            //Step 2: Click 'Đăng Ký' link on the top right
            By byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
            WebElement lnkRegister = driver.findElement(byLnkRegister);
            lnkRegister.click();

            Thread.sleep(3000);

            //Step 3: Enter account name
            By byTxtAccount = By.id("taiKhoan");
            WebElement txtAccount = driver.findElement(byTxtAccount);
            txtAccount.sendKeys(account);

            Thread.sleep(3000);

            //Step 4: Enter password
            By byTxtPassword = By.id("matKhau");
            WebElement txtPassword = driver.findElement(byTxtPassword);
            txtPassword.sendKeys("Test123456@");

            Thread.sleep(3000);

            //Step 5: Enter confirm password
            By byTxtConfirmPassword = By.id("confirmPassWord");
            WebElement txtConfirmPassword = driver.findElement(byTxtConfirmPassword);
            txtConfirmPassword.sendKeys("Test123456@");

            Thread.sleep(3000);

            //Step 6: Enter full name
            By byTxtFullName = By.id("hoTen");
            WebElement txtFullName = driver.findElement(byTxtFullName);
            txtFullName.sendKeys("John Johnson");

            Thread.sleep(3000);

            //Step 7: Enter email
            By byTxtEmail = By.id("email");
            WebElement txtEmail = driver.findElement(byTxtEmail);
            txtEmail.sendKeys(email);

            Thread.sleep(3000);

            //Step 8: Click 'Đăng Ky' button
            By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
            WebElement btnRegister = driver.findElement(byBtnRegister);
            btnRegister.click();

            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
