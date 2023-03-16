Feature: Login de usuario
  yo como Administrador
  quiero enviar peticiones
  para poder loggear un usuario

  Scenario: Login exitoso
    Given tengo la informacion del usuario
    When envio esa informacion en una peticion
    Then debo obtener una respuesta con un token

  Scenario: Login fallido
    Given tengo la informacion incompleta del usuario
    When la envio en una peticion
    Then debo obtener una respuesta de un dato de usuario faltante
