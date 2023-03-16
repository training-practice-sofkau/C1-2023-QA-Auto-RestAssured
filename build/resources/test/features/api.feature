Feature: Mostrar usuario
  yo como administrador de la API Reqres
  quiero obtener un usuario registrado
  para poder listar sus datos personales

  Scenario: Obtener datos de un usuario exitosamente
    Given que el administrador quiere obtener informacion de un usuario
    When envia una solicitud valida
    Then debera recibir los datos personales del usuario

  Scenario: Verificar un mensaje de error
    Given que el administrador quiere tener informacion de un usuario
    When envia una solicitud invalida en la ruta
    Then debera recibir una respuesta invalida

