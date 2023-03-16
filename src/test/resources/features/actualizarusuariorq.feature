Feature: Actualizar un usuario en Reqres

  Scenario: Actualizar el trabajo de un usuario
    Given que el servicio "https://reqres.in/api/users" esta disponible
    And el payload de actualizacion del usuario es:
    """
    {
      "job": "Senior Developer"
    }
    """
    When se realiza una solicitud PUT al servicio con el ID del usuario "2" y el payload de actualizacion
    Then se espera una respuesta exitosa con codigo de estado 200
    And la respuesta contiene los datos actualizados del usuario
