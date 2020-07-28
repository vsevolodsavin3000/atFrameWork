package pages.futuriti;


import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "Futuriti Start page")

public class FuturitiStartPage {
    @ElementName(name = "GDPR button")
    @FindBy(xpath = "//div[@class='flash-message']/button")
    private SelenideElement gdprButton;

    @ElementName(name = "GDPR form")
    @FindBy(xpath = "//div[@class='flash-message__content']")
    private SelenideElement gdprWindow;

    @ElementName(name = "GDPR link")
    @FindBy(xpath = "//div[@class='flash-message__content']/a")
    private SelenideElement gdprLink;

    @ElementName(name = "Futuriti logo")
    @FindBy(xpath = "//a[@class='navigation-menu__logo']")
    private SelenideElement futuritiLogo;

    @ElementName(name = "Registration button")
    @FindBy(xpath = "//a[@class='navigation-menu__button is-highlighted']")
    private SelenideElement registrationButton;

    @ElementName(name = "user panel name")
    @FindBy(xpath = "//span[@class='user-panel__name']")
    private SelenideElement userPanelName;

    @ElementName(name = "logout")
    @FindBy(xpath = "//a[@class='user-panel__logout']")
    private SelenideElement logoutButton;

    @ElementName(name = "login")
    @FindBy(xpath = "//a[@class='navigation-menu__button']")
    private SelenideElement loginButton;

    @ElementName(name = "tab items")
    @FindBy(xpath = "//div[@class='tab-item']")
    private SelenideElement tabItems;

    @ElementName(name = "allGamesTab")
    @FindBy(xpath = "//div[@class='tabs__menu']//div[contains(text(),'A-Z')]")
    private SelenideElement allGamesTab;

    @ElementName(name = "jackpotTab")
    @FindBy(xpath = "//div[@class='tabs__menu']//div[contains(text(),'Jackpot')]")
    private SelenideElement jackpotTab;

    @ElementName(name = "providersTab")
    @FindBy(xpath = "//div[@class='tabs__menu']//div[contains(text(),'Providers')]")
    private SelenideElement providersTab;

    @ElementName(name = "categoriesTab")
    @FindBy(xpath = "//div[@class='tabs__menu']//div[contains(text(),'Categories')]")
    private SelenideElement categoriesTab;

    @ElementName(name = "slickSliderButtons")
    @FindBy(xpath = "(//ul[@class='slick-dots'])[1]/li")
    private List<SelenideElement> slickSliderButtons;

    @ElementName(name = "slickSliderImages")
    @FindBy(xpath = "//div[@class='slick-slide']")
    private List<SelenideElement> slickSliderImages;

    @ElementName(name = "slider")
    @FindBy(xpath = "//div[@class='slider']")
    private SelenideElement slider;
}
