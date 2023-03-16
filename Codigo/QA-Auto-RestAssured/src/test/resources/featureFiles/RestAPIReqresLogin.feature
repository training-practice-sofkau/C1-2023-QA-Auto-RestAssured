Feature: Inicio de sesion de usuario
  yo como administrador de la API https://reqres.in
  Quiero iniciar sesión con mi correo electrónico y contrasena
  Para acceder a mi cuenta

  # Primer escenario: Inicio de sesión exitoso con correo electrónico y contrasena válidos
  Scenario: Dado que existe un usuario con correo y contrasena
    Given envio una solicitud POST a  con el correo y contrasena
    When la respuesta tiene un codigo de estado OK
    Then la respuesta incluye un token de autenticacion

  # Segundo escenario: Inicio de sesión fallido con correo electrónico y contrasena inválidos
  Scenario: Inicio de sesion fallido con correo electronico y contrasena invalidos
    Given que existe un usuario con correo  y contrasena
    When envio una solicitud POST con el correo  y contrasena invalido
    Then la respuesta tiene un codigo de estado No autorizada
