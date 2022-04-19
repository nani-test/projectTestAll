package selenium.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.utils.TestBase;

public class HomePageTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    HomePage homePage;

    @Test (enabled = false)
    public void verifyLogoIsPresent()
    {
        homePage= new HomePage(getDriver());
       Assert.assertTrue(homePage.verifyLogoUpgradeIsPresent());
    }

    @Test (enabled = false)
    public void verifyLogoChildPageB() throws InterruptedException {
        homePage= new HomePage(getDriver());
        String valueCompare= homePage.verifyLogoPageChildIsPresent();
        logger.info("Verifying the correct message is displayed in page selected");
        System.out.println("valueCompare = " + valueCompare);
        Assert.assertEquals(valueCompare,"Upgrade, Inc.");
    }

    @Test (enabled = false)
    public void verifyLogoChildPageTrust() throws InterruptedException {
        homePage= new HomePage(getDriver());
        logger.info("Verifying the correct message is displayed in page selected");
        Assert.assertEquals(homePage.verifyLogoPageChildIsPresentTrust(),"upgrade.com");
    }

    @Test (enabled = true)
    public void verifySignInOptionIsPresent() throws Exception {
        homePage= new HomePage(getDriver());
        logger.info("Click on Sign in button");
        homePage.clickOnSignInButton();
        logger.info("Obtaining the header message");
        String headerSign= homePage.verifySignPageIsDisplayed();
        logger.info("Verifying the correct message text is displayed");
        Assert.assertEquals(headerSign,"Welcome Back!");
    }
}
