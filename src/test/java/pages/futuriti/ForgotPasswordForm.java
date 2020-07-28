package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "forgot password form")
public class ForgotPasswordForm {

    @ElementName(name = "login")
    @FindBy(xpath = "//input[@name='reset-login']")
    private WebElement login;

    @ElementName(name = "close button")
    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeButton;

    @ElementName(name = "not correct input message for login")
    @FindBy(xpath = "//div[@class='form__top-error']")
    private WebElement notCorrectInputMessageForLogin;

    @ElementName(name = "submit button")
    @FindBy(xpath = "//form[@name='reset-password-form']//button[@type='submit']")
    private WebElement submitButton;
}
