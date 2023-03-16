Feature: como administrador de la api de ReqRes
  quiero obtener una lista de usuarios existente

 Scenario: Registro de usuario exitoso
   Given tengo los datos del usuario
   When envio una peticion una peticion de registro
   Then debo obtener un mensaje de registro