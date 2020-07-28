# new feature
# Tags: optional
# language: ru

@LuckmeCheckGames
Функция: проверка работоспособности игр
  @LogIn
  @LuckmeCheckGamesInAllSections
  @LuckmeCheckGamesInAllGamesSection
  Сценарий: успешный вход в систему существующим пользователем
    Когда страница "LuckmeStartPage" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Тогда пользователь нажимает кнопку "login"
    И форма "LuckmeLogInForm" открыта
    К тому же кнопка "login button" недоступна
    И пользователь вводит "Qaswe333" в поле "password"
    Тогда пользователь вводит корректный логин для этого сайта
    К тому же кнопка "login button" доступна
    И пользователь нажимает кнопку "login button"
    Тогда страница "LuckmeStartPage" открыта
    И на странице появляется "user panel name"
  @LuckmeCheckGamesInAllSections
  Сценарий: проверка игр на основной вкладке ТОП
    Дано страница "LuckmeStartPage" открыта
    Тогда прокручивает страницу наверх
    И пользователь нажимает кнопку "topTab"
    К тому же форма "LuckmeGameInteractions" открыта
    И игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе "topTab" для лакми
  @LuckmeCheckGamesInAllSections
  Сценарий: проверка игр на вкладке ПОСТАВЩИКОВ
    #при нажатии на плэй каждая игра открывается или просит активировать флэш плеер
    Дано страница "LuckmeStartPage" открыта
    Тогда прокручивает страницу наверх
    И пользователь нажимает кнопку "providersTab"
    К тому же форма "LuckmeGameInteractions" открыта
    И игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе "providersTab" для лакми
  @LuckmeCheckGamesInAllSections
  Сценарий: проверка игр на вкладке ЖАНРОВ
    Дано страница "LuckmeStartPage" открыта
    Тогда прокручивает страницу наверх
    И пользователь нажимает кнопку "genresTab"
    К тому же форма "LuckmeGameInteractions" открыта
    И игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе "genresTab" для лакми
  @LuckmeCheckGamesInAllSections
  Сценарий: проверка игр на вкладке ДЖЕКПОТОВ
    Дано страница "LuckmeStartPage" открыта
    Тогда прокручивает страницу наверх
    И пользователь нажимает кнопку "jackpotTab"
    К тому же форма "LuckmeGameInteractions" открыта
    И игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе "jackpotTab" для лакми
  @LuckmeCheckGamesInAllGamesSection
  Сценарий: проверка игр на вкладке ВСЕХ ИГР
    Дано страница "LuckmeStartPage" открыта
    Тогда прокручивает страницу наверх
    И пользователь нажимает кнопку "allGamesTab"
    К тому же форма "LuckmeGameInteractions" открыта
    И игрок нажимает все кнопки плэй проверяя работоспособность игр в разделе "allGamesTab" для лакми