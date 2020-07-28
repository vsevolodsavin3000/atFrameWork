package pages.luckme;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Start page")
public class StartPage {

    @ElementName(name = "Start page")
    @FindBy(xpath = "//div[text()[contains(.,'LuckMe')]]")
    private WebElement logo;


    @ElementName(name = "GDPR button")
    @FindBy(xpath = "//div[@class='flash-message']/button")
    private WebElement gdprButton;

    @ElementName(name = "Login form")
    @FindBy(xpath = "//form[@name='login-form']")
    private WebElement loginForm;


}

