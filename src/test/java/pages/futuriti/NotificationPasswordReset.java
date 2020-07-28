package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "notification password reset")
public class NotificationPasswordReset {
    @ElementName(name = "notification form")
    @FindBy(xpath = "//div[@class='notification notification--reset-email']")
    private WebElement form;

    @ElementName(name = "close button")
    @FindBy(xpath = "//button[@class=' notification__button close-button']")
    private WebElement button;
}
