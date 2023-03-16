@ValidacionRegistroAPI
Feature: Validacion de registro de usuario
  Yo como Admin de la pagina web reqres
  Quiero validar que los registros se den apropiadamente
  Para poder registrar nuevos usuarios

  Scenario: Registro exitoso de un usuario
    Given estoy en la pagina de registro
    When ingreso los datos de email y password
    Then se debe obtener un codigo de respuesta "200"
    And se debe obtener un token