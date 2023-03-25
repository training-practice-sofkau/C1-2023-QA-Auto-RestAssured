Feature: Loguear usuario
  yo como usuario de reqres
  quiero loguearme en  la pagina web
  para poder ingresar a la suit principal

  Scenario: login exitoso
    Given que realizo una solicitud para loguearme
    When envio la solicitud para loguearme
    Then debera mostrar un tocken

  Scenario: logueo con email invalido
    Given que ingreso una solicitud para loguearme
    When envio solicitud para loguearme con email invalido
    Then debera mostrar un mensaje de error de usuario no encontrado

  Scenario: logueo sin password
    Given que ingreso una solicitud para loguearme sin proporcionar mi password
    When envio la solicitud para loguearme sin password
    Then mostrara un mensaje de error indicando que password es requerida