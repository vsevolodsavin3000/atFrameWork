# new feature
# Tags: optional
# language: ru

@FuturitiCheckGames
Функция: проверка работоспособности игр
  @LogIn
  @FuturitiCheckGamesInAllGamesSection
  Сценарий: успешный вход в систему существующим пользователем
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    К тому же кнопка "login button" недоступна
    И пользователь вводит "Qaswe333" в поле "password"
    Тогда пользователь вводит корректный логин для этого сайта
    Тогда кнопка "login button" доступна
    И пользователь нажимает кнопку "login button"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"
  @FuturitiCheckGamesInAllGamesSection
  Сценарий: проверка каждой игры в разделе all games
    Дано страница "Futuriti Start page" открыта
    Тогда пользователь нажимает кнопку "allGamesTab"
    К тому же форма "FuturitiGameInteractions" открыта
    #вместо playButton можно нажать demoButton
    К тому же игрок нажимает все кнопки "playButton" проверяя работоспособность игр в разделе allGames для футурити
