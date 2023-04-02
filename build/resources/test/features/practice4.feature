Feature: Obtener lista de usuarios
  Yo como usuaria
  Quiero obtener una lista de recursos
  Para poder validar y verificar la informacion

  Scenario: Obtener lista de recursos exitosamente
    Given que tengo acceso al servicio de Reqres
    When envio una peticion de tipo GET para ver la lista de recursos
    Then obtengo una respuesta exitosa con una lista de recursos