Feature: como administrador de la api de ReqRes
        quiero obtener una lista de usuarios existente

    Scenario: Obtener usuario
      Given  que realizo una solicitud para obtener una lista
      When   la solicitud es exitosa
      Then   debe mostrar como respuesta


  #Scenario Outline: Dummy Rest Api GET Students
    #Given Get Call to "<url>"
    #Then Response Code "<responseMessage>" is validated

   # Examples:
     # | url      | responseMessage |
    #  | /api/users | 200             |