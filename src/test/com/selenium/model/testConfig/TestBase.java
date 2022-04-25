package selenium.model.testConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import utilsCommun.DataLoadPro;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    DataLoadPro dataLoadPro= new DataLoadPro();

    @BeforeMethod
    public void beforeExecution()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(dataLoadPro.getDriverPath("url"));

    }

    @BeforeGroups ("SignIn")
    public void beforeExecutionGroups()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(dataLoadPro.getDriverPath("url"));

    }
    @AfterGroups ("SignIn")
    public void afterExecutionG()  {
        driver.quit();
    }

    @AfterMethod
    public void afterExecution()  {
        driver.quit();
    }
}
