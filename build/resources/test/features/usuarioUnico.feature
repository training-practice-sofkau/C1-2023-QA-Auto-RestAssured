Feature: usuario unico
  Como administrador de la API Reqres
  Quiero obtener un unico usuario
  Para poder visualizar el usuario

  Scenario: consulta exitosa de un usuario
    Given me encuentro en la pagina regres
    When realizo la peticion de consulta
    Then el sistema deberia de mostrarme el usuario


  Scenario: consulta fallida de un usuario
    Given me encuentro en la pagina de consulta
    When realizo la peticion de consulta de un usuario que no existe
    Then el sistema deberia de mostrarme usuario no encontrado


