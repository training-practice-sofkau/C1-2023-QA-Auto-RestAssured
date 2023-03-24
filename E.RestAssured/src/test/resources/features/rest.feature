Feature: Loguear usuario
  yo como usuario de reqres
  quiero loguearme en  la pagina web
  para poder ingresar a la suit principal

  Scenario: login exitoso
    Given que realizo una solicitud para loguearme
    When la solicitud es exitosa
    Then debera mostrar un tocken