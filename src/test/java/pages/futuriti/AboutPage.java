package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "About page")
public class AboutPage {
    @ElementName(name = "static about page")
    @FindBy(xpath = "//div[@class='aboutPage staticPage']")
    private WebElement staticAboutPage;
}
