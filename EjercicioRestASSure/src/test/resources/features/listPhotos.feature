Feature: Listar Photos de jsonplaceholder API
  Yo como administrador de la API
  Quiero listar las fotos existentes


  Scenario: Listar una foto existente
    Given Tengo un endpoint apuntando a la api de fotos
    When Hago una solicitud GET con el id de la foto que quiero visualizar
    Then Debo obtener una respuesta con codigo de estado exitoso
    And  Debo poder visualizar un body con la informacion de la foto

  Scenario: Listar una foto inexistente
    Given Tengo un endpoint apuntando a la api de fotoss
    When Hago una solicitud GET con el id de la foto inexistente
    Then Debo recibir una respuesta con un codigo de estado de Not found

  Scenario: Listar una foto con caracteres especiales en id
    Given Tengo un endpoint apuntando a la api de fotosss
    When Hago una solicitud GET con el id de la foto con caracteres especiales
    Then Debo recibir una respuesta con status code indicando un errror