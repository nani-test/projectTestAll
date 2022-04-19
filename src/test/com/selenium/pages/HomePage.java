package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.SeleniumUtils;

public class HomePage {

    WebDriver driver;

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
        WebDriverWait webDriverWait= new WebDriverWait(driver,80);
       return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sc-eCApnc fgdplG']")))
                .isDisplayed();
    }

    public String verifyLogoPageChildIsPresent() throws InterruptedException {
        SeleniumUtils.scrollToTheElement(driver,logoFooterPage2);
        return SeleniumUtils.elementPresentChildPage(logoFooterPage1,driver,logoChildPage1);
    }

    public String verifyLogoPageChildIsPresentTrust()
    {
        SeleniumUtils.scrollToTheElement(driver,logoFooterPage2);
        return SeleniumUtils.elementPresentChildPage(logoFooterPage3,driver,logoChildPage2);
    }

    public void clickOnSignInButton() throws Exception {
        SeleniumUtils.clickOnElement(driver,signInButton);
    }

    public String verifySignPageIsDisplayed() throws InterruptedException {
        SeleniumUtils.fiveSeconds();
        String loginHeader = null;
        if(signInPage.isDisplayed())
        {
            loginHeader= signInPage.getText();
        }
        return loginHeader;
    }


}
