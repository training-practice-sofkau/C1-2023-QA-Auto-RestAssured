Feature: Loguear usuario
  yo como usuario de reqres
  quiero loguearme en  la pagina web
  para poder ingresar a la suit principal

  Scenario: login exitoso
    Given que realizo una solicitud para loguearme
    When la solicitud es exitosa
    Then debera mostrar un tocken

  Scenario: logueo con email invalido
    Given que ingreso una solicitud para loguearme
    When la solicitud no es exitosa
    Then debera mostrar un mensaje de error de usuario no encontrado

  Scenario: logueo sin password
    Given que ingreso una solicitud para loguearme sin sin proporcionar mi password
    When la solicitud de login no es exitosa
    Then mostrara un mensaje de error indicando que password es requerida