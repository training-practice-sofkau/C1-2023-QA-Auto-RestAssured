Feature: Crear un usuario en Reqres

  Scenario: Crear un usuario con exito
    Given que el servicio "https://reqres.in/api/users" esta disponible
    And el payload del usuario es:
    """
    {
      "name": "John",
      "job": "Developer"
    }
    """
    When se realiza una solicitud POST al servicio con el payload
    Then se espera una respuesta exitosa con codigo de estado 201
    And la respuesta contiene los datos del usuario creado
