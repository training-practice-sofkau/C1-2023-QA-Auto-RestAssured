Feature: listar productos
  yo como administrador de reqres
  quiero mirar los productos registrados
  para poder verificar productos

  Scenario:  listar productos registrados
    Given que realizo una solicitud para listar productos
    When envio la solicitud para listar productos
    Then debera mostrar la lista de productos

  Scenario:  Verificar si un producto con un determinado id existe en la lista
    Given que realizo una solicitud para verificar la existencia de un producto
    When envio la solicitud para verificar la existencia del producto
    Then debera mostrar la lista de productos con el determinado producto