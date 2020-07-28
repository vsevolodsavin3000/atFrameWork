package stepDefinition;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.net.*;
import java.util.*;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helper.Refl.*;
import static org.junit.Assert.*;

public class StepImplementation {
    private final static Logger log = LoggerFactory.getLogger(StepImplementation.class);
    private int countNull = 0;
    private static String generatedEmail = null;
    private static String href = InitialSteps.href;
    private static WebDriverWait wait = new WebDriverWait(getWebDriver(), 15);
    private static WebDriverWait smallWait = new WebDriverWait(getWebDriver(), 2);

/*    @Дано("^Браузер успешно запущен и открыл ссылку$")
    public static void openLinkInBrowser() throws Throwable {
        open(href);
        log.info("link is open: " + href);
    }*/

    @Тогда("^(?:страница|форма) \"([^\"]*)\" открыта$")
    public void openPage(String pageName) throws Throwable {
        initPage(pageName); //инициализация элементов страницы
        log.info("open " + pageName);
    }

    @Тогда("^на странице появляется \"([^\"]*)\"$")
    public void pageContains(String elName) throws Throwable {
        findElementByName(elName).waitUntil(Condition.visible, Configuration.timeout);
        log.info("page|block|form contains " + elName);
    }

    @Когда("^пользователь нажимает (?:кнопку|чекбокс|элемент) \"([^\"]*)\"$")
    public void pressButton(String elName) throws Throwable {
        findElementByName(elName).waitUntil(Condition.visible, Configuration.timeout).click();
        log.info("user (click|choose) " + elName);
    }


    @Когда("^пользователь вводит \"([^\"]*)\" в поле \"([^\"]*)\"$")
    public static void insertValueInField(String text, String fieldName) throws Throwable {
        findElementByName(fieldName).waitUntil(Condition.visible, Configuration.timeout).clear();
        findElementByName(fieldName).sendKeys(text);
        log.info("user typed " + text + " in " + fieldName);
    }


    @И("^(?:кнопка|форма|элемент) \"([^\"]*)\" (?:недоступна|недоступен)$")
    public void elementDisabled(String elName) throws Throwable {
        findElementByName(elName).shouldBe(Condition.disabled);
        log.info(elName + " is disabled");
    }

    @Тогда("^пользователь заполняет следующие поля значениями$")
    public void user_fills_the_following_fields_with_values(DataTable value) throws Throwable {
        Map<String, String> map = value.asMap(String.class, String.class);
        Iterator ens = map.entrySet().iterator();
        while (ens.hasNext()) {
            Map.Entry entry = (Map.Entry) ens.next();
            findElementByName(entry.getKey().toString()).shouldBe(Condition.visible).clear();
            findElementByName(entry.getKey().toString()).sendKeys(entry.getValue().toString());
        }
        log.info("user fills fields with values");
    }

    @Когда("^пользователь вводит корректный сгенерированный \"([^\"]*)\" и \"([^\"]*)\"$")
    public void correctEmailAndPassword(String email, String password) throws Throwable {
        findElementByName(email).waitUntil(Condition.visible, Configuration.timeout).clear();
        generatedEmail = getRandomEmail();
        findElementByName(email).sendKeys(generatedEmail);
        findElementByName(password).waitUntil(Condition.visible, Configuration.timeout).clear();
        findElementByName(password).sendKeys("GoodCorrectPassword");
        log.info("user fills fields with CORRECT values, generated email: " + generatedEmail);
    }

    @Тогда("^пользователь вводит корректный сгенерированный \"([^\"]*)\"$")
    public void correctGeneratedTelNumber(String phoneNumber) throws Throwable {
        findElementByName(phoneNumber).waitUntil(Condition.visible, Configuration.timeout).clear();
        String generatedTelNumber = getRandomNumber();
        findElementByName(phoneNumber).sendKeys(generatedTelNumber);
        log.info("user fills fields with CORRECT values, generated email: " + generatedTelNumber);
    }

    @Тогда("^(?:кнопка|элемент|форма) \"([^\"]*)\" (?:доступна|доступен)$")
    public void elementEnabled(String elName) throws Throwable {
        findElementByName(elName).scrollTo().shouldNotBe(Condition.disabled);
        log.info(elName + " is enabled");
    }

