Feature: Obtener un usuario específico de JSONPlaceholder

  Scenario: Consultar un usuario por su ID
    Given que el servicio "https://jsonplaceholder.typicode.com/users" esta disponible
    When se realiza una solicitud GET al servicio con el ID del usuario "1"
    Then se espera una respuesta exitosa con codigo de estado 200
    And la respuesta contiene los datos del usuario "Leanne Graham"
