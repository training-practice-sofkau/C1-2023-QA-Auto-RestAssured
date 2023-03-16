Feature: listar usuarios
  yo como administrador que usa los servicios rest
  quiero enviar peticiones
  para listar usuarios

  Scenario: lista de usuarios exitosa
    Given estoy apuntando con un endpoint a la api
    When envio la peticion get mediante el endpoint
    Then obtengo una respuesta ok1