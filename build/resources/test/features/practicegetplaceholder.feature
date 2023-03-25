Feature: Listar Publicación
  yo como administrador de la API json Placeholder
  quiero obtener una publicación por su id
  para poder vizualizar la información del publicación

  Background:
    Given que el administrador tiene el id de una publicacion

  Scenario: Listado Exitoso
    When hace una peticion con el id correcto
    Then debera recibir una respuesta con la informacion de la publicacion y codigo de estado 200

  Scenario: Listado Fallido
    When hace una peticion con el id incorrecto
    Then debera recibir una respuesta codigo de estado 404