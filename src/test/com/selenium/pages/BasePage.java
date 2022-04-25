package selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void scrollToTheElement(WebElement element){
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectByVisibleText(WebDriver driver, WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void fiveSeconds() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void clickOnElement(WebElement element) throws Exception {
        fiveSeconds();
        scrollToTheElement(element);
        WebDriverWait webDriverWait= new WebDriverWait(driver,80);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public  void openChildPage(WebElement element, WebDriver driver)
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

    public  String elementPresentChildPage( WebElement parent,
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
        driver.close();
        driver.switchTo().window(page1);
        return childText;
    }

    public  void waitImplicitSec(WebDriver driver,int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void moveToElement(WebElement element)
    {
        Actions actions= new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void takeSnapShot(String path)
    {

    }


}
