package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Terms page")
public class TermsAndConditionsPage {
    @ElementName(name = "terms of use text")
    @FindBy(xpath = "//div[@class='termsOfUse staticPage']")
    private WebElement termsText;
}
