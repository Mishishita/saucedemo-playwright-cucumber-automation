Feature: Login en Sauce Demo
@TC01
  Scenario: TC01 - Login exitoso con usuario estándar
    Given el usuario se encuentra en la página de login de Sauce Demo
    When inicia sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Then debería acceder a la página de productos
@TC02
  Scenario: TC02 - Login fallido con usuario bloqueado
    Given el usuario se encuentra en la página de login de Sauce Demo
    When inicia sesión con el usuario "locked_out_user" y contraseña "secret_sauce"
    Then debería visualizar un mensaje de usuario bloqueado