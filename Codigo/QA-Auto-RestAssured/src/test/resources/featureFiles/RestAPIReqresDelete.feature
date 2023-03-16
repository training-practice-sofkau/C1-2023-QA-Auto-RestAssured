Feature:  Eliminar usuario por ID
  yo como administrador de la API https://reqres.in/
  Quiero poder eliminar usuarios por ID
  Para mantener actualizada la lista de usuarios

  # Primer escenario: Eliminar usuario con ID válido y existente
  Scenario: Eliminado exitoso
    Given  el administrador esta en la pagina principal
    When  envia una solicitud DELETE
    Then  se elimina el usuario

  # Segundo escenario: Eliminar usuario con ID no existente
  Scenario: Eliminado usuario con ID no existente
    Given  que no existe un usuario
    When envio una solicitud DELETE
    Then la respuesta tiene un codigo de estado no encontrado

