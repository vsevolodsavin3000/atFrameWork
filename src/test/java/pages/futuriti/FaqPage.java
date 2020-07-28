package pages.futuriti;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "Faq page")
public class FaqPage {
    @ElementName(name = "last table")
    @FindBy(xpath = "//div[@class='faq-section']")
    private WebElement lastTable;

    @ElementName(name = "faq tabs")
    @FindBy(xpath = "//div[@class='faq-section__item']")
    private List<WebElement> faqTabs;

    @ElementName(name = "faq tabs hrefs")
    @FindBy(xpath = "//div[@class='faq-section__answer']//a")
    private List<SelenideElement> faqTabsHrefs;

}
