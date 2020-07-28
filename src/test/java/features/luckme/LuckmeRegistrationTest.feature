# new feature
# Tags: optional
# language: ru
@LuckmeRegistrationTest
Функция: Регистрация

  @InitRegistration
  @LuckmeRegistrationFullTest
  @LuckmeRegistrationShortTest
  Сценарий: Будущий игрок открывает форму регистрации
    Дано страница "LuckmeStartPage" открыта
    Тогда на странице появляется "GDPR form"
    И пользователь нажимает кнопку "GDPR button"
    Когда пользователь нажимает кнопку "Registration button"
    Тогда форма "luckmeRegistrationForm" открыта
    И на странице появляется "registerForm"
      #TODO дополнить ошибочными сообщениями когда добавят разные классы для разных ошибок

  @LuckmeRegistrationFullTest
  Сценарий: закрыть и открыть форму регистрации и открыть условия пользования
    Дано пользователь нажимает кнопку "closeButton"
    Тогда элемент "registerForm" исчезает
    Когда страница "LuckmeStartPage" открыта
    Тогда пользователь нажимает кнопку "Registration button"
    И форма "luckmeRegistrationForm" открыта
    Когда пользователь нажимает кнопку "terms href"
    Тогда пользователь переходит на страницу 1
    И страница "Terms page" открыта
    И на странице появляется "terms of use text"
    Тогда пользователь закрывает страницу 1
    Когда пользователь переходит на страницу 0
    Тогда форма "luckmeRegistrationForm" открыта

  @LuckmeRegistrationFullTest
  Структура сценария:валидация ошибок в текстовых полях
    #Дано на странице появляется "Registration"
    Когда пользователь вводит "<text>" в поле "<field>"
    Тогда на странице появляется "<result>"
    Примеры:
      | text                                                  | field          | result                |
      | asdasdas                                              | emailField     | errorMessageEmail     |
      | a                                                     | emailField     | errorMessageEmail     |
      | 123!@$%%$#%&%&&%)(                                    | emailField     | errorMessageEmail     |
      | a                                                     | passwordField  | errorMessagePassword  |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | passwordField  | errorMessagePassword  |
      | фъйёфъйёфъйё                                          | passwordField  | errorMessagePassword  |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | firstNameField | errorMessageFirstName |
      | a                                                     | firstNameField | errorMessageFirstName |
      | 123!@$%%$#%&%&&%)(                                    | firstNameField | errorMessageFirstName |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | lastNameField  | errorMessageLastName  |
      | a                                                     | lastNameField  | errorMessageLastName  |
      | 123!@$%%$#%&%&&%)(                                    | lastNameField  | errorMessageLastName  |

  @LuckmeRegistrationFullTest
  @LuckmeRegistrationShortTest
  Сценарий: пользователь вводит корректные данные и нажимает кнопку продолжить
    Когда пользователь вводит корректный сгенерированный "emailField" и "passwordField"
    Тогда пользователь выбирает из следующих дропбоксов значения
      | birthDay   | 01   |
      | birthMonth | 01   |
      | birthYear  | 1990 |
      | country    | a    |
    К тому же пользователь нажимает чекбокс "terms checkbox"
    Когда пользователь заполняет следующие поля значениями
      | firstNameField | correctName    |
      | lastNameField  | correctSurname |
    Тогда кнопка "continueButton" доступна
    И пользователь нажимает кнопку "continueButton"
    Тогда страница "LuckmeStartPage" открыта
    И на странице появляется "user panel name"
    Когда пользователь нажимает кнопку "logout"
    Тогда элемент "user panel name" исчезает



