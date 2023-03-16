Feature: Crear usuario
  yo como Admin
  quiero enviar peticiones
  para poder crear un usuario

  Scenario: Creacion exitosa
    Given tengo la informacion del usuario
    When la envio en una peticion
    Then debo obtener una respuesta positiva con los demas datos de creacion

  Scenario: Creacion sin nombre
    Given Tengo la informacion incompleta
    When la envio en una peticion con la informacion incompleta
    Then debo obtener una respuesta de error

  Scenario: Creacion sin trabajo
    Given Tengo la informacion sin trabajo
    When la envio en una peticion sin trabajo
    Then debo obtener un error
