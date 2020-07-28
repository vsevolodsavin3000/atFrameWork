# new feature
# Tags: optional
# language: ru
@FuturitiRegistrationTest
Функция: Регистрация

  @InitRegistration
  @FuturitiRegistrationFullTest
  @FuturitiRegistrationShortTest
  Сценарий: Будущий игрок открывает форму регистрации
    Дано страница "Futuriti Start page" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Когда пользователь нажимает кнопку "Registration button"
    Тогда форма "futuritiRegistrationForm" открыта
      #TODO дополнить ошибочными сообщениями когда добавят разные классы для разных ошибок
  @FuturitiRegistrationFullTest
  Сценарий: закрыть и открыть форму регистрации и открыть условия пользования
    И на странице появляется "Registration form"
    Когда пользователь нажимает кнопку "Close button for registration form"
    Тогда элемент "Registration form" исчезает
    Когда страница "Futuriti Start page" открыта
    Тогда на странице появляется "Futuriti logo"
    Тогда пользователь нажимает кнопку "Registration button"
    И форма "futuritiRegistrationForm" открыта
    Когда пользователь нажимает кнопку "terms href"
    Тогда пользователь переходит на страницу 1
    И страница "Terms page" открыта
    И на странице появляется "terms of use text"
    Тогда пользователь закрывает страницу 1
    Когда пользователь переходит на страницу 0
    Тогда форма "futuritiRegistrationForm" открыта

  @FuturitiRegistrationFullTest
  Структура сценария:валидация ошибок в текстовых полях
    #Дано на странице появляется "Registration"
    Когда пользователь вводит "<text>" в поле "<field>"
    Тогда на странице появляется "<result>"
    Примеры:
      | text                                                  | field    | result                              |
      | asdasdas                                              | email    | not correct input message for email |
      | a                                                     | email    | not correct input message for email |
      | 123!@$%%$#%&%&&%)(                                    | email    | not correct input message for email |
      | a                                                     | password | errorMessagePasswordTooShort        |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | password | errorMessagePasswordTooLong         |
      | фъйёфъйёфъйё                                          | password | errorMessagePasswordInvalidChar     |

  @FuturitiRegistrationShortTest
  @FuturitiRegistrationFullTest
  Сценарий: пользователь вводит корректные данные и нажимает кнопку продолжить
    Когда пользователь вводит корректный сгенерированный "email" и "password"
    Тогда пользователь выбирает из следующих дропбоксов значения
      | birth day   | 01   |
      | birth month | 01   |
      | birth year  | 1990 |
      | country     | a    |

    К тому же пользователь нажимает чекбокс "terms checkbox"
    Когда пользователь заполняет следующие поля значениями
      | name    | correctName    |
      | surname | correctSurname |
    Тогда кнопка "continue" доступна
    И пользователь нажимает кнопку "continue"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"
    Когда пользователь нажимает кнопку "logout"
    Тогда элемент "user panel name" исчезает



