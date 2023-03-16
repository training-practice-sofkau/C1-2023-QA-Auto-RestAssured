Feature: Obtener lista de usuarios
  Como administrador de la API jsonplaceholder.typicode.com
  Quiero obtener una lista de usuarios con sus datos
  Para visualizar y administrar la información de los usuarios

  # Primer escenario: Obtener lista de usuarios con datos en la primera página
  Scenario: Obtener lista de usuarios en la primera página
    Given el administrador está en la página principal
    When envía una solicitud GET a la primera página
    Then la respuesta tiene un código de estado OK

  # Segundo escenario: Obtener lista de usuarios con datos en una página específica
  Scenario: Obtener lista de usuarios en una página específica
    Given el administrador está en la página principal
    When elige una página específica en donde envía una solicitud GET a la página específica
    Then la respuesta tiene un código de estado OK

