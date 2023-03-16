Feature: Obtener informacion de usuario
  Yo como administarador de la pagina web reqres
  quiero realizar una peticion al servicio Get single user
  para obtener informacion sobre de un usuario especifico

  Background:
    Given el adminstrador accede a la pagina web de reqres
  Scenario: usuario registrado
    When envia una solicitud al servicio Get single user
    And el usuario esta registradeo en la lista
    Then retorna un codigo de estatus ok
    And lista la informacion de un usuario determinado

    Scenario: usuario no encontrado
      When envia solicitud al servicio Get single user
      And el usuario seleccionado no esta registrado en la lista
      Then debe retornar un codigo estatus Not found