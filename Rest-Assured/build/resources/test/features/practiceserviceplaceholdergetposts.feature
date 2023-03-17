Feature: Obtener lista de publicaciones
  yo como administrador de la página JSON placeholder
  quiero ver las publicaciones
  para poder hacer un analisis de tendencias

  Scenario: Lista recibida correctamente
    Given el administrador esta en la pagina
    When hace la peticion de posts al servicio place holder
    Then recibe un json con la lista de posts

  Scenario: Lista no recibida
    Given el administrador esta en la pagina
    When hace la peticion de posts al servicio place holder
    But le agrega un path con una palabra
    Then recibe un error de not found