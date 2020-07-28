package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Footer menu")
public class FooterMenu {
    @ElementName(name = "responsibleGamingButton")
    @FindBy(xpath = "//a[contains(@href,'responsible-gaming')]")
    private WebElement responsibleGamingButton;

    @ElementName(name = "aboutButton")
    @FindBy(xpath = "//a[contains(@href,'about')]")
    private WebElement aboutButton;

    @ElementName(name = "termsAndConditionsButton")
    @FindBy(xpath = "//a[contains(@href,'terms-and-conditions')]")
    private WebElement termsAndConditionsButton;

    @ElementName(name = "privacyPolicyButton")
    @FindBy(xpath = "//a[contains(@href,'privacy-policy')]")
    private WebElement privacyPolicyButton;
}
