Feature: Consultar usuarios registrados

  yo como administrador de la api
  quiero mirar los usuarios registrados
  para ver nombre, username y email los usuarios registrados

  Scenario Outline:  listar usuarios registrados
    Given que realizo mirar los usuarios registrados
    When envio la solicitud para mirar usuarios por <id>
    Then debera mostrar la lista de usuarios con nombre <name> username <username>  email <email>
    Examples:
      | id  | name            | username    | email               |
      | "2" | "Ervin Howell"  | "Antonette" | "Shanna@melissa.tv" |
      | "1" | "Leanne Graham" | "Bret"      | "Sincere@april.biz" |