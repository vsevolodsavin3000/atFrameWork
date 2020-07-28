# new feature
# Tags: optional
# language: ru

@HrefsFullTest
Функция: работоспособность всех ссылок после логина
#делится на 3 этапа: проверка ссылок пользователем с наличием средств, незалогиненным, пользователем без средств

  @LogIn
  Сценарий: пользователь входит в систему
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    К тому же кнопка "login button" недоступна
    Тогда пользователь вводит "nomoneytest@mail.ru" в поле "login"
    И пользователь вводит "Qaswe333" в поле "password"
    Тогда кнопка "login button" доступна
    И пользователь нажимает кнопку "login button"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"

  Сценарий: проверка ссылок на начальной странице
    Тогда пользователь проверяет работоспособность всех ссылок на странице
    #И проверяет ссылки во всех баннерах "slickSliderButtons" кликая по "slider"

  Структура сценария: пользователь переходит по страницам и на них проверяет работоспособность ссылок
    Когда форма "<form>" открыта
    Тогда пользователь нажимает кнопку "<button>"
    К тому же страница "<page>" открыта
    И на странице появляется "<element>"
    Тогда пользователь проверяет работоспособность всех ссылок на странице
    Примеры:
      | form            | button                   | page                    | element              |
      | Futuriti header | user panel name          | User panel page         | accountInfo          |
      | User panel page | accountSettingsButton    | User panel page         | profileSettings      |
      | User panel page | transactionsButton       | User panel page         | transactionsForm     |
      | Futuriti header | rewardsButton            | Rewards page            | rewardsTable         |
      | Futuriti header | bonusesButton            | Bonuses page            | promo list container |
      | Futuriti header | pointsButton             | Points page             | achievements wrapper |
      | Futuriti header | faqButton                | Faq page                | last table           |
      | Footer menu     | responsibleGamingButton  | Responsible gaming page | static page          |
      | Footer menu     | aboutButton              | About page              | static about page    |
      | Footer menu     | termsAndConditionsButton | Terms page              | terms of use text    |
      | Footer menu     | privacyPolicyButton      | Privacy policy page     | static privacy page  |

  Сценарий: переход на страницу с бонусами и проверка всех баннеров
    Дано форма "Futuriti header" открыта
    Тогда пользователь нажимает кнопку "bonusesButton"
    И страница "Bonuses page" открыта
    К тому же на странице появляется "promo list container"
    Тогда прожимаются все баннеры с нажатием кнопки в форме при наличии

