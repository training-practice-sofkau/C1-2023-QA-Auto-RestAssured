Feature: Crear un usuario
  yo como usuario de la página reqres
  quiero registrarme
  para poder ingresar a la página

  Scenario: Registro exitoso solo con nombre
    Given el usuario ingresa su nombre
    When hace la peticion al servicio
    Then recibe un json con su informacion registrada

  Scenario: Registro exitoso con nombre y trabajo
    Given el usuario ingresa su nobre y trabajo
    When hace la peticion al servicio
    Then recibe un json con su informacion registrada

  Scenario: Registro exitoso con nombre, trabajo y edad
    Given el usuario ingresa su nobre, trabajo y edad
    When hace la peticion al servicio
    Then recibe un json con su informacion registrada

  Scenario: Registro fallido con nombre y trabajo
    Given el usuario ingresa su nobre y trabajo
    When hace la peticion al servicio
    But el sistema no coloca la coma al hacer la peticion
    Then recibe un error de bad request