Feature: List Users API
  Como usuario
  Quiero obtener una lista de usuarios
  Para poder utilizar la información en mi aplicacion

  Scenario: Successful response with valid page number
    Given que el usuario tiene el endpoint "https://reqres.in/api/users"
    When el usuario hace una solicitud GET con la consulta "page=2"
    Then el codigo de respuesta es 200
    And la respuesta contiene 6 usuarios
    And el segundo usuario tiene el email "janet.weaver@reqres.in"

  Scenario: Unsuccessful response with invalid page number
    Given que el usuario tiene el endpoint "https://reqres.in/api/users"
    When el usuario hace una solicitud GET con la consulta "page=100"
    Then el codigo de respuesta es 404
    And la respuesta contiene el mensaje "No se encontro la pagina"