Feature: Gestión de productos en Sauce Demo
    @TC03
  Scenario: TC03 - Agregar un producto al carrito
    Given el usuario inicia sesión con "standard_user" y "secret_sauce"
    When agrega un producto al carrito
    Then el producto debería aparecer en el carrito
    @TC04
  Scenario: TC04 - Ver producto agregado en el carrito
    Given el usuario inicia sesión con "standard_user" y "secret_sauce"
    And agrega un producto al carrito
    When ingresa al carrito
    Then debería visualizar el producto en el carrito

    @TC05
  Scenario: TC05 - Completar una compra
    Given el usuario inicia sesión con "standard_user" y "secret_sauce"
    And agrega un producto al carrito
    And ingresa al carrito
    When inicia el proceso de checkout
    And completa la información de compra
    And continúa con el checkout
    Then debería visualizar la confirmación de compra