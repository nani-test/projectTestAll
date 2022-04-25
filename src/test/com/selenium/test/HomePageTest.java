package selenium.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.model.testConfig.utils.ListenersSelenium;
import selenium.model.testConfig.TestBase;
import utilsCommun.DataLoadPro;

@Listeners(ListenersSelenium.class)
public class HomePageTest extends TestBase {
    Logger logger = LogManager.getLogger(HomePageTest.class);
    HomePage homePage;
    DataLoadPro dataLoadPro= new DataLoadPro();

    @Test (enabled = true)
    public void verifyLogoIsPresent()
    {
        homePage= new HomePage(driver);
       Assert.assertTrue(homePage.verifyLogoUpgradeIsPresent());
    }

    @Test  (enabled = false, dataProvider = "getDataProduct")
    public void verifyLogoChildPageB() throws InterruptedException {
        homePage= new HomePage(driver);
        String valueCompare= homePage.verifyLogoPageChildIsPresent();
        logger.info("Verifying the correct message is displayed in page selected");
        System.out.println("valueCompare = " + valueCompare);
        Assert.assertEquals(valueCompare,dataLoadPro.getDriverPath("verifyTextPageChild1"));
    }

    @Test  (enabled = false)
    public void verifyLogoChildPageTrust() throws InterruptedException {
        homePage= new HomePage(driver);
        logger.info("Verifying the correct message is displayed in page selected");
        Assert.assertEquals(homePage.verifyLogoPageChildIsPresentTrust(),dataLoadPro.getDriverPath("verifyTextPageChild2"));
    }

    @Test (groups = {"SignIn"},enabled = false)
    public void verifySignInOptionIsPresent() throws Exception {
        homePage= new HomePage(driver);
        logger.info("Click on Sign in button");
        homePage.clickOnSignInButton();
        logger.info("Obtaining the header message");
        String headerSign= homePage.verifySignPageIsDisplayed();
        logger.info("Verifying the correct message text is displayed");
        Assert.assertEquals(headerSign,dataLoadPro.getDriverPath("verifyTextHeaderSignInPage"));
    }
}
