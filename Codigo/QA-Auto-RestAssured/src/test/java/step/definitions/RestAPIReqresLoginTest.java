package step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RestAPIReqresLoginTest {

    private RequestSpecification request;
    private Response response;
    private String email;
    private String password;

    @Given("envio una solicitud POST a  con el correo y contrasena")
    public void envio_una_solicitud_POST_a_con_el_correo_y_contrasena() {
        try {   RestAssured.baseURI = "https://reqres.in/api";
        email = "eve.holt@reqres.in";
        password = "cityslicka";
        request = given().header("Content-Type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}");}
        catch (Exception e) {
                System.out.println("Error al enviar la solicitud POST: " + e.getMessage());
            }
    }

    @When("la respuesta tiene un codigo de estado OK")
    public void la_respuesta_tiene_un_codigo_de_estado_OK() {
        try {
            response = request.post("/login");
            response.then().statusCode(200);
        } catch (Exception e) {
            System.out.println("Error al enviar la solicitud POST: " + e.getMessage());
        }
    }

    @Then("la respuesta incluye un token de autenticacion")
    public void la_respuesta_incluye_un_token_de_autenticacion() {
        try {
            response.then().body("token", notNullValue());
        } catch (Exception e) {
            System.out.println("Error al validar el token de autenticación: " + e.getMessage());
        }
    }

    @Given("que existe un usuario con correo  y contrasena")
    public void que_existe_un_usuario_con_correo_y_contrasena() {
        try {    RestAssured.baseURI = "https://reqres.in/api";
        email = "eve.holt@reqres.in";
        password = "wrong_password";
        request = given().header("Content-Type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}");
        } catch (Exception e) {
            System.out.println("Error al enviar la solicitud POST: " + e.getMessage());
        }
    }

    @When("envio una solicitud POST con el correo  y contrasena invalido")
    public void envio_una_solicitud_post_con_el_correo_y_contrasena_invalido(){
        try {
            response = request.post("/login");
        } catch (Exception e) {
            System.out.println("Error al enviar la solicitud POST: " + e.getMessage());
        }
    }

    @Then("la respuesta tiene un codigo de estado No autorizada")
    public void la_respuesta_tiene_un_codigo_de_estado_No_autorizada() {
        try {
            response.then().statusCode(400);
        } catch (Exception e) {
            System.out.println("Error al validar el código de estado: " + e.getMessage());
        }
    }
}