    @И("^пользователь выбирает из следующих дропбоксов значения$")
    public void chooseFromDropbox(DataTable value) throws Throwable {
        Map<String, String> map = value.asMap(String.class, String.class);
        Iterator ens = map.entrySet().iterator();
        while (ens.hasNext()) {
            Map.Entry entry = (Map.Entry) ens.next();
            findElementByName(entry.getKey().toString()).click();
            findElementByName(entry.getKey().toString()).sendKeys(entry.getValue().toString(), Keys.TAB);
        }
        log.info("user fills dropboxes with values");
    }

    @Тогда("^пользователь переходит на страницу (\\d+)$")
    public void switchToTab(int pageNum) throws Throwable {
        switchTo().window(pageNum);
        log.info("switched to page: " + pageNum);
    }

    @Тогда("^пользователь закрывает страницу (\\d+)$")
    public void closeTab(int pageNum) throws Throwable {
        switchTo().window(pageNum).close();
        log.info("closed page: " + pageNum);
    }

    @Тогда("^(?:форма|кнопка|элемент|поле) \"([^\"]*)\" исчезает$")
    public void elementDisappears(String elName) throws Throwable {
        findElementByName(elName).waitUntil(Condition.disappear, 15000);
        log.info("disappeared element: " + elName);
    }


    @Ктомуже("^пользователь очищает поле \"([^\"]*)\"$")
    public void clearField(String elName) throws Throwable {
        findElementByName(elName).waitUntil(Condition.visible, Configuration.timeout).clear();
        findElementByName(elName).sendKeys(Keys.TAB);
        log.info("cleared field: " + elName);
    }


    @Тогда("^пользователь вводит корректный логин для этого сайта$")
    public static void inputCorrectLoginForCurrentSite() throws Throwable {
        if (href.contains("https://pub.ftrt.cc") || href.contains("https://test1.futuriti.com") || href.contains("https://test2.futuriti.com") || href.contains("https://gofuturiti.com")) {
            insertValueInField("test2futuriti@mail.ru", "login");
        } else if (href.contains("https://luckme-staging.azartlab.com") || href.contains("https://test1.luckme.com")) {
            insertValueInField("test1luckme@mail.ru", "login");
        } else if (href.contains("https://test2.luckme.com")) {
            insertValueInField("test2luckme@mail.ru", "login");
        }
    }


    @Тогда("^пользователь проверяет работоспособность всех ссылок на странице$")
    public void checkAllHrefs() throws Exception {
        ArrayList<String> errorCollector = new ArrayList<>();
        for (String href : collectAllAvailableHrefs()) {
            String errorMessage = checkURL(href);
            if (!(errorMessage == null)) {
                errorCollector.add(errorMessage);
            }
        }
        printErrorCollectorAndFailTestIfItIsNotEmpty(errorCollector, "CHECK ALL LINKS TEST");
    }


    public ArrayList<String> collectAllAvailableHrefs() {
        ElementsCollection elementList = $$(By.xpath("//a[contains(@href,'http')]"));
        ArrayList<String> finalList = new ArrayList();
        for (SelenideElement element : elementList) {
            if (!element.getAttribute("href").contains("mailto")) {
                finalList.add(element.getAttribute("href"));
            }
        }
        ElementsCollection elementList1 = $$(By.xpath("//img[contains(@src,'http')]"));
        for (SelenideElement element : elementList1) {
            finalList.add(element.getAttribute("src"));
        }
        return finalList;
    }

    @Тогда("^пользователь кликает на элемент \"([^\"]*)\" № (\\d+)$")
    public void clickOnElementByOrder(String elName, int elNo) throws Throwable {
        SelenideElement el = $(findElementsByName(elName).get(elNo)).waitUntil(Condition.exist, Configuration.timeout).scrollTo();
        executeJavaScript("window.scrollBy(0,-100)");//user panel закрывает элемент когда к нему скроллится страница
        el.hover();
        el.waitUntil(Condition.visible, Configuration.timeout);
        el.click();
        log.info("clicked on : " + elName + " № " + elNo);
    }

    @Тогда("^пользователь возвращается назад$")
    public void navigateBack() {
        getWebDriver().navigate().back();
        log.info("returned to page");
    }


