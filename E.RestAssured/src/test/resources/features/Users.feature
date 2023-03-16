Feature: Consultar usuarios registrados

  yo como administrador de la api
  quiero mirar los usuarios registrados
  para mirar los usuarios registrados

  Scenario:  listar usuarios registrados
    Given que realizo mirar los usuarios registrados
    When envio la solicitud para mirar usuarios
    Then debera mostrar la lista de usuarios