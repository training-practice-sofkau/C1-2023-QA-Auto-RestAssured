Feature: Consultar posts
  yo como usuario
  quiero consultar posts de la pagina
  para poder leerlos y analizarlos

  Scenario: Consulta todos los post exitosamente
    Given se donde encontrar los posts
    When envio una solicitud para obtenerlos
    Then debo obtener una respuesta positiva con los posts disponibles

  Scenario: Consultar un post especifico
    Given se el numero de id del post
    When envio una solicitud con el numero del post
    Then debo obtener el post que solicite

  Scenario: Consultar un post que no exite
    Given Tengo un id de una post incorrecto
    When envio una solicitud con id incorrecto
    Then debo obtener un error porque no existe
