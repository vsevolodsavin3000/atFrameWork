package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "cancel registration ask form")
public class AbortRegistrationForm {

    @ElementName(name = "no button")
    @FindBy(xpath = "//button[@class='notification__button back-button']")
    private WebElement noButton;

    @ElementName(name = "yes button")
    @FindBy(xpath = "//button[@class=' notification__button close-button']")
    private WebElement yesButton;
}
