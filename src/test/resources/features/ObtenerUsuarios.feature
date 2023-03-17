Feature: Obtener todos los usuarios
  Como usuario de la API de jsonplaceholder.typicode.com
  Quiero obtener una lista de todos los usuarios
  Para verificar que la API responde con los datos correctos

  Scenario: Obtener todos los usuarios exitosamente
    Given que estoy en la pagina "https://jsonplaceholder.typicode.com/users"
    When envio una solicitud GET a la URL "https://jsonplaceholder.typicode.com/users"
    Then la respuesta debe tener el codigo de estado 200
    And la respuesta debe contener todos los usuarios en formato JSON

  Scenario: Obtener todos los usuarios sin exito
    Given que estoy en la pagina "https://jsonplaceholder.typicode.com/users"
    When envio una solicitud GET a la URL "https://jsonplaceholder.typicode.com/users_invalida"
    Then la respuesta debe tener el codigo de estado 404
