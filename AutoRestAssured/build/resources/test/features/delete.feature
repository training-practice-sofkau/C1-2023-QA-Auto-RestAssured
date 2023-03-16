Feature: eliminar un usuario
  yo como administrador de la pagina web reqres
  quiero realizar una peticion al servicio Delete
  para poder eliminar un usuario de la lista

Scenario: Delete exitoso
  Given el adminstrador accede a la pagina web de reqres
  When envia una solicitid al servicio Delete para eliminar un usuario
  And el usuario esta registrado en la lista
  Then debe observar un codigo de estatus No content


  Scenario: Delete fallido
    Given el administrador accede a la pagina web de reqres
    When envia una solicitud al servicio Delete para eliminar un usuario
    And el usuario no esta registrado en la lista
    Then debe retornar un codigo de estatus Not found