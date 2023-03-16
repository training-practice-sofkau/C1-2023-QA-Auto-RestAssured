
Feature: Listar Users de Reqres API
  Yo como administrador de la API
  Quiero listar los usuarios existentes


  Scenario: Listar Usuarios de una pagina existente
    Given Tengo un endpoint apuntando a la api1
    When Hago una solicitud GET con la pagina deseada mediante endpoint valido
    Then Debo recibir una respuesta con codigo de estado exitoso
    And  Debo visualizar un body con los users de la pagina ingresada

  Scenario: Listar Usuarios de una pagina inexistente
    Given Tengo un endpoint apuntando a la api2
    When Hago una solicitud GET con la pagina inexistente mediante endpoint valido
    Then Debo recibir una respuesta con un codigo de estado de error
    And  Debo visualizar un mensaje indicando la comparacion de lo esperado vs lo obtenido

  Scenario: Listar Usuarios con endpoint invalido
    Given Tengo un endpoint apuntando a la api3
    When Hago una solicitud GET mediante endpoint invalido
    Then Debo recibir una respuesta con status code indicando error
    And Debo visualizar un mensaje indicando la comparacion de lo esperado vs lo obtenido