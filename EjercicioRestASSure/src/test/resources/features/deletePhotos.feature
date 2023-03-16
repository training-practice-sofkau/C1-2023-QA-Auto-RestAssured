Feature: Borrar fotos de jsonplaceholder API
  Yo como administrador de la API
  Quiero borrar fotos existentes

  Scenario: Borrar una foto existente
    Given Tengo un endpoint apuntandoo a la api de fotos
    When Hago una solicitud DELETE con el id de la foto que quiero borrar
    Then Debo obtener una respuesta con codigo de estadoo exitoso
    And La foto debe ser eliminada de la base de datos

  Scenario: Borrar una foto inexistente
    Given Tengo un endpoint apuntando a la apii de fotos
    And No existe ninguna foto con el id que quiero borrar
    When Hago una solicitud DELETE con el id de la foto inexistente
    Then Debo recibir una respuestta con un codigo de estado de Not found

  Scenario: Borrar una foto con caracteres especiales en id
    Given Tengo un endpoint apuntando a la appi de fotos
    And Existe al menos una foto en la base de datos
    When Hago una solicitud DELETE con el id de la foto con caracteres especiales
    Then Debo recibir una respuesta con statuss code indicando un error