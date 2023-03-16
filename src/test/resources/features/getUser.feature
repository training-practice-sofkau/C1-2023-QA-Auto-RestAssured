Feature: Obtener usuarios
  Como administrador de la API de ReqRes
  Quiero obtener una lista de usuarios
  Para poder visualizar los usuarios existentes

  Scenario: Obtener usuarios exitosamente
    Given que realizo una solicitud para obtener una lista de usuarios
    When la solicitud es exitosa
    Then debe mostrar como respuesta una lista que contiene los usuarios

   Scenario Outline: Comprobar si se puede limitar el número de usuarios devueltos en la respuesta
    Given el admministrador esta en la API de ReqRes
    When realiza una solicitud para obtener de la lista una cantidad <cantidad> de usuarios
    Then debe mostrar como maximo una lista con una cantidad <cantidad> de usuarios

     Examples:
       | cantidad |
       |    1     |
       |    2     |
       |    3     |







