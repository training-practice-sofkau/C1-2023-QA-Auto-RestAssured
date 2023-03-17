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

public class ServicePostStepDefinition {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePostStepDefinition.class));
    private Response response;
    private String requestBody="";
    @Given("el usuario ingresa su nombre")
    public void elUsuarioIngresaSuNombre() {
        requestBody = "{\n"+
                "\"name\":\"Ivan\""+
                "}";
        LOGGER.info("Inicio de la automatizacion Reqres");
    }
    @Given("el usuario ingresa su nobre y trabajo")
    public void elUsuarioIngresaSuNobreYTrabajo() {
        requestBody = "{\n"+
                "\"name\":\"Ivan\","+
                "\n\"job\":\"QA\""+
                "}";
        LOGGER.info("Inicio de la automatizacion Reqres");
    }
    @Given("el usuario ingresa su nobre, trabajo y edad")
    public void elUsuarioIngresaSuNobreTrabajoYEdad() {
        requestBody = "{\n"+
                "\"name\":\"Ivan\","+
                "\n\"job\":\"QA\","+
                "\n\"age\":\"22\""+
                "}";
        LOGGER.info("Inicio de la automatizacion Reqres");
    }
    @When("hace la peticion al servicio")
    public void haceLaPeticionAlServicio() {
        String url=REQRES_URL+REQRES_REGISTRO;
        response= RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);
    }
    @When("el sistema no coloca la coma al hacer la peticion")
    public void elSistemaNoColocaLaComaAlHacerLaPeticion() {
        String url=REQRES_URL+REQRES_REGISTRO;
        requestBody = "{\n"+
                "\"name\":\"Ivan\","+
                "\n\"job\":\"QA\""+
                "\n\"age\":\"22\""+
                "}";
        response= RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);
    }
    @Then("recibe un error de bad request")
    public void recibeUnErrorDeBadRequest() {
        try{
            Assertions.assertEquals(400,response.statusCode());
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
    @Then("recibe un json con su informacion registrada")
    public void recibeUnJsonConSuInformacionRegistrada() {
        JsonObject bodyRespuesta;
        Gson gson=new Gson();
        try{
            bodyRespuesta=gson.fromJson(response.getBody().asString(),JsonObject.class);
            Assertions.assertEquals(201,response.statusCode());
            Assertions.assertTrue(bodyRespuesta.size()>0);
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            LOGGER.info("| Esperado | Obtenido | Valor |");
            if (201==response.statusCode())
                LOGGER.info("| 201 | "+response.statusCode()+" | Cumple |");
            else
                LOGGER.info("| 201 | "+response.statusCode()+" | No cumple |");
        }
    }
}
