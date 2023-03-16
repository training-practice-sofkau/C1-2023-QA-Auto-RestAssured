Feature: loggin succesfull en regres
  Yo como usuario de la pagina
  Quiero poder acceder a mi cuenta mediante el loggin
  Para poder visualizar mi cuenta


  Scenario: ingreso de usuario exitoso
    Given que el usuario se encuentra en la pagina de loggin
    When el usuario ingresa su correo y contrasena
    Then el usuario es redirigido a su cuenta

  Scenario: ingreso de usuario fallido
    Given que el usuario se encuentra en la pagina de loggin e ingresa una contrasena incorrecta
    When el usuario ingresa su correo  correcto y contrasena incorrecta
    Then el usuario es redirigido a la pagina de loggin nuevamente

    Scenario: el usuario no ingresa la contrasena
    Given que el usuario se encuentra en la pagina de loggin y no ingresa la contrasena
    When el usuario ingresa su correo  correcto y no ingresa la contrasena
    Then el usuario es redirigido a la pagina de loggin nuevamente para que ponga contrasena
