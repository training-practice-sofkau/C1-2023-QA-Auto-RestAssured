Feature: Consulta de usuarios en jsonplaceholder

  Como administrador de la pagina web jsonplaceholder
  Quiero obtener una lista de usuarios
  Para poder visualizar su información

  Scenario: Obtener lista de usuarios
  Given que estoy en la pagina web de jsonplaceholder
  When solicito la lista de usuarios
  Then recibo una respuesta que debe contener todos los usuarios

  Scenario: Obtener una lista limitada de usuarios
    Given que estoy en la pagina web
    When solicito una la lista limitada de usuarios
    Then recibo una respuesta que debe contener 5 usuarios
