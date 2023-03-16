Feature: usuario unico
  Como administrador de la API Reqres
  Quiero obtener un unico usuario
  Para poder visualizar el usuario

  Scenario: consulta exitosa de un usuario
    Given me encuentro en la pagina
    When realizo la peticion de consulta
    Then el sistema deberia de mostrarme el usuario