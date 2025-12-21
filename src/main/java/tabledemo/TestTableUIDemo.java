package tabledemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTableUIDemo {
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

        String locatorTable = "//table/tbody";
        String value = getTableCellValue(driver, locatorTable, 2,2);
        System.out.println(value); // Selenium WebDriver With Java

        getTableCellValue(driver, locatorTable, "Course", 2);

        getColumnHeaderName(driver, locatorTable, 1);

    }
    public static String getTableCellValue(WebDriver driver, String locatorTable, int row, int col) {
        String locatorCell = "/tr[%d]/td[%d]";
        String fullLocatorCell = locatorTable + locatorCell;
        String cellWithColRow = String.format(fullLocatorCell, row, col);
        By byCell = By.xpath(cellWithColRow);
        WebElement cellElement = driver.findElement(byCell);
        return cellElement.getText();
    }

    public static String getTableCellValue(WebDriver driver, String locatorTable, String columnName, int col) {

        return "";
    }

    public static String getColumnHeaderName(WebDriver driver, String locatorTable, int colIndex) {

        return "";
    }

    public static List<String> getAllColumnHeaderNames(WebDriver driver, String locatorTable) {

        return null;
    }

    public static int getColumnHeaderIndex(WebDriver driver, String locatorTable, String columnName) {

        return 0;
    }
}
