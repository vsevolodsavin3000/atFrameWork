package pages.luckme;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "luckmeRegistrationForm")
public class RegisterForm {

    @ElementName(name = "registerForm")
    @FindBy(xpath = "//section/div[@class='register-form form']")
    private WebElement registerForm;

    @ElementName(name = "emailField")
    @FindBy(name = "email")
    private WebElement emailField;

    @ElementName(name = "passwordField")
    @FindBy(name = "password")
    private WebElement passwordField;

    @ElementName(name = "First step submit button")
    @FindBy(xpath = "//form[@name='register-step1-form']//button")
    private WebElement registerButtonStepOne;

    @ElementName(name = "firstNameField")
    @FindBy(name = "first-name")
    private WebElement firstNameField;

    @ElementName(name = "lastNameField")
    @FindBy(name = "last-name")
    private WebElement lastNameField;

    @ElementName(name = "errorMessageEmail")
    @FindBy(xpath = "//input[@name='email']/following-sibling::div[@class='form__error']")
    private WebElement errorMessageEmail;

    @ElementName(name = "errorMessagePassword")
    @FindBy(xpath = "//input[@name='password']/following-sibling::div[@class='form__error']")
    private WebElement errorMessagePassword;

    @ElementName(name = "errorMessageFirstName")
    @FindBy(xpath = "//input[@name='first-name']/following-sibling::div[@class='form__error']")
    private WebElement errorMessageFirstName;

    @ElementName(name = "errorMessageLastName")
    @FindBy(xpath = "//input[@name='last-name']/following-sibling::div[@class='form__error']")
    private WebElement errorMessageLastName;

    @ElementName(name = "closeButton")
    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeButton;

    @ElementName(name = "birthDay")
    @FindBy(name = "birth-day")
    private WebElement birthDay;

    @ElementName(name = "birthMonth")
    @FindBy(name = "birth-month")
    private WebElement birthMonth;

    @ElementName(name = "birthYear")
    @FindBy(name = "birth-year")
    private WebElement birthYear;

    @ElementName(name = "country")
    @FindBy(name = "country")
    private WebElement country;

    @ElementName(name = "terms checkbox")
    @FindBy(xpath = "//div[@for='terms-agreement_register-form']//span[@class='form__checkbox-icon']")
    private WebElement termsCheckbox;

    @ElementName(name = "terms href")
    @FindBy(xpath = "//div[@for='terms-agreement_register-form']/a[contains(@href,'terms-and')]")
    private WebElement termsHref;

    @ElementName(name = "continueButton")
    @FindBy(xpath = "//button[@class='form__submit']/span")
    private WebElement continueButton;
}
