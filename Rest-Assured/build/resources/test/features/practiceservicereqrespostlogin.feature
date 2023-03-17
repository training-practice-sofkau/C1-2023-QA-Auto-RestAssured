Feature: Hacer un Log-In
  yo como usuario de la página reqres
  quiero ingresar a mi cuenta
  para poder interaccionar con la pagina

  Scenario: Log-In fallido solo con email
    Given el usuario ingresa su email
    When hace la peticion al servicio de Log in
    Then recibe un json diciendo que falta la contrasena

  Scenario: Log-In exitoso
    Given el usuario ingresa su email y contrasena
    When hace la peticion al servicio de Log in
    Then recibe un json con el token asignado