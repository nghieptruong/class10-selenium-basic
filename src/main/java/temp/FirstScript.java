package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
        //khởi tạo ra đối tượng webdrive -> điều khiển để tương tác tới trang web
        //đối với selenium sẽ hỗ trợ 4 trình duyệt khác nhau: chrome, edge, firefox & safari
        // chromedriver = đối tượng điều khiển chrome

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

            options.setBrowserVersion("138");


            driver = new ChromeDriver(options);

            //mở full màn hình
            driver.manage().window().maximize();

            //driver.get -> dùng để truy cập vào trang web
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            Thread.sleep(3000); //cải tiến = wait

            //thẻ html trong devtool (f12 || fn + f12)
            ////*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input -> bắt xpath tuyệt đối
            //xpath tương đối
            //id, name, placeholder - tìm tới vị trí có giá trị thuộc tính tương ứng trong class

            By byTxtUsername = By.name("username");
            //tìm tới element đó thông qua webelement = gía trị
            WebElement txtUsername = driver.findElement(byTxtUsername);
//        WebElement txt1 = driver.findElement(By.name("username"));
            txtUsername.sendKeys("Admin");

            //bt nhỏ: tìm element password trên trang web và nhập admin123
            WebElement txtPassword = driver.findElement(By.name("password"));
            txtPassword.sendKeys("admin123");

            //btnlogin -> công thức xpath: //tagName[@attribute="value"]
            //                              -> tagName: tên thẻ html (ví dụ: h1, h2,.. input, button,....)
            //                              -> attribute: thuộc tính của thẻ: id, name, placeholder, type, class
            WebElement btnLogin = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            btnLogin.click();

            Thread.sleep(3000);

            //đi vô pim -> nhập name  -> ấn search
            //tag[text()=""] -> tìm tới text thật của the html
            WebElement lnkPIM = driver.findElement(By.xpath("//span[text()=\"PIM\"]"));
//        By.xpath("//span[normalize-space()='PIM']");
//        -> xóa khoảng trắng đầu cuối, gộp nhiều khoảng trắng với nhau thành 1 spacing duy nhất
            lnkPIM.click();
            // ->//button[contains(text(), 'Submit')] -> bao gồm giá trị bên trong text

            Thread.sleep(2000);

            WebElement txtEmployeeName = driver.findElement(By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]"));
            txtEmployeeName.sendKeys("Thành");

            WebElement btnSearch = driver.findElement(By.xpath("//button[@type='submit']"));
            btnSearch.click();

            Thread.sleep(15000);
        } catch (Exception e) {
            //capture screenshot luc failed
            //log loi failed
            //clean up
        } finally {
            driver.quit(); // quit driver session chromedrive.exe
        }

    }
}