##ниже вносятся баннеры, при открытии которых, есть кнопка ведущая в другой раздел
#  Структура сценария: проверка ссылки в баннерах с кнопками на странице с бонусами
#    Когда страница "Bonuses page" открыта
#    И на странице появляется "promo list container"
#    И пользователь кликает на элемент "banners" № <bannerNo>
#    Тогда кнопка "button" доступна
#    И пользователь нажимает кнопку "button"
#    Тогда страница "<page>" открыта
#    И на странице появляется "<element>"
#    Тогда пользователь возвращается назад
#    Примеры:
#      | bannerNo | page                | element   |
#      | 0        | Futuriti Start page | tab items |
#      #| 1        | Cashier deposit form | depositTab |
##ниже вносятся баннеры, при открытии которых, форма не содержит кнопок
#  Структура сценария: баннеры открывают модальное окно
#    Дано обновляется страница
#    Когда страница "Bonuses page" открыта
#    И на странице появляется "promo list container"
#    И пользователь кликает на элемент "banners" № <bannerNo>
#    Тогда на странице появляется "promoModelTitle"
#    Примеры:
#      | bannerNo |
#      | 1        |
#      | 2        |
#      | 3        |

  Сценарий: пользователь идет на страницу faq и открывает все вкладки с ответами
    Дано обновляется страница
    Когда форма "Futuriti header" открыта
    Тогда пользователь нажимает кнопку "faqButton"
    К тому же страница "Faq page" открыта
    И на странице появляется "last table"
    Тогда пользователь открывает все вкладки "faq tabs"
    К тому же прокручивает страницу наверх

  Структура сценария: переход по открытым страницам и проверка наличия на них нужных элементов
    Дано закрываются все вкладки кроме первой
    И страница "Faq page" открыта
    Тогда пользователь кликает на элемент "faq tabs hrefs" № <hrefNo> открывая в новой вкладке
    И пользователь переходит на страницу 1
    И убеждается что адрес страницы корректный и не возвращает ошибок
    К тому же страница "<page>" открыта
    Тогда на странице появляется "<element>"
    Примеры:
      | hrefNo | page            | element               |
      | 0      | User panel page | accountSettingsButton |
      | 1      | Bonuses page    | promo list container  |

  Сценарий: пользователь закрывает лишние вкладки и переходит на страницу с наградами points
    Дано закрываются все вкладки кроме первой
    Тогда прокручивает страницу наверх
    И форма "Futuriti header" открыта
    И пользователь нажимает кнопку "pointsButton"
    Тогда страница "Points page" открыта
    И на странице появляется "achievements wrapper"
    Тогда форма "Futuriti header" открыта
    И пользователь нажимает кнопку "faqButton"
    И страница "Faq page" открыта
    К тому же на странице появляется "last table"

  Структура сценария: проверка окон и перехода в другие отделы при нажатии на награды
    Дано пользователь возвращается назад
    Тогда страница "Points page" открыта
    И на странице появляется "achievements wrapper"
    Тогда пользователь кликает на элемент "howToGetButton" № <number>
    К тому же на странице появляется "goToOtherPageButton"
    И пользователь нажимает кнопку "goToOtherPageButton"
    К тому же убеждается что адрес страницы корректный и не возвращает ошибок
    Тогда страница "<page>" открыта
    И на странице появляется "<element>"
    Примеры:
      | number | page                | element               |
      | 0      | Futuriti Start page | tab items             |
      | 1      | Futuriti Start page | tab items             |
      | 2      | Futuriti Start page | tab items             |
      | 3      | Futuriti Start page | tab items             |
      | 4      | Futuriti Start page | tab items             |
      | 5      | Futuriti Start page | tab items             |
      | 6      | Futuriti Start page | tab items             |
      | 11     | User panel page     | accountSettingsButton |
      | 13     | Futuriti Start page | tab items             |
      | 14     | Futuriti Start page | tab items             |

  Сценарий: вернуться назад на страницу наград
    Дано пользователь возвращается назад

  Структура сценария: пользователь открывает окно депозита через награды
    Дано страница "Points page" открыта
    Тогда на странице появляется "achievements wrapper"
    И пользователь кликает на элемент "howToGetButton" № <number>
    К тому же на странице появляется "goToOtherPageButton"
    И пользователь нажимает кнопку "goToOtherPageButton"
    К тому же страница "Cashier deposit form" открыта
    И на странице появляется "depositTab"
    И пользователь нажимает кнопку "closeButton"
    Тогда форма "depositTab" исчезает
    Примеры:
      | number |
      | 7      |
      | 8      |
      | 9      |
      | 10     |
      | 12     |

        #активная вкладка будет зеленого цвета:
    #Тогда элемент "depositTab" имеет цвет "#299a0b"
  #на 12-ом хорошо если б открывало вывод средств а не депозит

  @HrefsAfterLogOut
  Структура сценария: незалогиненный пользователь переходит по страницам и на них проверяет работоспособность ссылок
    Когда форма "<form>" открыта
    Тогда пользователь нажимает кнопку "<button>"
    К тому же страница "<page>" открыта
    И на странице появляется "<element>"
    Тогда пользователь проверяет работоспособность всех ссылок на странице
    Примеры:
      | form            | button                   | page                    | element              |
      | Futuriti header | bonusesButton            | Bonuses page            | promo list container |
      | Futuriti header | pointsButton             | Points page             | achievements wrapper |
      | Futuriti header | faqButton                | Faq page                | last table           |
      | Footer menu     | responsibleGamingButton  | Responsible gaming page | static page          |
      | Footer menu     | aboutButton              | About page              | static about page    |
      | Footer menu     | termsAndConditionsButton | Terms page              | terms of use text    |
      | Footer menu     | privacyPolicyButton      | Privacy policy page     | static privacy page  |
  
  Сценарий: проверка баннера ведущего к регистрации незалогиненным пользователем
    Дано форма "Futuriti header" открыта
    Тогда пользователь нажимает кнопку "bonusesButton"
    И страница "Bonuses page" открыта
    И на странице появляется "promo list container"
    Тогда пользователь кликает на элемент "banners" № 0
    И пользователь нажимает кнопку "button"
    И форма "Registration" открыта
    К тому же на странице появляется "Registration form"
    Тогда обновляется страница

  @LogIn
  Сценарий: вход в систему пользователем с наличием средств
    Дано страница "Futuriti Start page" открыта
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
    Тогда пользователь ждет 2 секунд

  Сценарий: проверка нажатия всех баннеров на начальной странице
    Дано на странице появляется "slider"
    Тогда пользователь кликает по всем элементам "slickSliderButtons"
