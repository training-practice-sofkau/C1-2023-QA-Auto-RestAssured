
Feature: Registrar usuario con Reqres API
  Yo como administrador de la API
  Quiero registrar un usuario


  Scenario: Registrar Usuario con correo y clave validos
    Given Tengo un endpoint apuntando a la apiOne
    When Hago una solicitud POST con los datos validos en formato json
    Then Debo recibir una respuesta con codigo de estado exitoso1
    And  Debo visualizar un json con el id y token asignado

  Scenario: Registrar Usuario con correo invalido
    Given Tengo un endpoint apuntando a la apiTwo
    When Hago una solicitud POST con correo invalido en formato json
    Then Debo recibir una respuesta con un codigo de estado_de error

  Scenario: Registrar Usuarios con datos vacios
    Given Tengo un endpoint apuntando a la apiThree
    When Hago una solicitud POST con los datos vacios
    Then Debo recibir una respuesta con status code indicando un error

