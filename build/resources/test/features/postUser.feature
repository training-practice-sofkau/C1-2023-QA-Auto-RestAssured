Feature: Registro de usuario
  Como administrador de la API de ReqRes
  Quiero registrar un usuario en la plataforma
  Para que pueda acceder a los servicios de la plataforma

  Scenario: Registro exitoso
    Given que tiene las credendiales para registrarse
    When realiza una solicitud de registro con los datos anteriores
    Then la solicitud debe ser exitosa devolviendo un token de acceso

  Scenario: Campo de contraseña faltante
    Given que utilizo un correo para hacer un registro
    When realizo una solicitud de registro con correo pero sin contrasena
    Then la solicitud no debe devolver token
    And debe mostrar un mensaje de error indicando que falta la contrasena
