Feature: servicio de posts
  yo como Administrador
  quiero enviar peticiones
  para poder modificar los posts

  Scenario: eliminacion  exitosa del post 1
    Given que tengo la url del post a eliminar
    When  envio  una peticion de tipo delete a la url del recurso
    Then debo obtener una respuesta que debe tener un codigo de estado 200

  Scenario: actualizacion exitosa del post 2
    Given que tengo la url del post a actualizar
    And tengo la informacion actualizada del recurso
    When  envio  una peticion de tipo put a la url del recurso
    Then debo obtener una respuesta con un codigo de estado 200

