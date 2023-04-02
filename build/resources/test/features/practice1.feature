Feature: Login de usuario
  yo como Administrador
  quiero enviar peticiones
  para poder loggear un usuario

  Scenario: Login exitoso
    Given tengo la informacion del usuario
    When envio esa informacion en una peticion
    Then debo obtener una respuesta con un token

