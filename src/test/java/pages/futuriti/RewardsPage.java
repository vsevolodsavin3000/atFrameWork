package pages.futuriti;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageName(name = "Rewards page")
public class RewardsPage {
    @ElementName(name = "rewardsTable")
    @FindBy(xpath = "//div[@class='rewards']")
    private SelenideElement rewardsTable;

    @ElementName(name = "depositButton")
    @FindBy(xpath = "//button[@class='banner-slider-info-btns__btn banner-slider-info-btns__btn-deposit']")
    private SelenideElement depositButton;

    @ElementName(name = "okButton")
    @FindBy(xpath = "//div[contains(@class,'notification-achievement')]//button[contains(text(),'Ok')]")
    private SelenideElement okButton;
    //button[@class='modal__close']
    @ElementName(name = "closeAchievementButton")
    @FindBy(xpath = "//div[@class='notification notification-achievement']//button")
    private SelenideElement closeAchievementButton;

    @ElementName(name = "imageOfFirstReward")
    @FindBy(xpath = "//div[@class='rewards-img']")
    private SelenideElement imageOfFirstReward;

    @ElementName(name = "10FS")
    @FindBy(xpath = "//span[@class='rewards-amount' and contains(text(),'10')]")
    private SelenideElement tenFreeSpin;

    @ElementName(name = "15FS")
    @FindBy(xpath = "//span[@class='rewards-amount' and contains(text(),'15')]")
    private SelenideElement fifteenFreeSpin;

    @ElementName(name = "20FS")
    @FindBy(xpath = "//span[@class='rewards-amount' and contains(text(),'20')]")
    private SelenideElement twentyFreeSpin;

    @ElementName(name = "bestSpinButton")
    @FindBy(xpath = "//button[@class='best-spin__button']")
    private SelenideElement bestSpinButton;

    @ElementName(name = "closeRewardsButton")
    @FindBy(xpath = "//button[@class='rewards-modal__close']")
    private SelenideElement closeRewardsButton;

    @ElementName(name = "payDepositButton")
    @FindBy(xpath = "//button[@class='reward-wo__get-bonus']")
    private SelenideElement payDepositButton;

    @ElementName(name = "rewardDescriptionForm")
    @FindBy(xpath = "//div[@class='rewards-modal__window']")
    private SelenideElement rewardDescriptionForm;
}
