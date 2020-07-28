package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Privacy policy page")
public class PrivacyPolicyPage {
    @ElementName(name = "static privacy page")
    @FindBy(xpath = "//div[@class='privacyPage staticPage']")
    private WebElement staticPrivacyPage;
}