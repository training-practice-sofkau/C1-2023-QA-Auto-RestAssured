Feature: Login Usuario
  yo como usuario
  quiero enviar una peticion de logeo
  para poder loguearme en la plataforma

  Scenario: Login exitoso
    Given tengo credenciales para loguearme
    When envio las credenciales
    Then debo obtener un token de inicio de sesion

  Scenario: Login Fallido
    Given tengo unas credenciales falsas para loguearme
    When envio las credenciales falsas
    Then debo obtener un error al loguearme

  Scenario: Login vacio
    Given no tengo credenciales
    When envio una peticion vacia
    Then debo obtener un error logueandome
