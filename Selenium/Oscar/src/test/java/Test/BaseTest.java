package Test;

import Pages.PageFactory;
import ReadExcelData.ExcelDataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    static WebDriver driver;
    protected PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName) throws MalformedURLException {

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            pageFactory=new PageFactory(driver);
        }
    }

    public static WebDriver getDrivers() {
        return driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "WebsiteLoginData")
    public String[][] passData() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestData.xls");
        int rows = config.getRowCount(0);
        int cols = config.getCellCount(0,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(0, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "ApplicantDetails")
    public String[][] passDataForUers() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestData.xls");
        int rows = config.getRowCount(1);
        int cols = config.getCellCount(1,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(1, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "HELFunnelDetails")
    public String[][] passDataForHELFunnel() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//TestData.xls");
        int rows = config.getRowCount(2);
        int cols = config.getCellCount(2,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(2, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "HElFunnelsForm")
    public String[][] passDataForHELFunnelForm() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//FunnelsTestData.xls");
        int rows = config.getRowCount(0);
        int cols = config.getCellCount(0,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(0, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "HElFunnelsFormForGnowise")
    public String[][] passDataForHELFunnelFormGnowise() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//FunnelsTestData.xls");
        int rows = config.getRowCount(1);
        int cols = config.getCellCount(1,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(1, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "RefinanceFunnelsFormForGnowise")
    public String[][] passDataForRefinanceFunnelForm() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//FunnelsTestData.xls");
        int rows = config.getRowCount(2);
        int cols = config.getCellCount(2,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(2, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "RenewFunnelsFormForGnowise")
    public String[][] passDataForRenewFunnelForm() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"//TestData//FunnelsTestData.xls");
        int rows = config.getRowCount(3);
        int cols = config.getCellCount(3,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(3, i, j);
            }
        }
        return data;
    }

    @DataProvider(name = "PurchaseFunnelsFormForGnowise")
    public String[][] passDataForPurchaseFunnelForm() throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig config = new ExcelDataConfig(excelSheetPath+"\\oscar-selenium-automation\\Selenium\\Oscar\\TestData\\FunnelsTestData.xls");
        int rows = config.getRowCount(4);
        int cols = config.getCellCount(4,1);
        String[][] data = new String[rows][cols];
        for(int i=1;i<=rows;i++){
            for(int j=0; j<cols; j++) {
                data[i-1][j] = config.getData(4, i, j);
            }
        }
        return data;
    }
}