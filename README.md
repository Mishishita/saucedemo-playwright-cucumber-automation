# Automatización Frontend - SauceDemo

Proyecto de automatización de pruebas para la aplicación web **SauceDemo**, desarrollado como parte del challenge técnico de QA Automation.

## Objetivo

Automatizar los principales flujos funcionales de SauceDemo utilizando **Playwright + Cucumber**, aplicando **Gherkin** para la definición de escenarios y el patrón **Page Object Model (POM)** para organizar la automatización.

## Tecnologías utilizadas

- Java 21
- Playwright 1.63.0
- Cucumber 7.34.8
- JUnit 6.1.3
- Maven
- Gherkin
- Page Object Model (POM)

## Estructura del proyecto

```text
challengue-playright-cucumber-sauce-frontEnd/
│
├── pom.xml
├── README.md
│
└── src/
    └── test/
        ├── java/
        │   └── com.mts/
        │       ├── pages/
        │       │   ├── LoginPage.java
        │       │   ├── ProductPage.java
        │       │   ├── CheckoutPage.java
        │       │   ├── CheckoutOverviewPage.java
        │       │   └── CompletePage.java
        │       │
        │       ├── runner/
        │       │   └── RunCucumberTest.java
        │       │
        │       ├── steps/
        │       │   ├── LoginSteps.java
        │       │   └── ProductSteps.java
        │       │
        │       └── support/
        │           └── CucumberHooks.java
        │
        └── resources/
            └── features/
                ├── login.feature
                └── product.feature
```

## Patrón de diseño

El proyecto utiliza principalmente el patrón **Page Object Model (POM)**.

Cada Page Object encapsula los locators y las acciones correspondientes a una página o etapa del flujo de la aplicación.

Los Step Definitions se encargan de orquestar el comportamiento definido en los escenarios Gherkin.

La interacción se organiza de la siguiente manera:

```text
Feature
   ↓
Step Definitions
   ↓
Page Objects
   ↓
Playwright
   ↓
SauceDemo
```

### Page Objects utilizados

- `LoginPage`: login y validación del usuario bloqueado.
- `ProductPage`: productos, agregar producto al carrito y acceso al carrito.
- `CheckoutPage`: ingreso de información del comprador y continuación del checkout.
- `CheckoutOverviewPage`: finalización de la compra.
- `CompletePage`: validación de la confirmación de compra.

### Cucumber Hooks

`CucumberHooks` administra el ciclo de vida de Playwright:

- Creación de Playwright.
- Lanzamiento del navegador Chromium.
- Creación del Browser Context.
- Creación de la Page.
- Cierre de los recursos después de cada escenario.

## Escenarios automatizados

| ID | Escenario |
|---|---|
| TC01 | Login exitoso con usuario estándar |
| TC02 | Login fallido con usuario bloqueado |
| TC03 | Agregar un producto al carrito |
| TC04 | Ver producto agregado en el carrito |
| TC05 | Completar una compra hasta la confirmación |

Cada escenario está identificado mediante un tag:

```text
@TC01
@TC02
@TC03
@TC04
@TC05
```

## Credenciales utilizadas

Para el challenge se utilizan las credenciales proporcionadas:

```text
standard_user / secret_sauce
locked_out_user / secret_sauce
```

## Ejecución del proyecto

### Requisitos previos

Tener instalado:

- Java 21
- Maven

Verificar las versiones:

```powershell
java -version
mvn -version
```

### Ejecutar toda la suite

Desde la raíz del proyecto:

```powershell
mvn clean test
```

### Ejecutar un escenario específico

Cada escenario puede ejecutarse individualmente utilizando su tag.

En PowerShell, utilizar el parámetro `-D` entre comillas:

```powershell
mvn clean test "-Dcucumber.filter.tags=@TC03"
```

Por ejemplo, para ejecutar el flujo completo de compra:

```powershell
mvn clean test 
```

## Resultado de las pruebas

Los escenarios TC03 y TC05 fueron ejecutados individualmente mediante sus respectivos tags y finalizaron correctamente con `BUILD SUCCESS`.

Para la entrega final, se debe ejecutar nuevamente la suite completa:

```powershell
mvn clean test
```

y verificar que finalice con:

```text
Tests run: 5
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Consideraciones

Durante el desarrollo, el navegador Chromium se configuró en modo visible (`headless=false`) para poder observar la ejecución de las pruebas.

También se utilizó `slowMo` durante la etapa de desarrollo para facilitar la depuración visual. Esta configuración puede reducirse o eliminarse para una ejecución de CI/CD.

## Estrategia de automatización y patrones utilizados

La estrategia de automatización combina Cucumber y Playwright, utilizando
Gherkin para definir los escenarios de negocio y Java para implementar
las pruebas automatizadas.

### Patrones y principios utilizados

**1. Page Object Model (POM)**

Se utiliza el patrón Page Object Model para encapsular los elementos
(locators) y las acciones correspondientes a cada página de SauceDemo.

Los Page Objects implementados son:

- LoginPage
- ProductPage
- CheckoutPage
- CheckoutOverviewPage
- CompletePage

Esto permite separar la interacción con la interfaz de la lógica de los
escenarios y facilita el mantenimiento de los locators.

**2. Separation of Concerns**

Se aplica una separación de responsabilidades entre los diferentes
componentes de la automatización:

- Feature Files: describen los escenarios en lenguaje Gherkin.
- Step Definitions: traducen los pasos Gherkin a acciones ejecutables.
- Page Objects: encapsulan la interacción con la interfaz.
- Cucumber Hooks: administran el ciclo de vida de Playwright.

La estructura resultante es:
```text
Feature
   ↓
Step Definitions
   ↓
Page Objects
   ↓
Playwright
   ↓
SauceDemo
```