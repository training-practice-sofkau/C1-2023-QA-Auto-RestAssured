Feature: Listar Usuarios
  yo como administrador de la API Reqres
  quiero obtener una lista de usuarios registrados
  para poder ver quiénes están usando el servicio

  Scenario: Obtener usuarios exitosamente
    Given que el administrador quiere obtener un listado de usuarios
    When envia una peticion correcta
    Then debera recibir un listado de usuarios


  Scenario: Verificar mensaje de error
    Given que el administrador quiere conseguir un listado de usuarios
    When envia una peticion incorrecta
    Then debera recibir un respuesta fallida
