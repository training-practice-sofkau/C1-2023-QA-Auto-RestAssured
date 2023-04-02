Feature: servicio de posts
  yo como Administrador
  quiero enviar peticiones
  para poder modificar los posts

Scenario: actualizacion exitosa del post 2
Given que tengo la url del post a actualizar
And tengo la informacion actualizada del recurso
When  envio  una peticion de tipo put a la url del recurso
Then debo obtener una respuesta con un codigo de estado 200 al obtener el recurso actualizado