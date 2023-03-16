Feature: Listar Usuarios
  yo como administrador de la API Reqres
  quiero realizar una petición get
  para poder listar usuarios


  Scenario: Respuesta exitosa
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de los formularios
    And completa los campos con la informacion del estudiante
    Then entonces debe observar una ventana con la informacion ingresada