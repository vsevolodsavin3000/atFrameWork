package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "User panel page")
public class UserPanelPage {
    @ElementName(name = "accountSettingsButton")
    @FindBy(xpath = "//a[contains(@href,'#settings')]")
    private WebElement accountSettingsButton;

    @ElementName(name = "transactionsButton")
    @FindBy(xpath = "//a[contains(@href,'#transactions')]")
    private WebElement transactionsButton;

    @ElementName(name = "accountButton")
    @FindBy(xpath = "//a[contains(@href,'#account')]")
    private WebElement accountButton;

    @ElementName(name = "accountInfo")
    @FindBy(xpath = "//div[@class='account']")
    private WebElement accountInfo;

    @ElementName(name = "profileSettings")
    @FindBy(xpath = "//div[@class='profile-settings']")
    private WebElement profileSettings;

    @ElementName(name = "transactionsForm")
    @FindBy(xpath = "//div[@class='transactions']")
    private WebElement transactionsForm;
}
