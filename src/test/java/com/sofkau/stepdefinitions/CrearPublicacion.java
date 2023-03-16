package com.sofkau.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

    public class CrearPublicacion {

        private RequestSpecification request;
        private Response response;
        private int postId;

        @Given("que tengo acceso al servicio para crear publicaciones")
        public void queTengoAccesoAlServicioParaCrearPublicaciones() {
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
            request = given();
        }

        @When("envío una solicitud POST con el título {string} y el cuerpo {string}")
        public void envioUnaSolicitudPOSTConElTituloYElCuerpo(String title, String body) {
            String payload = "{\n" +
                    "  \"title\": \"" + title + "\",\n" +
                    "  \"body\": \"" + body + "\",\n" +
                    "  \"userId\": 1\n" +
                    "}";

            response = request.body(payload).post("posts");
            postId = response.jsonPath().getInt("id");
        }

        @Then("la respuesta debe tener un código de estado {int}")
        public void laRespuestaDebeTenerUnCodigoDeEstado(int statusCode) {
            assertEquals(statusCode, response.getStatusCode());
        }

        @And("la respuesta debe contener el ID de la nueva publicación")
        public void laRespuestaDebeContenerElIDDeLaNuevaPublicacion() {
            assertTrue(response.getBody().asString().contains("\"id\":" + postId));
        }

        @And("he creado una nueva publicación con título {string} y cuerpo {string}")
        public void heCreadoUnaNuevaPublicacionConTituloYCuerpo(String title, String body) {
            String payload = "{\n" +
                    "  \"title\": \"" + title + "\",\n" +
                    "  \"body\": \"" + body + "\",\n" +
                    "  \"userId\": 1\n" +
                    "}";

            response = request.body(payload).post("posts");
            postId = response.jsonPath().getInt("id");
        }

        @When("envío una solicitud GET al servicio con el ID de la publicación")
        public void envioUnaSolicitudGETAlServicioConElIDDeLaPublicacion() {
            response = request.get("posts/" + postId);
        }

        @And("la respuesta debe contener el título y cuerpo de la publicación creada")
        public void laRespuestaDebeContenerElTituloYCuerpoDeLaPublicacionCreada() {
            String responseBody = response.getBody().asString();
            assertTrue(responseBody.contains("\"title\":\"Titulo de la publicación\""));
            assertTrue(responseBody.contains("\"body\":\"Cuerpo de la publicación\""));
        }

}