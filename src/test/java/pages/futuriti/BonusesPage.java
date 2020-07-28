package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@PageName(name = "Bonuses page")
public class BonusesPage {
    @ElementName(name = "promo list container")
    @FindBy(xpath = "//div[@class='promo-list__container']")
    private WebElement promoListContainer;

    @ElementName(name = "promo list image")
    @FindBy(xpath = "//div[@class='promo-list__image']")
    private WebElement promoListImage;

    @ElementName(name = "button")
    @FindBy(xpath = "//button[@class='button button--filled']")
    private WebElement buttonFilled;

    @ElementName(name = "closeButton")
    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeButton;

    @ElementName(name = "promoModelTitle")
    @FindBy(xpath = "//div[@class='promo-modal__title']")
    private WebElement promoModelTitle;

    @ElementName(name = "banners")
    @FindBy(xpath = "//div[@class='promo-list__image']")
    private List<WebElement> banners;
}