    @Тогда("^пользователь (?:открывает все вкладки|кликает по всем элементам) \"([^\"]*)\"$")
    public void clickOnAll(String elName) throws Throwable {
        $(findElementsByName(elName).get(0)).shouldBe(Condition.exist);
        List<SelenideElement> elCol = findElementsByName(elName);
        for (int i = 0; i < elCol.size(); i++) {
            clickOnElementByOrder(elName, i);
        }
    }

    @Ктомуже("^прокручивает страницу наверх$")
    public void scrollToTop() {
        $(By.xpath("//body")).scrollTo();
        log.info("scrolled to top");
    }

    @Тогда("^ссылка содержит \"([^\"]*)\"$")
    public void hrefContains(String text) throws Throwable {
        if (getWebDriver().getCurrentUrl().contains(text)) {
            log.info("URL contains: " + text);
        } else {
            log.error("URL does not contain: " + text);
            fail("URL does not contain: " + text);
        }
    }

    @Тогда("^элемент \"([^\"]*)\" имеет цвет \"([^\"]*)\"$")
    public void attributeOfElementContains(String elName, String value) throws Throwable {
        String colorString = $(findElementByName(elName)).getCssValue("color");
        Color color = Color.fromString(colorString);
        if (color.asHex().contains(value)) {
            log.info(elName + " color is value: " + value);
        } else {
            log.error(elName + " color is not value: " + value);
            fail(elName + " color is not value: " + value);
        }
    }

    @Дано("^обновляется страница$")
    public void refreshPage() {
        getWebDriver().navigate().refresh();
        log.info("Refreshed page");
    }

    @Дано("^закрываются все вкладки кроме первой$")
    public void closeAllTabsExceptFirst() throws Throwable {
        int handlesCount = getWebDriver().getWindowHandles().size();
        for (int i = 1; i < handlesCount; i++) {
            closeTab(1);
        }
        switchToTab(0);
    }

    @И("^пользователь кликает на элемент \"([^\"]*)\" № (\\d+) открывая в новой вкладке$")
    public void clickOnElementByOrderOpeningNewTab(String elName, int elNo) throws Throwable {
        SelenideElement el = $(findElementsByName(elName).get(elNo)).waitUntil(Condition.exist, Configuration.timeout).scrollTo();
        executeJavaScript("window.scrollBy(0,-100)");//user panel закрывает элемент когда к нему скроллится страница
        el.hover();
        el.waitUntil(Condition.visible, Configuration.timeout);
        el.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        log.info("clicked on : " + elName + " № " + elNo);
    }

    @Тогда("^проверяет баннеры на начальной странице кликая по \"([^\"]*)\"$")
    public void bannersOnStartPage(String sliderButton) throws Throwable {
        try {
            String ariaLabel = $(findElementsByName(sliderButton).get(0)).shouldBe(Condition.visible).getAttribute("aria-label");
            int quantity = Integer.parseInt(ariaLabel.substring(ariaLabel.lastIndexOf(" ") + 1));
            for (int i = 0; i < quantity; i++) {
                int j = i + 1;
                clickOnElementByOrder(sliderButton, i);
                if ($$(By.xpath("//div[@class='slick-slide']")).get(i).isDisplayed()) {
                    log.info("banner " + j + " displayed");
                } else {
                    log.error("banner " + j + " not displayed");
                }
            }
        } catch (ElementNotFound e) {
            log.warn("No banners on start page");
        }
    }

    @И("^пользователь ждет (\\d+) секунд$")
    public void waitSeconds(int arg0) throws InterruptedException {
        Thread.sleep(arg0 * 1000);
    }


    @И("^убеждается что адрес страницы корректный и не возвращает ошибок$")
    public void checkIfURLisCorrect() throws Exception {
        String errorMessage = checkURL(getWebDriver().getCurrentUrl());
        if (!(errorMessage == null)) {
            fail(errorMessage);
        }
    }

