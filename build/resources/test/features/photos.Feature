Feature: Obtener fotos de usuario único
  Como administrador de la API Reqres
  Quiero obtener fotos de un usuario
  Para poder visualizar las fotos del usuario

  Scenario: consulta exitosa de fotos de usuario
    Given que me encuentro en la servicio de Reqres
    When realizo una peticion para obtener las fotos del usuario con id valido
    Then el sistema debe mostrarme las fotos del usuario

  Scenario: consulta fallida de fotos de usuario
    Given que tengo el servicio de Reqres
    When realizo una peticion para obtener las fotos del usuario con id invalido
    Then el sistema debe mostrarme un mensaje de usuario invalido