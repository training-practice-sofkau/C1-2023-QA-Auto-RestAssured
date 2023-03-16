Feature: Hacer registro de usuario
  Yo como usuario de API reqres.in
  quiero hacer una peticion post
  para hacer un registro

  Scenario: Peticion fallida
    Given el usuario esta en la API reqres.in
    When elige la peticion get SINGLE USER
    And el usuario manda peticion get SINGLE USER sin id
    Then recibe estatus 500