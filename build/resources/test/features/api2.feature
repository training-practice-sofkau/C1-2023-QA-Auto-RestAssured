Feature: Mostrar color especifico
  yo como administrador de la API Reqres
  quiero obtener un color en especifico
  para poder listar las propiedades de un color

  Scenario: Obtener datos de un color
    Given que el administrador quiere obtener informacion de un color especifico
    When envia solicitud valida
    Then debera recibir las propiedades que contiene un color

  Scenario: Verificar mensaje de error
    Given que el administrador quiere tener informacion de un color en especifico
    When envia solicitud invalida en la ruta
    Then debera recibir respuesta invalida