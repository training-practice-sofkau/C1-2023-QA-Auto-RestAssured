package com.sofkau.stepdefinition;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.setup.ConstantSetUp.*;

public class ServicePlaceHolderGet {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePlaceHolderGet.class));
    private Response response;
    @Given("el administrador esta en la pagina")
    public void elAdministradorEstaEnLaPagina() {
        LOGGER.info("Inicio de la automatizacion Place Holder");
    }
    @When("hace la peticion de usuarios al servicio place holder")
    public void haceLaPeticionDeUsuariosAlServicioPlaceHolder() {
        String url=PLACE_HOLDER_URL+PLACE_HOLDER_USERS;
        response=RestAssured.get(url);
    }
    @When("le agrega un path con una palabra")
    public void leAgregaUnPathConUnaPalabra() {
        String url=PLACE_HOLDER_URL+"/stundt";
        response=RestAssured.get(url);
    }
    @Then("recibe un error de not found")
    public void recibeUnErrorDeNotFound() {
        try{
            Assertions.assertEquals(404,response.statusCode());
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            LOGGER.info("| Esperado | Obtenido | Valor |");
            if (404==response.statusCode())
                LOGGER.info("| 404 | "+response.statusCode()+" | Cumple |");
            else
                LOGGER.info("| 404 | "+response.statusCode()+" | No cumple |");
        }
    }
    @Then("recibe un json con la lista de usuarios")
    public void recibeUnJsonConLaListaDeUsuarios() {
        Gson gson = new Gson();
        JsonArray responses = new JsonArray();
        JsonElement element;
        JsonArray jsonArray;
        JsonObject jsonObject;
        try{
            Assertions.assertEquals(200, response.statusCode());
            element = gson.fromJson(response.getBody().asString(), JsonElement.class);
            if (element.isJsonArray()) {
                jsonArray = element.getAsJsonArray();
                for (JsonElement jsonElement : jsonArray) {
                    jsonObject = jsonElement.getAsJsonObject();
                    responses.add(jsonObject);
                }
            }
            Assertions.assertTrue(responses.size()>0);
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
}
