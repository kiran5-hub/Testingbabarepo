package baseLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtility.ApplicationUtility;
import excelUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import propertyUtility.PropertyUtlity;
import waitUtility.WaitUtility;

public class Library_For_Alert_Windows_Frames implements ExcelUtility, PropertyUtlity, ApplicationUtility, WaitUtility {
    public static WebDriver driver;

    public void launchUrl(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearResolutionCache().setup();  // Clear cache and automatically download the correct ChromeDriver
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup(); // Automatically download and set up GeckoDriver
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup(); // Automatically download and set up EdgeDriver
            driver = new EdgeDriver();
        }

        driver.get("https://testingbaba.com/old/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Implicit wait for web page launch
        driver.manage().window().maximize();

        WebElement close = driver.findElement(By.xpath("//button[text()='×']"));
        waitforClick(close);
        driver.findElement(By.xpath("//a[text()='Practice']")).click();
    }

    @Override
    public String getReadData(int sheetNo, int colNo, int rowNo) {
        String val = "";
        String path = "C:\\Users\\laxmi\\eclipse-workspace\\SeleniumFramework_Project\\TEstData\\excel.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);    // This opens the Excel file (testdata.xlsx) for reading
            XSSFWorkbook wb = new XSSFWorkbook(fis);            // It reads the .xlsx file that was opened by the FileInputStream (fis).
            XSSFSheet sheet = wb.getSheetAt(sheetNo);           // This line gets a specific sheet from the workbook.
            val = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();    // This retrieves the specific cell value from the sheet.
        } catch (Exception e) {
            System.out.println("Issue in get read data from excel file " + e);
        }
        return val;  // It returns the value val, which holds the data from the specific cell in the Excel file.
    }

    @Override
    public String getReadData(String key) {
        String value = "";
        String path = "C:\\Users\\laxmi\\eclipse-workspace\\SeleniumFramework_Project\\TEstData\\config.properties";

        try {
            FileInputStream fis = new FileInputStream(path);    // This opens the property file (config.properties) for reading
            Properties prop = new Properties();            // It reads the .properties file that was opened by the FileInputStream (fis).
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Issue in get read data from property file " + e);
        }
        return value;
    }

    @Override
    public void doubleClickOnElement(WebElement ele) {
        Actions act = new Actions(driver);
        act.doubleClick(ele).perform();
    }

    @Override
    public void rightClickOnElement(WebElement ele) {
        Actions act = new Actions(driver);
        act.contextClick(ele).perform();
    }

    @Override
    public void clickOnElement(WebElement ele) {
        Actions act = new Actions(driver);
        act.click(ele).perform();
    }

    @Override
    public void changeWindow(int tabno) {
        Set<String> windowhandles = driver.getWindowHandles();  // Get a Set of window handles.
        List<String> handles = new ArrayList<>(windowhandles);  // Convert Set to List.
        driver.switchTo().window(handles.get(tabno));  // Switch to the window/tab based on the given index.
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void fileuploading(String Filepath) {
        try {
            StringSelection sel = new StringSelection(Filepath);
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            clip.setContents(sel, null);

            Robot rob = new Robot();
            rob.delay(500);
            rob.keyPress(KeyEvent.VK_ENTER);
            rob.keyRelease(KeyEvent.VK_ENTER);

            rob.keyPress(KeyEvent.VK_CONTROL);
            rob.keyPress(KeyEvent.VK_V);
            rob.keyRelease(KeyEvent.VK_V);
            rob.keyRelease(KeyEvent.VK_CONTROL);

            rob.keyPress(KeyEvent.VK_ENTER);
            rob.delay(250);
            rob.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Issue in uploading file " + e);
        }
    }

    @Override
    public boolean isEnabled_Disabled(WebElement ele) {
        return ele.isEnabled();
    }

    @Override
    public void waitforClick(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated to use Duration
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    }

    @Override
    public void waitforVisibility(WebElement ele, String val) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated to use Duration
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(val);
    }

    @Override
    public void waitforAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated to use Duration
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Override
    public void selectbyText(WebElement ele, String text) {
        Select sel = new Select(ele);
        sel.selectByVisibleText(text);

        List<WebElement> selectvalue = sel.getOptions();
        int numberofOptions = selectvalue.size();
        System.out.println("\nThe selected option from the dropdown is " + numberofOptions);

        WebElement selectedOption = sel.getFirstSelectedOption();
        System.out.println("\nThe selected option from the dropdown is " + selectedOption);

        System.out.println("\nAll the elements from the dropdown are");
        for (WebElement option : selectvalue) {
            System.out.println(option.getText());
        }
    }

    @Override
    public void selectbyIndex(WebElement ele, int index) {
        Select sel = new Select(ele);
        sel.selectByIndex(index);
        WebElement selectedOption = sel.getFirstSelectedOption();
        System.out.println("The selected option from the dropdown is: " + selectedOption.getText());
    }

    @Override
    public void selectbyValue(WebElement ele, String value) {
        Select sel = new Select(ele);
        sel.selectByValue(value);
        WebElement selectedOption = sel.getFirstSelectedOption();
        System.out.println("The selected option from the dropdown is: " + selectedOption.getText());
    }

    @Override
    public void selectallbyTextUsingLoop(WebElement ele, String text) {
        Select sel = new Select(ele);
        sel.selectByVisibleText(text);

        List<WebElement> selectvalue = sel.getOptions();

        WebElement selectedOption = sel.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
    }

    @Override
    public void mouseHover(WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();

        String selectedOptionText = ele.getText();
        System.out.println("You have selected: " + selectedOptionText);
    }

    @Override
    public void mouseHoverfortooltip(WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
        String value = ele.getAttribute("title");
        System.out.println("The tooltip message for \"hover me to see\" is ---" + value);
    }

    @Override
    public String getDate_Time() {
        String value = "";
        try {
            Date db = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            value = sf.format(db);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return value;
    }

    @Override
    public int getResponseCodeForRequest(String url) {
        try {
            URL curl = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) curl.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            return huc.getResponseCode();  // Return response code
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    @Override
    public void movetoElement(WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
    }
}
