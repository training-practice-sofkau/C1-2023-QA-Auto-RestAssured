Feature: Obtener la informacion de un usuario en una peticion get por su id
  Yo como usuario de API reqres.in
  quiero hacer una peticion get con un id
  para ver la informacion del usuario

  Scenario Outline: Peticion exitosa
    Given el usuario esta en la API reqres.in
    When elige la peticion get SINGLE USER
    And el usuario manda peticion get SINGLE USER con un <id>
    Then debe observar la informacion del usuario<status>
    Examples:
      | id | status |
      | 1  |200     |
      | 2  |200     |
      | 3  |200     |

  Scenario: Peticion fallida
    Given el usuario esta en la API reqres.in
    When elige la peticion get SINGLE USER
    And el usuario manda peticion get SINGLE USER sin id
    Then recibe estatus 500