    @Тогда("^прожимаются все баннеры с нажатием кнопки в форме при наличии$")
    public void checkBannersWithAndWithoutButtons() throws Throwable {
        int bannersCount = (findElementsByName("banners")).size();
        ArrayList<String> errorCollector = new ArrayList<>();
        for (int i = 0; i < bannersCount; i++) {
            try {
                clickOnElementByOrder("banners", i);
                pageContains("promoModelTitle");
                try {
                    findElementByName("button").waitUntil(Condition.exist, 1000).click();
                    waitSeconds(1);
                    String errorMessage = checkURL(getWebDriver().getCurrentUrl());
                    if (!(errorMessage == null)) {
                        errorCollector.add(errorMessage);
                    }
                    navigateBack();
                } catch (com.codeborne.selenide.ex.UIAssertionError e) { //если кнопки нет выскакивает это исключение
                    findElementByName("closeButton").click();
                }
            } catch (Throwable e) {
                errorCollector.add("ERROR: Couldn't click banner № " + i + " or it didn't open form \n");
            }
        }
        printErrorCollectorAndFailTestIfItIsNotEmpty(errorCollector, "CHECK BANNERS TEST");
    }

    @И("^переключается на \"([^\"]*)\"$")
    public void switchToIframe(String name) throws Throwable {
        if (name.equals("defaultContent")) {
            getWebDriver().switchTo().defaultContent();
            log.info("switched to : " + name);
        } else {
            SelenideElement el = $(findElementByName(name)).waitUntil(Condition.appear, Configuration.timeout);
            //getWebDriver().switchTo().frame(el);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(el));
            log.info("switched to iframe: " + name);
        }
    }

    @Когда("^игрок нажимает все кнопки \"([^\"]*)\" проверяя работоспособность игр в разделе allGames для футурити$")
//пока только для allGames(как и было)
    public void checkGamesFuturiti(String elName) throws Throwable {
        ArrayList<String> errorCollector = new ArrayList<>();
        List<SelenideElement> listOfPlayButtons = $$(findElementsByName(elName));
        boolean needsToBeReinitialized = false;
        for (int i = 0; i < listOfPlayButtons.size(); i++) {
            pageContains("tab items");
            if (needsToBeReinitialized) {
                listOfPlayButtons = $$(findElementsByName(elName));
                needsToBeReinitialized = false;
            }
            listOfPlayButtons.get(i).scrollTo();
            executeJavaScript("window.scrollBy(0,-100)");
            listOfPlayButtons.get(i).hover().click();
            String[] url = getWebDriver().getCurrentUrl().split("/");
            String gameIDFromUrl = url[url.length - 1];
            String gameSupplierFromUrl = url[url.length - 2];
            log.info("Clicked play button on game with ID: " + gameIDFromUrl);
            try { //если загрузка висит вечно
                elementDisappears("loading");
            } catch (Throwable e) {
                String message = "FAILURE!('loading...' didn't disappear) GAME ID: " + gameIDFromUrl + ", GAME SUPPLIER: " + gameSupplierFromUrl + "\n";
                log.error(message);
                errorCollector.add(message);
                open("https://" + url[2]);
                initPage("Futuriti Start page");
                pressButton("allGamesTab");
                initPage("FuturitiGameInteractions");
                needsToBeReinitialized = true;
                continue;
            }
            try { //если внутри первого айфрэйма появляется айфрэйм с id=game или просьба включить флэш то ОК
                if (isAlertPresent()) { //может появится алерт с ошибкой или с сообщением что в этой стране нельзя играть
                    Alert alert = getWebDriver().switchTo().alert();
                    String alertText = alert.getText().toLowerCase();
                    alert.accept();
                    if (alertText.contains("something went wrong") || alertText.contains("error"))
                        throw new Throwable("Wild alert appeared and got an ERROR: " + alertText);
                    else if (alertText.contains("jurisdiction"))//если игра не работает для этой страны
                        throw new Throwable("Wild alert appeared and got a game NOT FOR THIS COUNTRY ");
                    else
                        throw new Throwable("Wild message in alert appeared: " + alertText);
                }
                findElementByName("gameIframe").waitUntil(Condition.exist, 10000);
                switchToIframe("gameIframe");
                try {
                    if ($(By.tagName("body")).getText().toLowerCase().contains("error"))
                        throw new Throwable("Game Iframe got an error ");
                } catch (ElementNotFound e) { //некоторые игры не находятся по тэгу бади, только через JS
                    if ((executeJavaScript("return document.body.textContent;")) == null)
                        ;//do nothing
                    else if (((String) executeJavaScript("return document.body.textContent;")).toLowerCase().contains("error"))
                        throw new Throwable("Game Iframe got an error ");
                }
                log.info("SUCCESS (opened or asked to enable flash) , GAME ID: " + gameIDFromUrl + "\n");
                switchToIframe("defaultContent");
                pressButton("closeButton");
            } catch (Throwable e) {
                String message = "FAILURE!(didn't open in 10 seconds or got an error) GAME ID: " + gameIDFromUrl + ", GAME SUPPLIER: " + gameSupplierFromUrl + ",Exception: " + e + "\n";
                log.error(message);
                errorCollector.add(message);
                switchToIframe("defaultContent");
                if (!e.toString().contains("alert"))//если нажали ОК на алерте , то кнопку закрыть нажимать не надо
                    pressButton("closeButton");
            }
        }
        printErrorCollectorAndFailTestIfItIsNotEmpty(errorCollector, "CHECK GAMES TEST");
    }

