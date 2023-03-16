@ConsultaAPIReqres
Feature: Consulta de la información de base de datos mediante el servicio API
  Yo como Admin de la pagina web reqres
  Quiero validar la informacion presente en la base de datos
  Para realizar una gestion de los elementos

  Scenario: Consulta exitosa de informacion
    Given el usuario tiene acceso al servicio API de consulta de informacion
    When el usuario realiza una consulta con el id del registro "5"
    Then se devuelve la informacion asociada a ese registro
    And se devuelve un codigo de respuesta exitoso "200"

  Scenario: Respuesta correcta ante consulta invalida
    Given el usuario accede al servicio API de consulta de informacion
    When el usuario realiza una consulta con un id de registro no valido "32"
    Then se devuelve un mensaje de error indicando que la consulta es invalida


