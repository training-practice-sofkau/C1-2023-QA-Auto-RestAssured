Feature: Crear un usuario
  yo como usuario de la página reqres
  quiero registrarme
  para poder ingresar a la página

  Scenario: Registro exitoso solo con nombre
    Given el usuario ingresa sus datos
    When hace la peticion al servicio
    Then recibe un json con su informacion registrada