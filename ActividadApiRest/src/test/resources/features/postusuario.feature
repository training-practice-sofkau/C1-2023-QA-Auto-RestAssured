Feature: crear un usuario
  yo como administrador que usa los servicios rest
  quiero enviar peticiones
  para crear un usuario

  Scenario: creacion exitosa de usuario
    Given que creo la informacion del usuario
    When envio la peticion con la informacion
    Then obtengo una respuesta ok

  Scenario: creacion fallida
    Given que tengo la informacion del usuario1
    When envio la peticion con la informacion vacia
    Then obtengo una respuesta invalida

  Scenario: creacion fallida
    Given que tengo la informacion del usuario2
    When envio la peticion solo con la informacion del nombre
    Then obtengo una respuesta invalida1


