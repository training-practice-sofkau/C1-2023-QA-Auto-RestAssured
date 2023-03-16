Feature: El usuario puede obtener un usuario especifico.

  Scenario: El usuario realiza una solicitud GET con un ID de usuario valido.

    Given un ID de usuario valido.
    When  el usuario realiza una solicitud GET para obtener informacion del usuario.
    Then el sistema debe responder con los detalles del usuario solicitado.

