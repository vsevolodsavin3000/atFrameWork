# new feature
# Tags: optional
# language: ru

@CheckGames
Функция: проверка работоспособности игр
  @LogIn
  Сценарий: успешный вход в систему существующим пользователем
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    К тому же кнопка "login button" недоступна
    Тогда пользователь вводит корректный логин для этого сайта
    И пользователь вводит "Qaswe333" в поле "password"
    Тогда кнопка "login button" доступна
    И пользователь нажимает кнопку "login button"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"
  Сценарий: при нажатии на плэй каждая игра открывается или просит активировать флэш плеер
    Дано страница "Futuriti Start page" открыта
    Тогда пользователь нажимает кнопку "AZ"
    К тому же форма "GameInteractions" открыта
    #Тогда игрок нажимает все кнопки "playButton" проверяя работоспособность игр
    К тому же игрок нажимает все кнопки "demoButton" проверяя работоспособность игр в разделе allGames для футурити
