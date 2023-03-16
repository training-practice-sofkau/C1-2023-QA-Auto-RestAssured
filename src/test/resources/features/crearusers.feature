Feature: Pruebas de API con Rest-Assured

  Scenario: Crear usuario exitosamente
    Given la URL base es "https://reqres.in"
    When se crea un usuario con nombre "John" y trabajo "Engineer"
    Then se recibe una respuesta con codigo de estado 201

  Scenario: Error al crear usuario
    Given la URL base es "https://reqres.in"
    When se crea un usuario con nombre vacio y trabajo "Designer"
    Then se recibe una respuesta con codigo de estado 400
