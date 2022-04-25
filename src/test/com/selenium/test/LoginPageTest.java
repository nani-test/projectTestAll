package selenium.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.SignInPage;
import selenium.model.testConfig.TestBase;
import utilsCommun.DataLoadPro;

public class LoginPageTest extends TestBase {
    SignInPage signInPage;
    HomePage homePage;
    Logger logger= LogManager.getLogger(LoginPageTest.class);
    DataLoadPro dataLoadPro= new DataLoadPro();

    @Test (groups = {"SingInEnter"},dependsOnGroups = {"SignIn"},enabled = false)
    public void verifyMessageEmptyEmail() throws Exception {
        signInPage= new SignInPage(driver);
        homePage= new HomePage(driver);
        logger.info("Selecting sign In button");
        homePage.clickOnSignInButton();
        logger.info("Entering only password");
        signInPage.enterPass(dataLoadPro.getDriverPath("password"));
        logger.info("Clicking on login button");
        signInPage.clickOnLoginButton();
        logger.info("Verifying the error message is displayed");
        Assert.assertEquals(signInPage.messageValidationUser(),dataLoadPro.getDriverPath("invalidMessageField"));
    }

    @Test (enabled = false)
    public void verifyMessageEmptyPass() throws Exception {
        signInPage= new SignInPage(driver);
        homePage= new HomePage(driver);
        logger.info("Selecting sign In button");
        homePage.clickOnSignInButton();
        logger.info("Entering only username");
        signInPage.enterEmail(dataLoadPro.getDriverPath("username"));
        logger.info("Clicking on login button");
        signInPage.clickOnLoginButton();
        logger.info("Verifying the error message is displayed");
        Assert.assertEquals(signInPage.messageValidationPas(),dataLoadPro.getDriverPath("invalidMessageField"));
    }

    @Test (enabled = true)
    public void verifyNotRegisterUser() throws Exception {
        signInPage= new SignInPage(driver);
        homePage= new HomePage(driver);
        logger.info("Selecting sign In button");
        homePage.clickOnSignInButton();
        logger.info("Entering username");
        signInPage.enterEmail(dataLoadPro.getDriverPath("username"));
        logger.info("Entering password");
        signInPage.enterPass(dataLoadPro.getDriverPath("password"));
        signInPage.clickOnLoginButton();
        logger.info("Verifying the error message when user is not registered is displayed");
        Assert.assertEquals(signInPage.messageValidationPasAndUser(),dataLoadPro.getDriverPath("invalidUserNotRegistered"));
    }
}
