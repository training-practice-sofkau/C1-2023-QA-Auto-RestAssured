Feature: Actualizar un usuario en Reqres

  Scenario: Actualizar el trabajo de un usuario
    Given que el servicio "https://reqres.in/api/users" está disponible
    And el payload de actualización del usuario es:
    """
    {
      "job": "Senior Developer"
    }
    """
    When se realiza una solicitud PUT al servicio con el ID del usuario "2" y el payload de actualización
    Then se espera una respuesta exitosa con código de estado 200
    And la respuesta contiene los datos actualizados del usuario