    //перед началом теста необходимо уже находиться на нужном разделе с играми, sectionName нужен чтобы еще раз заходить в нужный раздел после перезагрузки страницы(если игра висит вечно)
    @Ктомуже("^игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе \"([^\"]*)\" для лакми$")
    public void checkGamesForLuckme(String tabName) throws Throwable {
        //getWebDriver().manage().window().maximize();
        Configuration.savePageSource = false;
        List<SelenideElement> listOfNextSlideButtons = $$(findElementsByName("nextSlideButtons"));//все стрелки следующего слайда карусели
        ArrayList<String> errorCollector = new ArrayList<>();
        boolean needsToBeReinitialized = false;
        int sectionsInThisTab = listOfNextSlideButtons.size();
        for (int i = 1; i < sectionsInThisTab + 1; i++) {//счетчик по количеству блоков(каруселей) в разделе
            pageContains("tab items");//проверка что страница прогрузилась
            List<SelenideElement> playButtonsForCurrentSection = $$(By.xpath("((//div[@class='swiper-wrapper'])[" + i + "]//button)"));
            int quantityOfPlayButtonsForCurrentSection = playButtonsForCurrentSection.size();
            if (quantityOfPlayButtonsForCurrentSection == 0)
                continue;
            int nextColumnClicks = 0;//сколько раз нажать на nextSlideButton если страница перезагружалась
            int quantityOfGamesInColumn = $$(By.xpath("((//div[@class='swiper-wrapper'])[" + i + "]//div[@data-swiper-column='0'])")).size(); //количество игр в столбце
            if (quantityOfGamesInColumn == 0)//для каруселей в разделе top
                quantityOfGamesInColumn++;
            int quantityOfVisibleGames = $$(By.xpath("(//div[@class='swiper-wrapper'])[" + i + "]//div[contains(@class,'swiper-slide-visible')]")).size(); //количество видимых игр в блоке
            int maximumTimesOfClickingNextSlideButton = (int) Math.ceil((double) (quantityOfPlayButtonsForCurrentSection - quantityOfVisibleGames) / quantityOfGamesInColumn);
            for (int k = 0; k < quantityOfPlayButtonsForCurrentSection; k++) { //счетчик по играм в блоке
                pageContains("tab items");//проверка что страница прогрузилась
                if (needsToBeReinitialized) {//если страница перезагружалась
                    //listOfPlayButtons = $$(findElementsByName(elName));
                    playButtonsForCurrentSection = $$(By.xpath("((//div[@class='swiper-wrapper'])[" + i + "]//button)"));
                    listOfNextSlideButtons = $$(findElementsByName("nextSlideButtons"));
                    listOfNextSlideButtons.get(i - 1).scrollTo();
                    executeJavaScript("window.scrollBy(0,-150)");
                    for (int j = 0; j < nextColumnClicks && j < maximumTimesOfClickingNextSlideButton; j++) {//крутим карусель до игры на которой остановились изза того что висит вечно loader
                        if (listOfNextSlideButtons.get(i - 1).isEnabled()) {
                            listOfNextSlideButtons.get(i - 1).click();
                        }
                    }
                    Thread.sleep(500);
                    needsToBeReinitialized = false;
                }
                SelenideElement currentPlayButton = playButtonsForCurrentSection.get(k);
                currentPlayButton.scrollTo();
                executeJavaScript("window.scrollBy(0,-100)");
                Actions actions = new Actions(getWebDriver());
                actions.moveToElement(currentPlayButton).perform();//наводим курсор
                Thread.sleep(50);
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
                javascriptExecutor.executeScript("arguments[0].click();", currentPlayButton);
                String[] url = getWebDriver().getCurrentUrl().split("/");
                String gameIDFromUrl = url[url.length - 1];
                String gameSupplierFromUrl = url[url.length - 2];
                log.info("Clicked play button on game with ID: " + gameIDFromUrl + " on tab: " + tabName + ", section № " + i);
                try { //если загрузка висит вечно и необходимо перезагрузить страницу
                    elementDisappears("loading");
                } catch (Throwable e) {
                    String message = "FAILURE!(loader didn't disappear) GAME ID: " + gameIDFromUrl + ", GAME SUPPLIER: " + gameSupplierFromUrl + " on tab: " + tabName + ", section № " + i + "\n";
                    log.error(message);
                    errorCollector.add(message);
                    open("https://" + url[2]);
                    initPage("LuckmeStartPage");
                    pressButton(tabName);
                    initPage("LuckmeGameInteractions");
                    needsToBeReinitialized = true;
                    if ((k + 1) % quantityOfGamesInColumn == 0 && k > quantityOfGamesInColumn - 1 && nextColumnClicks < maximumTimesOfClickingNextSlideButton) {//если тест на последней игре в столбце
                        nextColumnClicks++; //двигается после прохождения второго столбца ,если play будет близко к краю то возникают проблемы
                    }
                    continue;
                }
                try { //если внутри первого айфрэйма появляется айфрэйм с id=game или просьба включить флэш то ОК
                    if (isAlertPresent()) { //может появится алерт с ошибкой или с сообщением что в этой стране нельзя играть
                        Alert alert = getWebDriver().switchTo().alert();
                        String alertText = alert.getText().toLowerCase();
                        alert.accept();
                        if (alertText.contains("something went wrong") || alertText.contains("error"))
                            throw new Throwable("Wild alert appeared and got an ERROR: " + alertText);
                        else if (alertText.contains("jurisdiction"))//если игра не работает для этой страны
                            throw new Throwable("Wild alert appeared and got a game NOT FOR THIS COUNTRY ");
                        else
                            throw new Throwable("Wild message in alert appeared: " + alertText);
                    }
                    findElementByName("gameIframe").waitUntil(Condition.exist, 10000);
                    switchToIframe("gameIframe");
                    try {
                        if ($(By.tagName("body")).getText().toLowerCase().contains("error"))
                            throw new Throwable("Game Iframe got an error ");
                    } catch (ElementNotFound e) { //некоторые игры не находятся по тэгу бади, только через JS
                        if ((executeJavaScript("return document.body.textContent;")) == null)
                            ;//do nothing
                        else if (((String) executeJavaScript("return document.body.textContent;")).toLowerCase().contains("error"))
                            throw new Throwable("Game Iframe got an error ");
                    }
                    log.info("SUCCESS , GAME ID: " + gameIDFromUrl + " on tab: " + tabName + ", section № " + i + "\n");
                    switchToIframe("defaultContent");
                    pressButton("closeButton");
                } catch (Throwable e) {
                    String message = "FAILURE!(didn't open in 10 seconds or got an error) GAME ID: " + gameIDFromUrl + ", GAME SUPPLIER: " + gameSupplierFromUrl + " on tab: " + tabName + ", section № " + i + "\n" + "Exception: " + e + "\n";
                    log.error(message);
                    errorCollector.add(message);
                    switchToIframe("defaultContent");
                    if (!e.toString().contains("alert"))//если нажали ОК на алерте , то кнопку закрыть нажимать не надо
                        pressButton("closeButton");
                } finally {
                    if ((k + 1) % quantityOfGamesInColumn == 0 && k > quantityOfGamesInColumn - 1 && nextColumnClicks < maximumTimesOfClickingNextSlideButton && listOfNextSlideButtons.get(i - 1).isEnabled()) {//если тест на последней игре в столбце
                        nextColumnClicks++; //двигается после прохождения второго столбца ,если play будет близко к краю то возникают проблемы
                        listOfNextSlideButtons.get(i - 1).scrollTo();
                        executeJavaScript("window.scrollBy(0,-150)");
                        listOfNextSlideButtons.get(i - 1).click();
                    }
                }
            }
            scrollToTop();
        }
        printErrorCollectorAndFailTestIfItIsNotEmpty(errorCollector, "CHECK GAMES TEST");
    }

