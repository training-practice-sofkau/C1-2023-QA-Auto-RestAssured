Feature: Consultar Fotos registradas en el sistema

  yo como administrador de la api
  quiero mirar la informacion de fotos registradas
  para ver nombre, username y email los usuarios registrados

  Scenario Outline:  Ver informacion de fotos registradas
    Given que realizo estoy en la API de fotos
    When envio la solicitud para mirar fotos  por <id>
    Then debera mostrar la lista de fotos con el title <title>
    Examples:
      | id | title                                                |
      | 1  | "accusamus beatae ad facilis cum similique qui sunt" |
      | 2  | "reprehenderit est deserunt velit ipsam"             |
      | 3  |"officia porro iure quia iusto qui ipsa ut modi"      |


