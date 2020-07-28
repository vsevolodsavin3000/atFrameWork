package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "futuritiRegistrationForm")

public class RegisterForm {

    @ElementName(name = "Registration form")
    @FindBy(xpath = "//div[@class='modal__window modal__window--reg']")
    private WebElement registrationForm;

    @ElementName(name = "Close button for registration form")
    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeButton;

    @ElementName(name = "email")
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @ElementName(name = "password")
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @ElementName(name = "not correct input message for email")
    @FindBy(xpath = "//input[@name='email']/following-sibling::div[@class='form__error form__error_invalid-value-error']")
    private WebElement notCorrectInputMessageForEmail;

    @ElementName(name = "errorMessagePasswordTooShort")
    @FindBy(xpath = "//input[@name='password']/following-sibling::div[@class='form__error form__error_too-short-error']")
    private WebElement errorMessagePasswordTooShort;

    @ElementName(name = "errorMessagePasswordTooLong")
    @FindBy(xpath = "//input[@name='password']/following-sibling::div[@class='form__error form__error_too-long-error']")
    private WebElement errorMessagePasswordTooLong;

    @ElementName(name = "errorMessagePasswordInvalidChar")
    @FindBy(xpath = "//input[@name='password']/following-sibling::div[@class='form__error form__error_invalid-value-error']")
    private WebElement errorMessagePasswordInvalidChar;

    @ElementName(name = "continue")
    @FindBy(xpath = "//button[@class='form__submit']/span")
    private WebElement continueButton;

    @ElementName(name = "name")
    @FindBy(xpath = "//input[@name='first-name']")
    private WebElement firstNameField;

    @ElementName(name = "surname")
    @FindBy(xpath = "//input[@name='last-name']")
    private WebElement lastNameField;

    @ElementName(name = "birth day")
    @FindBy(xpath = "//select[@name='birth-day']")
    private WebElement birthDay;

    @ElementName(name = "birth month")
    @FindBy(xpath = "//select[@name='birth-month']")
    private WebElement birthMonth;

    @ElementName(name = "birth year")
    @FindBy(xpath = "//select[@name='birth-year']")
    private WebElement birthYear;

    @ElementName(name = "terms href")
    @FindBy(xpath = "//div[@for='terms-agreement']/a[contains(@href,'terms-and')]")
    private WebElement termsHref;

    @ElementName(name = "country")
    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryDropbox;

    @ElementName(name = "terms checkbox")
    @FindBy(xpath = "//label[@for='terms-agreement']/span[@class='form__checkbox-icon']")
    private WebElement termsCheckbox;

    @ElementName(name = "not correct input message for name")
    @FindBy(xpath = "//input[@name='first-name']/following-sibling::div[@class='form__error']")
    private WebElement notCorrectInputMessageForName;

    @ElementName(name = "not correct input message for surname")
    @FindBy(xpath = "//input[@name='last-name']/following-sibling::div[@class='form__error']")
    private WebElement notCorrectInputMessageForLastName;

    @ElementName(name = "herr checkbox")
    @FindBy(xpath = "//div[@class='form__radio']/label")
    private WebElement herrCheckbox;

    @ElementName(name = "city")
    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityField;

    @ElementName(name = "phone-number")
    @FindBy(xpath = "//input[@name='phone-number']")
    private WebElement phoneNumber;

    @ElementName(name = "submitButton")
    @FindBy(xpath = "//form[@name='register-step2-form']//button[@class='form__submit']")
    private WebElement submitButton;

    @ElementName(name = "not correct input message for city")
    @FindBy(xpath = "//input[@name='city']/following-sibling::div[@class='form__error']")
    private WebElement notCorrectInputMessageForCity;

    @ElementName(name = "not correct input message for phone number")
    @FindBy(xpath = "//input[@name='phone-number']/following-sibling::div[@class='form__error']")
    private WebElement notCorrectInputMessageForPhoneNumber;

}
