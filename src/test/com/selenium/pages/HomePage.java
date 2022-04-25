package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  extends BasePage{


    @FindBy(xpath = "//div[@class='sc-eCApnc fgdplG']")
    WebElement logoUpgrade;

    @FindBy (xpath = "//a[@class='footer-badges__item']")
    WebElement logoFooterPage1;

    @FindBy (xpath = "//span[@class='footer-badges__item img-equal-housing']")
    WebElement logoFooterPage2;

    @FindBy (xpath = "//a[contains(@title,'View TrustedSite Certification')]")
    WebElement logoFooterPage3;

    @FindBy (xpath = "//span[@class='MuiTypography-root MuiTypography-h3']")
    WebElement logoChildPage1;

    @FindBy (xpath = "//h1[text()='upgrade.com']")
    WebElement logoChildPage2;

    @FindBy (xpath = "//li[@class='header-nav-links__item']//child::a[@class='header-nav-menu__btn']")
    WebElement signInButton;

    @FindBy (xpath = "//h2[text()='Welcome Back!']")
    WebElement signInPage;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean verifyLogoUpgradeIsPresent()
    {
        WebElement logoTest = null;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
             logoTest= webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sc-eC fgdplG']")));
        }
        catch (Exception e)
        {
            e.getMessage();
            return false;
        }
        return logoTest.isDisplayed();
    }

    public String verifyLogoPageChildIsPresent() throws InterruptedException {
        scrollToTheElement(logoFooterPage1);
        return elementPresentChildPage(logoFooterPage1,logoChildPage1);
    }

    public String verifyLogoPageChildIsPresentTrust()
    {
        scrollToTheElement(logoFooterPage2);
        return elementPresentChildPage(logoFooterPage3,logoChildPage2);
    }

    public void clickOnSignInButton() throws Exception {
        clickOnElement(signInButton);
    }

    public String verifySignPageIsDisplayed() throws InterruptedException {
        fiveSeconds();
        String loginHeader = null;
        if(signInPage.isDisplayed())
        {
            loginHeader= signInPage.getText();
        }
        return loginHeader;
    }


}
