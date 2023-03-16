Feature: El usuario puede iniciar sesión correctamente en el sistema.

  Scenario: Se utilizan credenciales válidas de usuario para iniciar sesión.

    Given un correo electronico y una contrasena validos.
    When el usuario envia el formulario de inicio de sesion.
    Then el sistema debe responder con un token.

    Scenario: Se utilizan credenciales Invalidas o inexistentes de usuario para iniciar sesion.

      Given un correo electronico y una contrasena invalidas
      When el usuario envia el formulario de inicio de sesion.
      Then el sistema debe responder con un mensaje de error "credenciales invalidas"
