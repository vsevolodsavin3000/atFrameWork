package pages.luckme;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "HeaderForm")
public class HeaderForm {
    @ElementName(name = "HeaderForm")
    @FindBy(xpath = "//div[@class='navigation-menu']")
    private WebElement headerBlock;

    @ElementName(name = "LuckMe button")
    @FindBy(xpath = "//div[@class='navigation-menu__top']/a")
    private WebElement luckMeButton;

    @ElementName(name = "Log In button")
    @FindBy(xpath = "//div[@class='navigation-menu__buttons']/a[1]")
    private WebElement logInButton;

    @ElementName(name = "Sign Up button")
    @FindBy(xpath = "//div[@class='navigation-menu__buttons']/a[2]")
    private WebElement signUpButton;

    @ElementName(name = "Games button")
    @FindBy(xpath = "//ul[@class='navigation-menu__menu']/li[1]//a")
    private WebElement gamesButton;

    @ElementName(name = "Faq button")
    @FindBy(xpath = "//ul[@class='navigation-menu__menu']/li[2]//a")
    private WebElement faqButton;

    @ElementName(name = "Language control menu")
    @FindBy(xpath = "//div[@class[contains(. ,'lang-control--head-menu')]]")
    private WebElement langControlMenu;

    @ElementName(name = "options of language control menu")
    @FindBy(xpath = "//div[@class[contains(. ,'lang-control--head-menu')]]//ul/li")
    private List<WebElement> langControlMenuOptions;

}
