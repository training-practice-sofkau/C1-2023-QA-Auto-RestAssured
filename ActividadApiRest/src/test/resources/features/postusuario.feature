Feature: crear un usuario
  yo como administrador que usa los servicios rest
  quiero enviar peticiones
  para crear un usuario

  Scenario: creacion exitosa de usuario
    Given que creo la informacion del usuario
    When envio la peticion con la informacion
    Then obtengo una respuesta ok