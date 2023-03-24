package com.sofkau.stepdefinitions;

import com.sofkau.setup.PhotoSetup;
import com.sofkau.setup.UsuarioUnicoSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class PhotoStepDefinition extends PhotoSetup {

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    private Response response;


    /**
     * escenario 1
     */
    @Given("que me encuentro en la servicio de Reqres")
    public void queMeEncuentroEnLaServicioDeReqres() {
        generalSetup();
    }

    @When("realizo una peticion para obtener las fotos del usuario con id valido")
    public void realizoUnaPeticionParaObtenerLasFotosDelUsuarioConIdValido() {
        response = when().get(GET_RESOURCE1);
    }

    @Then("el sistema debe mostrarme las fotos del usuario")
    public void elSistemaDebeMostrarmeLasFotosDelUsuario() {
        response.then()
                .statusCode(200);
        // .body("data.id", equalTo(1));
    }


    /**
     * escenario 2
     */

    @Given("que tengo el servicio de Reqres")
    public void queTengoElServicioDeReqres() {
        generalSetup();

    }

    @When("realizo una peticion para obtener las fotos del usuario con id invalido")
    public void realizoUnaPeticionParaObtenerLasFotosDelUsuarioConIdInvalido() {
        response = when().get(GET_RESOURCE2);
    }

    @Then("el sistema debe mostrarme un mensaje de usuario invalido")
    public void elSistemaDebeMostrarmeUnMensajeDeUsuarioInvalido() {
        response.then()
                .statusCode(400);
        //  .body("data.id", equalTo(200));
    }

}
