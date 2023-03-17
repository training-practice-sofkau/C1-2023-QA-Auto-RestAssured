Feature: Crear usuario en reqres.in
  Yo como usuario
  Quiero enviar peticiones al servicio de reqres.in
  Para poder crear un usuario

  Scenario: Creacion exitosa de usuario
    Given tengo la informacion del usuario
    When la envio en una peticion POST a api users
    Then debo obtener una respuesta positiva con los demas datos de creacion

  Scenario: Creacion sin nombre de usuario
    Given Tengo la informacion incompleta del usuario
    When la envio en una peticion POST a api users con la informacion incompleta
    Then debo obtener un mensaje de error
