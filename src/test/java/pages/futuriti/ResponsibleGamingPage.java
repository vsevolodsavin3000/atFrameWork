package pages.futuriti;

import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Responsible gaming page")
public class ResponsibleGamingPage {
    @ElementName(name = "static page")
    @FindBy(xpath = "//div[@class='staticPage']")
    private WebElement staticPage;
}
