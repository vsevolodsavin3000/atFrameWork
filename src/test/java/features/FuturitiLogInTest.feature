# new feature
# Tags: optional
# language: ru

@FullLogIn
Функция: Существующий игрок входит в систему проверяя негативные сценарии

  @LogIn
  Сценарий: Валидируются все возможные негативые сценарии
    Когда страница "Futuriti Start page" открыта
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    К тому же кнопка "login button" недоступна
    Когда пользователь нажимает кнопку "close button"
    Тогда кнопка "close button" исчезает
    Когда страница "Futuriti Start page" открыта
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    #TODO добавить различные ошибки когда сделают разный класс
  @ErrorsValidationInLogInFields
  Структура сценария: валидация ошибок в текстовых полях формы входа
    Дано на странице появляется "Login form"
    Когда пользователь вводит "<text>" в поле "<field>"
    Тогда на странице появляется "<result>"
    Примеры:
      | text                                                  | field    | result                                 |
 # |a                                                    |login       |not correct input message for login       |
 # |Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa|login       |not correct input message for login       |
 # |123!@$%%$#%&%&&%)(*^                                 |login       |not correct input message for login       |
 # |кириллица                                            |login       |not correct input message for login       |
      | a                                                     | password | not correct input message for password |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | password | not correct input message for password |
      | кириллица                                             | password | not correct input message for password |

  @EmptyFieldsErrorValidation
  Сценарий: пользователь очищает поля и получает сообщение о необходимости их заполнения
    Когда пользователь очищает поле "password"
    Тогда на странице появляется "not correct input message for password"
    К тому же пользователь очищает поле "login"
  #Тогда на странице появляется "not correct input message for login"
  @PasswordReset
  Сценарий: валидация ошибок в форме сброса пароля
    Дано на странице появляется "Login form"
    Тогда пользователь нажимает кнопку "forgot password"
    И форма "forgot password form" открыта
    К тому же на странице появляется "login"
    Когда пользователь нажимает кнопку "close button"
    Тогда поле "login" исчезает
    И страница "Futuriti Start page" открыта
    Когда пользователь нажимает кнопку "login"
    Тогда форма "Login page" открыта
    Когда пользователь нажимает кнопку "forgot password"
    Тогда форма "forgot password form" открыта
    К тому же на странице появляется "login"

  @PasswordResetFormErrorsValidation
  Структура сценария: страница сброса пароля - пользователь вводит некорректные значения и страница пишет ошибки
    Дано на странице появляется "login"
    Когда пользователь вводит "<text>" в поле "login"
    И пользователь нажимает кнопку "submit button"
    Тогда на странице появляется "<result>"
    Примеры:
      | text                                                  | result                              |
      | a                                                     | not correct input message for login |
      | Asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa | not correct input message for login |
      | кириллица                                             | not correct input message for login |
      | 123!$%%$#%&%&&%)(*^                                   | not correct input message for login |
  #@PasswordResetEmptyFieldErrorValidation
  #  Сценарий: проверка появления ошибки при очищении поля
  #Когда пользователь очищает поле "login"
  #Тогда на странице появляется "not correct input message for login"
  #И кнопка "submit button" недоступна
  @PasswordReset
  Сценарий: страница сброса пароля - пользователь вводит правильный логин, которые существует в системе и нажимает submit
    Дано на странице появляется "login"
    Тогда пользователь вводит корректный логин для этого сайта
  #И кнопка "submit button" доступна
    К тому же пользователь нажимает кнопку "submit button"
    Когда форма "notification password reset" открыта
    Тогда на странице появляется "notification form"
    Когда пользователь нажимает кнопку "close button"
    Тогда форма "notification form" исчезает

  @LogIn
  Сценарий: успешный вход в систему существующим пользователем
    Когда страница "Futuriti Start page" открыта
    Тогда пользователь нажимает кнопку "login"
    И форма "Login page" открыта
    К тому же кнопка "login button" недоступна
    Тогда пользователь вводит корректный логин для этого сайта
    И пользователь вводит "Qaswe333" в поле "password"
    Тогда кнопка "login button" доступна
    И пользователь нажимает кнопку "login button"
    Тогда страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"

  @LogOut
  Сценарий: пользователь выходит из системы
    Дано страница "Futuriti Start page" открыта
    И на странице появляется "user panel name"
    Когда пользователь нажимает кнопку "logout"
    Тогда форма "user panel name" исчезает
  