    @Тогда("^пользователь расширяет окно на весь экран$")
    public void maximizeWindow() {
        getWebDriver().manage().window().maximize();
        log.info("maximized window");
    }

    @И("^пользователь нажимает на проблемную кнопку \"([^\"]*)\"$")
    public void clickOnProblemButton(String elName) throws Throwable { //STILL CANNOT CLICK BY ANY METHOD , FORCING TO REFRESH PAGE WON'T HELP
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
//        int x = getWebDriver().manage().window().getSize().width / 2;
//        int y = getWebDriver().manage().window().getSize().height;
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 50);
        SelenideElement el = $(findElementByName(elName));
        new Actions(getWebDriver()).moveToElement(el).moveByOffset(10, 10).click().perform();
        //el.click();
        //refreshPage();
        //refreshPage();
        //for (int i = y * 3 / 4; i < y; i++) {
        //jse.executeScript("$(document.elementFromPoint(" +  el.getLocation().x + ", " +  el.getLocation().y + ")).click();");
        //}
        log.info("clicked on : " + elName);

    }


    //вернет null если нет ошибок, стринг с ошибкой если есть
    private static String checkURL(String URL) throws Exception {
        int responseCode = returnCodeFromHref(URL);
        String thisLink = URL.substring(8, 16);
        if (responseCode == 451) {
            log.warn("WARNING: " + URL + " BLOCKED FOR THIS COUNTRY (451)");
            //return ("BLOCKED: " + URL + " BLOCKED FOR THIS COUNTRY (451)" + "\n");
            return null;
        } else if (responseCode == -1 || responseCode / 100 == 4) {
            log.error(URL + " responsed with " + responseCode + "\n");
            return ("ERROR: " + URL + " responsed with " + responseCode + "\n");
        } else if (URL.contains("www") || URL.contains("ffi") || URL.contains("sec")) {
            log.info(URL + " responsed with " + responseCode);
            return null;
        } else if (!thisLink.contains(StepImplementation.href.substring(8, 16))) {
            log.error(URL + "!!!!!!!!!!!!!!!! NOT FOR THIS ENVIRONMENT !!!!!!!!!! " + responseCode);
            return ("ERROR: " + URL + " responsed with(!!!!!!!!!! NOT FOR THIS ENVIRONMENT !!!!!!!!!!) " + responseCode + "\n");
        } else {
            log.info(URL + " responsed with " + responseCode);
            return null;
        }
    }

    private static void printErrorCollectorAndFailTestIfItIsNotEmpty(ArrayList<String> errorCollector, String testName) {
        if (errorCollector.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (String errText : errorCollector) {
                //System.out.println(errText);
                sb.append(errText);
            }
            log.error(testName + " CAUSED FAILURES");
            fail(testName + " CAUSED FAILURES : \n" + sb);
        } else {
            log.info(testName + " SUCCESSFUL");
        }
    }


    private static int returnCodeFromHref(String href) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        String userAgent = js.executeScript("return navigator.userAgent").toString();
        URL url = new URL(href);
        if (href.startsWith("https")) {
            HttpsURLConnection.setFollowRedirects(false);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try {
                connection.setConnectTimeout(3000);
                connection.addRequestProperty("User-Agent", userAgent);
                connection.connect();
                int response = connection.getResponseCode();
                connection.disconnect();
                return response;
            } catch (Exception exp) {
                //System.out.println(exp+"        -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                return -1;
            } finally {
                HttpsURLConnection.setFollowRedirects(true);
            }
        } else {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {
                connection.setConnectTimeout(3000);
                connection.addRequestProperty("User-Agent", userAgent);
                connection.connect();
                int response = connection.getResponseCode();
                connection.disconnect();
                return response;
            } catch (Exception exp) {
                return -1;
            } finally {
                HttpsURLConnection.setFollowRedirects(true);
            }
        }
    }

    protected String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@testrandommail.test";
        return saltStr;
    }

    protected String getRandomNumber() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    private boolean isAlertPresent() {
        try {
            getWebDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
/*    @Then("^In list \"([^\"]*)\" option is chosen \"([^\"]*)\"$")
    public void chooseOptionInDropDownList(String listName, String value) throws Exception {
        findElementsByName(listName)
                .stream()
                .filter(el -> el.getText().contains(value))
                .forEach(el -> el.click());
        log.info("in list " + listName + " option is chosen " + value);
    }*/


