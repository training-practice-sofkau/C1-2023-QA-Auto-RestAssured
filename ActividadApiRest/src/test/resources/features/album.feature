Feature: crear un album
  yo como administrador que usa los servicios rest
  quiero enviar peticiones
  para crear un album

  Scenario: creacion exitosa de album
    Given que creo la informacion del album
    When envio la peticion con toda la informacion
    Then obtengo una respuesta ok2