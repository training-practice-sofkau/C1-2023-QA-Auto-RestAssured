Feature: crear un nuevo usuario usando el servicio POST
  Yo como usuario de la pagina
  Quiero poder registrarme como un nuevo usuario
  Para tener una cuenta con mi nombre y trabajo

  Scenario: : creacion de un nuevo usuario con datos vacios
    Given se encuentra en la seccion de registro de usuarios y los datos de su nombre y trabajo estan vacios
    When  ingresa los datos de su nombre y trabajo vacios
    Then  se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo vacios


  Scenario: Creacion de un nuevo usuario
    Given se encuentra en la seccion de registro de usuarios
    When  ingresa los datos de su nombre y trabajo corectamente
    Then  se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo ingresados


  Scenario: creacion de un nuevo usuario usando caracteres especiales
     Given se encuentra en la seccion de registro de usuarios y los datos del nombre y trabajo son caracteres especiales
     When  ingresa los datos de su nombre y trabajo con caracteres especiales
     Then  se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo ingresados con caracteres especiales

    Scenario: crecion de usuario sin enviar el nombre
        Given se encuentra en la seccion de registro de usuario y el campo de nombre esta vacio
        When  ingresa el dato del trabajo y deja el campo del nombre vacio
        Then  se debera ver un mensaje con un codigo HTTP not found