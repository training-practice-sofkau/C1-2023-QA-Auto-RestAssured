Feature: Consultar comentarios
  yo como usuario
  quiero consultar los comentarios de un post
  para poder leerlos y obtener opiniones

  Scenario: Consulta comentarios de un post
    Given Tengo la id de un post
    When envio una peticion con la id del post
    Then debo obtener una respuesta con los comentarios de ese post

  Scenario: Consulta comentarios de un post inexistente
    Given Tengo la id de un post inexistente
    When envio una peticion con la id del post inexistente
    Then debo obtener un error debido al post inexistente



