Feature: Creacion de un post
  Yo como usuario
  Quiero crear un nuevo post
  Para compartir información con otros usuarios

  Scenario: Creacion exitosa de un post
    Given tengo los datos del post a crear
    When envio una peticion para crear el post
    Then debo obtener una respuesta positiva con los datos del post creado

  Scenario: Creación de un post sin titulo
    Given tengo los datos incompletos del post a crear
    When envio una peticion para crear el post
    Then debo obtener una respuesta de error
