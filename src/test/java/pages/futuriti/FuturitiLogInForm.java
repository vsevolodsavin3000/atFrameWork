package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Login page")
public class FuturitiLogInForm {

    @ElementName(name = "Login form")
    @FindBy(xpath = "//div[@class='form auth-forms login-form']")
    private WebElement loginForm;

    @ElementName(name = "login")
    @FindBy(xpath = "//input[@name='login']")
    private WebElement login;

    @ElementName(name = "password")
    @FindBy(xpath = "//div[@class='form auth-forms login-form']//input[@name='password']")
    private WebElement password;

    @ElementName(name = "forgot password")
    @FindBy(xpath = "//div[@class='form__forgot-link']/a")
    private WebElement forgotPassword;

    @ElementName(name = "login button")
    @FindBy(xpath = "//form[@name='login-form']//button[@type='submit']")
    private WebElement loginButton;

    @ElementName(name = "close button")
    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeButton;

    @ElementName(name = "not correct input message for login")
    @FindBy(xpath = "//div[@class='form__top-error']")
    private WebElement notCorrectInputMessageForLogin;

    @ElementName(name = "not correct input message for password")
    @FindBy(xpath = "//input[@name='password']/following-sibling::div[@class[contains(.,'form__error')]]")
    private WebElement notCorrectInputMessageForPassword;

}
