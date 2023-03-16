Feature: ver la informacion de un post
  yo como administrador que usa los servicios rest
  quiero enviar peticiones
  para ver la informacion de un post registrado

  Scenario: ver informacion exitosa
    Given estoy apuntando con un endpoint a la api3
    When envio la peticion get mediante el endpoint2
    Then obtengo una respuesta ok3