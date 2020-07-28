package pages.futuriti;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageName(name = "FuturitiGameInteractions")
public class FuturitiGameInteractions {
    @ElementName(name = "playButton")
    @FindBy(xpath = "//div[@class='tab-item'][1]//button[@class='game-browser__item--btn game-browser__item--btn__play']")
    private List<SelenideElement> playButton;

    @ElementName(name = "demoButton")
    @FindAll({
            @FindBy(xpath = "//div[@class='tab-item'][1]//button[@class='game-browser__item--btn game-browser__item--btn__demo']"),
            @FindBy(xpath = "//div[@class='tab-item'][1]//span[contains(text(),'try to fun')]")
    })
    private List<SelenideElement> demoButton;

    @ElementName(name = "gameIframe")
    @FindBy(xpath = "//div[@class='game-modal__iframe-container']/iframe")
    private SelenideElement gameIframe;

    @ElementName(name = "errorBody")
    @FindBy(xpath = "//body[contains(text(),'error')]")
    private SelenideElement errorBody;

    @ElementName(name = "closeButton")
    @FindBy(xpath = "//button[@class='game-modal__close']")
    private SelenideElement closeButton;

    @ElementName(name = "gameImg")
    @FindBy(xpath = "//img[@class='game-browser__item--img']")
    private List<SelenideElement> gameImg;

    @ElementName(name = "gameTitle")
    @FindBy(xpath = "//span[@class='game-browser__item--title']")
    private List<SelenideElement> gameTitle;

    @ElementName(name = "elWithIDGame")
    @FindBy(xpath = "//*[@id='game']")
    private SelenideElement elWithIDGame;

    @ElementName(name = "enableFlashButton")
    @FindAll({
            @FindBy(xpath = "//a[@href='https://get.adobe.com/flashplayer/']"),
            @FindBy(id = "get-flash")
    })
    private SelenideElement enableFlashButton;

    @ElementName(name = "tab items")
    @FindBy(xpath = "//div[@class='tab-item']")
    private SelenideElement tabItems;

    @ElementName(name = "loading")
    @FindBy(id = "loader")
    private SelenideElement loading;

    //если хоть один из локаторов работает то игра считается успешно запущенной
//    @ElementName(name = "elementThatEnsuresThatGameWorks")
//    @FindAll({
//            @FindBy(id = "get-flash"),
//            @FindBy(id = "Flash"),
//            @FindBy(id = "noflash"),
//            @FindBy(id = "flash-logo"),
//            @FindBy(id = "FLASHMOVIE"),
//            @FindBy(id = "enable-flashContainer"),
//            @FindBy(id = "divGameHistory"),
//            @FindBy(id = "loading"),
//            @FindBy(id = "loading-screen"),
//            @FindBy(id = "canvas"),
//            @FindBy(id = "uiCanvas"),
//            @FindBy(id = "gameCanvas"),
//            @FindBy(id = "slotCanvas"),
//            @FindBy(id = "game-iframe"),
//            @FindBy(id = "game"),
//            @FindBy(id = "gameBack"),
//            @FindBy(className = "game"),
//            @FindBy(className = "gameContainer"),
//            @FindBy(id = "game-canvas"),
//            @FindBy(id = "casinoClient"),
//            @FindBy(id = "gameArea"),
//            @FindBy(id = "nolimit-game-target"),
//            @FindBy(id = "gameFullScreenContainer"),
//            @FindBy(id = "fullScreenBackground"),
//            @FindBy(id = "preloaderBackground"),
//            @FindBy(id = "enable-flashContainer"),
//            @FindBy(id = "khanvas"),
//            @FindBy(id = "viewport"),
//            @FindBy(xpath = "//canvas"),
//            @FindBy(xpath = "//iframe[contains(@src,'https://miracorp')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'game-launcher-lux.isoftbet.com')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'cf-iomeu-cdn.relaxg.com')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'cdn.endorphina.com')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'tomhorngames.com')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'valueactive.eu')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'cf-iomeu-cdn.relaxg.com')]"),
//            @FindBy(xpath = "//iframe[contains(@src,'casino.nolimitcdn.com')]"),
//            //@FindBy(xpath = "//iframe[contains(@src,'gamelauncher.contentmedia.eu')]"),
//            @FindBy(xpath = "//div[@class='game']"),
//            @FindBy(xpath = "//iframe[@id='game']"),
//            @FindBy(xpath = "//iframe[@id='casinoClient']"),
//            @FindBy(xpath = "//iframe[@id='png-game-container']"),
//            @FindBy(xpath = "//div[@id='gameInterface']"),
//            @FindBy(xpath = "//div[@id='game_bg']"),
//            @FindBy(xpath = "//div[@id='game-bg']")
//    })
//    private SelenideElement elementThatEnsuresThatGameWorks;
}
