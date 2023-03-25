Feature: Eliminar publicación
  yo como administrador de la API Placeholder
  quiero poder eliminar publicaciones del blog
  para mantener el blog actualizado

  Background:
    Given que el administrador conoce el id de una publicacion

  Scenario: Eliminacion exitosa
    When envia una solicitud con un id de publicacion correcto
    Then debera recibir una respuesta con un codigo de estado 200

  Scenario: Eliminacion fallida
    When envia una solicitud con un id de publicacion incorrecto
    Then debera recibir una respuesta con codigo de estado 404