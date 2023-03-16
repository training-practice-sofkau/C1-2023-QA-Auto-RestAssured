Feature: crear registro en la apgina PlaceHolder
  Yo como usuario de la pagina PlaceHolder
  Quiero poder realizar un registron
  Para tener la informacion guardada en la pagina

    Scenario: crear registro en la pagina PlaceHolder
        Given que estoy en la pagina PlaceHolder
        When ingreso los datos de registro
        Then se crea el registro en la pagina PlaceHolder