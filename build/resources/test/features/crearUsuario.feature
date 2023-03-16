Feature: Creacion de usuario
  Como administrador de la API Reqres
  Quiero crear un nuevo usuario
  Para poder visualizar el sistema


  Scenario: Creacion exitosa de un usuario
    Given que tengo el servicio de creacion de usuario
    And  ingreso el password  de usuario y correo
    When realizo la peticion de creacion de usuario
    Then el sistema debera mostrarme usuario creado


  Scenario: Crear un usuario sin password
    Given que tengo el servicio de crear usuario
    And ingreso la informacion del usuario sin password y con correo
    When envio la solicitud de creacion de usuario sin el nombre
    Then el sistema debe responder error al crear usuario sin password


  Scenario: Crear un usuario sin correo
    Given que tengo el servicio para crear un usuario
    And ingreso el  password de usuario  sin correo
    When envio la solicitud de creacion de usuario sin el correo
    Then el sistema debe responder error al crear usuario sin el correo

