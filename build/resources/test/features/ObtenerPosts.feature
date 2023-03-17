Feature: Obtener posts
  yo como usuario
  quiero obtener una lista de posts
  para poder leerlos

  Scenario: Obtener lista completa de posts
    Given que el usuario hace una solicitud GET a la API
    When la solicitud se realiza para obtener todos los posts
    Then se debe devolver una respuesta exitosa con la lista de posts

  Scenario: Obtener un post especifico
    Given que el usuario hace una solicitud GET a la API
    When la solicitud se realiza para obtener un post con id 1
    Then se debe devolver una respuesta exitosa con el post correspondiente

  Scenario: Obtener un post inexistente
    Given que el usuario hace una solicitud GET a la API
    When la solicitud se realiza para obtener un post con id inexistente
    Then se debe devolver una respuesta de error
