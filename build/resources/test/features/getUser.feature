Feature: Obtener usuarios
  Como administrador de la API de ReqRes
  Quiero obtener una lista de usuarios
  Para poder visualizar los usuarios existentes

  Scenario: Obtener usuarios exitosamente
    Given que realizo una solicitud para obtener una lista de usuarios
    When la solicitud es exitosa
    Then debe mostrar como respuesta una lista que contiene los usuarios
