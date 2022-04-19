package selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilsCommun.DataLoadPro;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    DataLoadPro dataLoadPro= new DataLoadPro();

    @BeforeTest
    public void beforeExecution()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(dataLoadPro.getDriverPath("url"));

    }

    @AfterTest
    public void afterExecution()
    {
        driver.quit();
    }
}
