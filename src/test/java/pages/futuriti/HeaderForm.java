package pages.futuriti;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Futuriti header")
public class HeaderForm {
    @ElementName(name = "bonusesButton")
    @FindBy(xpath = "//a[contains(@href,'bonuses')]")
    private SelenideElement bonusesButton;

    @ElementName(name = "pointsButton")
    @FindBy(xpath = "//a[contains(@href,'points')]")
    private SelenideElement pointsButton;

    @ElementName(name = "faqButton")
    @FindBy(xpath = "//div/a[contains(@href,'faq')]")
    private SelenideElement faqButton;

    @ElementName(name = "rewardsButton")
    @FindBy(xpath = "//a[@href='#'][@class='navigation-menu__item-link']")
    private SelenideElement rewardsButton;

    @ElementName(name = "gamesButton") //leads to start page
    @FindBy(xpath = "//a[@href='https://test1.futuriti.com/de'][@class='navigation-menu__item-link']")
    private SelenideElement gamesButton;

    @ElementName(name = "user panel name")
    @FindBy(xpath = "//span[@class='user-panel__name']")
    private SelenideElement userPanelName;

    @ElementName(name = "logout")
    @FindBy(xpath = "//a[@class='user-panel__logout']")
    private SelenideElement logoutButton;

    @ElementName(name = "login")
    @FindBy(xpath = "//a[@class='navigation-menu__button']")
    private SelenideElement loginButton;
}
