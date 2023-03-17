Feature: Obtener lista de usuarios
  yo como administrador de la página JSON placeholder
  quiero ver los usuarios del sistema
  para poder hacer un censo

  Scenario: Lista recibida correctamente
    Given el administrador esta en la pagina
    When hace la peticion al servicio
    Then recibe un json con la lista de usuarios

  Scenario: Lista no recibida
    Given el administrador esta en la pagina
    When hace la peticion al servicio
    But le agrega un path con una palabra
    Then recibe un error de not found