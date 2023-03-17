package com.sofkau.stepdefinition;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.setup.ConstantSetUp.*;

public class ServicePostLoginStepDefinition {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePostLoginStepDefinition.class));
    private Response response;
    private String requestBody="";
    @Given("el usuario ingresa su email")
    public void elUsuarioIngresaSuEmail() {
        requestBody = "{\n"+
                "\"email\":\"eve.holt@reqres.in\"\n"+
                "}";
        LOGGER.info("Inicio de la automatizacion Reqres");
    }
    @Given("el usuario ingresa su email y contrasena")
    public void elUsuarioIngresaSuEmailYContrasena() {
        requestBody = "{\n"+
                "\"email\":\"eve.holt@reqres.in\",\n"+
                "\"password\": \"cityslicka\"\n"+
                "}";
        LOGGER.info("Inicio de la automatizacion Reqres");
    }
    @When("hace la peticion al servicio de Log in")
    public void haceLaPeticionAlServicioDeLogIn() {
        String url=REQRES_URL+REQRES_LOGIN;
        response= RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);
    }
    @Then("recibe un json con el token asignado")
    public void recibeUnJsonConElTokenAsignado() {
        JsonObject bodyRespuesta;
        Gson gson=new Gson();
        try{
            bodyRespuesta=gson.fromJson(response.getBody().asString(),JsonObject.class);
            Assertions.assertEquals(200,response.statusCode());
            Assertions.assertEquals("QpwL5tke4Pnpja7X4",bodyRespuesta.get("token").toString().substring(1,18));
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            LOGGER.info("| Esperado | Obtenido | Valor |");
            if (200==response.statusCode())
                LOGGER.info("| 200 | "+response.statusCode()+" | Cumple |");
            else
                LOGGER.info("| 200 | "+response.statusCode()+" | No cumple |");
        }
    }
    @Then("recibe un json diciendo que falta la contrasena")
    public void recibeUnJsonDiciendoQueFaltaLaContrasena() {
        JsonObject bodyRespuesta;
        Gson gson=new Gson();
        try{
            bodyRespuesta=gson.fromJson(response.getBody().asString(),JsonObject.class);
            Assertions.assertEquals(400,response.statusCode());
            Assertions.assertEquals("Missing password",bodyRespuesta.get("error").toString().substring(1,17));
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            LOGGER.info("| Esperado | Obtenido | Valor |");
            if (400==response.statusCode())
                LOGGER.info("| 400 | "+response.statusCode()+" | Cumple |");
            else
                LOGGER.info("| 400 | "+response.statusCode()+" | No cumple |");
        }
    }
}
