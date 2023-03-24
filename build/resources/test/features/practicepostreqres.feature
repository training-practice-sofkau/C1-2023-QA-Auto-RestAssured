Feature: Registrar usuarios
  yo como usuario de la API Reqres
  quiero registrarme
  para poder ingresar al sistema

  Background:
    Given que el usuario esta en la pagina de registro

  Scenario: Registro Exitoso
    When envia la peticion de registro con un email valido
    Then debe recibir una respuesta con con un id, un token y un codigo de status 200


  Scenario: Registro Fallido
    When envia la peticion de registro con un email invalido
    Then debe recibir una respuesta con mensaje de error y  un codigo de status 400

