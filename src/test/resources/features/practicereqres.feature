Feature: Listar Usuarios
  yo como administrador de la API Reqres
  quiero obtener informacion de los usuarios registrados
  para poder ver quiénes están usando el servicio

  Scenario: Obtener usuarios exitosamente
    Given que el administrador quiere obtener un informacion de un usuario
    When envia una peticion correcta
    Then debera recibir informacion del usuario y un codigo de estado 200


  Scenario: Verificar mensaje de error
    Given que el administrador quiere conseguir un listado de usuarios
    When envia una peticion incorrecta
    Then debera recibir un respuesta codigo de estado 404
