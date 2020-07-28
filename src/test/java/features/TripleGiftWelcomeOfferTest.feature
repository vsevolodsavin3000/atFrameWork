# new feature
# Tags: optional
# language: ru
@TripleGiftWelcomeOffer
Функция: Регистрация нового юзера затем 3 раза вносится депозит и проверяется доступность оффера

  @RegistrationCloseOpenForm
  Сценарий: Будущий игрок открывает форму регистрации
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Когда пользователь нажимает кнопку "Registration button"
    Тогда форма "Registration" открыта
    И на странице появляется "Registration form"
    Когда пользователь нажимает кнопку "Close button for registration form"
    Тогда элемент "Registration form" исчезает
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "Futuriti logo"
    Тогда пользователь нажимает кнопку "Registration button"
    И форма "Registration" открыта
  @CorrectValues
  Сценарий: пользователь вводит корректные данные и нажимает кнопку продолжить
    Когда пользователь вводит корректный сгенерированный "email" и "password"
    Тогда пользователь выбирает из следующих дропбоксов значения
      | birth day   | 01   |
      | birth month | 01   |
      | birth year  | 1990 |
      | country     | austria    |

    К тому же пользователь нажимает чекбокс "terms checkbox"
    #И кнопка "continue" недоступна
    Когда пользователь нажимает кнопку "terms href"
    Тогда пользователь переходит на страницу 1
    И страница "Terms page" открыта
    И на странице появляется "terms of use text"
    Тогда пользователь закрывает страницу 1
    Когда пользователь переходит на страницу 0
    Тогда форма "Registration" открыта
    Когда пользователь заполняет следующие поля значениями
      | name    | correctName    |
      | surname | correctSurname |
    Тогда кнопка "continue" доступна
    И пользователь нажимает кнопку "continue"
    #К тому же форма "Header of second step" недоступна
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"

  Сценарий: пользователь делает депозит и получает трипл гифт оффер по сценарию
    #Дано форма "Futuriti header" открыта
    #Тогда пользователь нажимает кнопку "rewardsButton"
    И страница "Rewards page" открыта
    И на странице появляется "rewardsTable"
  Структура сценария: вносится 3 депозита, после каждого на один бонус доступно больше
    Когда пользователь нажимает элемент "10FS"
    Тогда на странице появляется "<button10>"
    И пользователь нажимает кнопку "closeRewardsButton"
    Когда пользователь нажимает элемент "15FS"
    Тогда на странице появляется "<button15>"
    И пользователь нажимает кнопку "closeRewardsButton"
    Когда пользователь нажимает элемент "20FS"
    Тогда на странице появляется "<button20>"
    И пользователь нажимает кнопку "closeRewardsButton"
    Тогда пользователь нажимает кнопку "depositButton"
    И форма "Cashier deposit form" открыта
    Тогда пользователь кликает на элемент "paymentMethods" № 0
    И пользователь вводит "20" в поле "paymentAmount"
    К тому же пользователь нажимает кнопку "nextButton"
    Тогда переключается на "paymentFrameDeposit"
    И пользователь ждет 5 секунд
    И переключается на "creditCardsFrame"
    Тогда на странице появляется "inputCardNameField"
    И пользователь заполняет следующие поля значениями
      |inputCardNameField      |wirecard           |
      |inputCardNumberField    |5413330300001006   |
      |expiryMonth             |01                 |
      |expiryYear              |23                 |
      |cvnNumber               |006                |
    Тогда пользователь нажимает кнопку "payButton"
    К тому же переключается на "paymentFrameDeposit"
    И пользователь вводит "wirecard" в поле "password"
    И пользователь нажимает кнопку "authenticate"
    Когда переключается на "defaultContent"
    И пользователь ждет 10 секунд
    Тогда страница "Rewards page" открыта
    И пользователь нажимает на проблемную кнопку "<okButtonAfterDeposit>"
    Примеры:
      |button10          |button15          |button20          |okButtonAfterDeposit|
      |payDepositButton  |payDepositButton  |payDepositButton  |closeAchievementButton|
      |bestSpinButton    |payDepositButton  |payDepositButton  |OKCloseWindow       |
      |bestSpinButton    |bestSpinButton    |payDepositButton  |OKCloseWindow       |
  Сценарий: Все фриспины доступны
    Когда пользователь нажимает элемент "10FS"
    Тогда на странице появляется "bestSpinButton"
    И пользователь нажимает кнопку "closeRewardsButton"
    Когда пользователь нажимает элемент "15FS"
    Тогда на странице появляется "bestSpinButton"
    И пользователь нажимает кнопку "closeRewardsButton"
    Когда пользователь нажимает элемент "20FS"
    Тогда на странице появляется "bestSpinButton"
    И пользователь нажимает кнопку "closeRewardsButton"

  Сценарий: логаут
    Когда пользователь нажимает кнопку "logout"
    Тогда элемент "user panel name" пропал