# new feature
# Tags: optional
# language: ru
@WelcomeOfferDepositWithdrawalTest
Функция: Регистрация нового юзера затем проверка wo с депозитом и снятием средств

  @InitRegistration
  Сценарий: Будущий игрок регистрируется
    Дано страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Когда пользователь нажимает кнопку "Registration button"
    Тогда форма "Registration" открыта
    И на странице появляется "Registration form"
    Когда пользователь вводит корректный сгенерированный "email" и "password"
    Тогда пользователь выбирает из следующих дропбоксов значения
      | birth day   | 01   |
      | birth month | 01   |
      | birth year  | 1990 |
      | country     | austria    |
    К тому же пользователь нажимает чекбокс "terms checkbox"
    И пользователь заполняет следующие поля значениями
      | name    | correctName    |
      | surname | correctSurname |
    Тогда кнопка "continue" доступна
    И пользователь нажимает кнопку "continue"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"

  Сценарий: пользователь переходит на страницу с наградами и проверяет что
    Дано страница "Rewards page" открыта
    Тогда на странице появляется "rewardsTable"
    И пользователь нажимает элемент "imageOfFirstReward"
    Тогда на странице появляется "rewardDescriptionForm"
    И пользователь нажимает кнопку "payDepositButton"

  Сценарий: логаут
    Когда пользователь нажимает кнопку "logout"
    Тогда элемент "user panel name" пропал



    #  Структура сценария: вносится 3 депозита, после каждого на один бонус доступно больше
#    Когда пользователь нажимает элемент "10FS"
#    Тогда на странице появляется "<button10>"
#    И пользователь нажимает кнопку "closeRewardsButton"
#    Когда пользователь нажимает элемент "15FS"
#    Тогда на странице появляется "<button15>"
#    И пользователь нажимает кнопку "closeRewardsButton"
#    Когда пользователь нажимает элемент "20FS"
#    Тогда на странице появляется "<button20>"
#    И пользователь нажимает кнопку "closeRewardsButton"
#    Тогда пользователь нажимает кнопку "depositButton"
#    И форма "Cashier deposit form" открыта
#    Тогда пользователь кликает на элемент "paymentMethods" № 0
#    И пользователь вводит "20" в поле "paymentAmount"
#    К тому же пользователь нажимает кнопку "nextButton"
#    Тогда переключается на "paymentFrameDeposit"
#    И пользователь ждет 5 секунд
#    И переключается на "creditCardsFrame"
#    Тогда на странице появляется "inputCardNameField"
#    И пользователь заполняет следующие поля значениями
#      |inputCardNameField      |wirecard           |
#      |inputCardNumberField    |5413330300001006   |
#      |expiryMonth             |01                 |
#      |expiryYear              |23                 |
#      |cvnNumber               |006                |
#    Тогда пользователь нажимает кнопку "payButton"
#    К тому же переключается на "paymentFrameDeposit"
#    И пользователь вводит "wirecard" в поле "password"
#    И пользователь нажимает кнопку "authenticate"
#    Когда переключается на "defaultContent"
#    И пользователь ждет 10 секунд
#    Тогда страница "Rewards page" открыта
#    И пользователь нажимает на проблемную кнопку "<okButtonAfterDeposit>"
#    Примеры:
#      |button10          |button15          |button20          |okButtonAfterDeposit|
#      |payDepositButton  |payDepositButton  |payDepositButton  |closeAchievementButton|
#      |bestSpinButton    |payDepositButton  |payDepositButton  |OKCloseWindow       |
#      |bestSpinButton    |bestSpinButton    |payDepositButton  |OKCloseWindow       |
#  Сценарий: Все фриспины доступны
#    Когда пользователь нажимает элемент "10FS"
#    Тогда на странице появляется "bestSpinButton"
#    И пользователь нажимает кнопку "closeRewardsButton"
#    Когда пользователь нажимает элемент "15FS"
#    Тогда на странице появляется "bestSpinButton"
#    И пользователь нажимает кнопку "closeRewardsButton"
#    Когда пользователь нажимает элемент "20FS"
#    Тогда на странице появляется "bestSpinButton"
#    И пользователь нажимает кнопку "closeRewardsButton"
