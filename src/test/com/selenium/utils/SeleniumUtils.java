package selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {


    public static void scrollToTheElement(WebDriver driver, WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void selectByVisibleText(WebDriver driver, WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public static void fiveSeconds() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void clickOnElement(WebDriver driver,WebElement element) throws Exception {
        fiveSeconds();
        SeleniumUtils.scrollToTheElement(driver,element);
        WebDriverWait webDriverWait= new WebDriverWait(driver,80);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public static void openChildPage(WebElement element, WebDriver driver)
    {
        element.click();
        String page1= driver.getWindowHandle();
        Set<String> childPage= driver.getWindowHandles();
        for (String childW : childPage) {
            if (!page1.equalsIgnoreCase(childW)) {
                driver.switchTo().window(childW);
                driver.close();
            }
        }
    }

    public static String elementPresentChildPage( WebElement parent,WebDriver driver,
                                                WebElement childElement)
    {
            String childText = null;
            parent.click();
            String page1= driver.getWindowHandle();
            Set<String> childPage= driver.getWindowHandles();
            Iterator<String> iterator = childPage.iterator();
            while(iterator.hasNext())
            {
                String child= iterator.next();
                if(!page1.equalsIgnoreCase(child))
                {
                    driver.switchTo().window(child);
                    childText= childElement.getText();
                }
            }
        return childText;
    }

    public static void waitImplicitSec(WebDriver driver,int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
