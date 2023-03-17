Feature: Obtener lista de usuarios
  Yo como usuario
  Quiero obtener una lista de usuarios
  Para poder ver la información de los usuarios registrados

  Scenario: Obtener lista de usuarios exitosamente
    Given que tengo acceso al servicio de Reqres
    When solicito la lista de usuarios
    Then obtengo una respuesta exitosa con una lista de usuarios

  Scenario: Obtener lista de usuarios con parámetros inválidos
    Given que tengo acceso al servicio de Reqres
    When solicito la lista de usuarios con un parametro invalido
    Then obtengo una respuesta de error
