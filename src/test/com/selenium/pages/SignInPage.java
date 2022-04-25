package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

    WebDriver driver;

    @FindBy(name = "username")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passField;

    @FindBy(xpath = "//button[text()='Sign in to your account']")
    WebElement loginButton;

    @FindBy(id = "password-3-error")
    WebElement invalidPassMess;

    @FindBy(id = "username-2-error")
    WebElement invalidUserMess;

    @FindBy(xpath = "//a[@data-auto='forgotPassword']")
    WebElement forgotPassLink;

    @FindBy(xpath = "//div[@data-auto='loginError']")
    WebElement loginErrorMessage;

    public SignInPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String user)
    {
         userNameField.sendKeys(user);
    }

    public void enterPass(String pas) throws InterruptedException {
       passField.sendKeys(pas);
       fiveSeconds();
    }

    public void clickOnLoginButton() throws Exception {

        clickOnElement(loginButton);
        waitImplicitSec(driver,80);
    }

    public void clickOnForgotPass() throws Exception {
        clickOnElement(forgotPassLink);
    }
     public String messageValidationUser() throws InterruptedException {

         moveToElement(invalidUserMess);
         return invalidUserMess.getText();
     }

    public String messageValidationPas()
    {
        return invalidPassMess.getText();
    }

    public String messageValidationPasAndUser()
    {
        return loginErrorMessage.getText();
    }
}
