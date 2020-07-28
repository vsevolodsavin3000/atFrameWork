package pages.futuriti;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "Cashier deposit form")
public class CashierDepositForm {
    @ElementName(name = "depositTab")
    @FindBy(xpath = "//a[@href='#cashier_deposit']")
    private SelenideElement depositTab;

    @ElementName(name = "withdrawalTab")
    @FindBy(xpath = "//a[@href='#cashier_withdrawal']")
    private SelenideElement withdrawalTab;

    @ElementName(name = "closeButton")
    @FindBy(xpath = "//button[@class='modal__close modal__close--cashier']")
    private SelenideElement closeButton;

    @ElementName(name = "paymentMethods")
    @FindBy(xpath = "//a[@class='cashier__payment-method']")
    private List<SelenideElement> paymentMethods;

    @ElementName(name = "paymentAmount")
    @FindBy(name = "amount")
    private SelenideElement paymentAmount;

    @ElementName(name = "nextButton")
    @FindBy(xpath = "//form[@name='cashier-deposit-form']//button[@type='submit']")
    private SelenideElement nextButton;

    @ElementName(name = "inputCardNameField")
    @FindBy(id = "chName")
    private SelenideElement inputCardNameField;

    @ElementName(name = "inputCardNumberField")
    @FindBy(id = "cardNumber")
    private WebElement inputCardNumberField;

    @ElementName(name = "expiryMonth")
    @FindBy(id = "expiryMonth")
    private SelenideElement expiryMonth;

    @ElementName(name = "expiryYear")
    @FindBy(id = "expiryYear")
    private SelenideElement expiryYear;

    @ElementName(name = "cvnNumber")
    @FindBy(id = "cvnNumber")
    private SelenideElement cvnNumber;

    @ElementName(name = "payButton")
    @FindBy(xpath = "//button[@class='payButton btn btn-inverse btn-hg btn-block']")
    private SelenideElement payButton;

    @ElementName(name = "password")
    @FindBy(id = "password")
    private SelenideElement password;

    @ElementName(name = "authenticate")
    @FindBy(name = "authenticate")
    private SelenideElement authenticate;

    @ElementName(name = "creditCardsFrame")
    @FindBy(id = "CreditCardsFrame")
    private SelenideElement creditCardsFrame;

    @ElementName(name = "paymentFrameDeposit")
    @FindBy(id = "payment-frame-deposit")
    private SelenideElement paymentFrameDeposit;

    @ElementName(name = "OKCloseWindow")
    @FindBy(id = "close-window")
    private SelenideElement OKCloseWindow;

}
