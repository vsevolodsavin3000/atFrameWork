package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "Points page")
public class PointsPage {
    @ElementName(name = "achievements wrapper")
    @FindBy(xpath = "//div[@class='achievements__wrapper']")
    private WebElement achievementsWrapper;

    @ElementName(name = "howToGetButton")
    @FindBy(xpath = "//button[@class='achievements__item--details__button']")
    private List<WebElement> howToGetButton;

//div[@class='notification__description']//button
    @ElementName(name = "goToOtherPageButton")
    @FindBy(xpath = "//div[@class='notification__description']//button")
    private WebElement goToOtherPageButton;
}
