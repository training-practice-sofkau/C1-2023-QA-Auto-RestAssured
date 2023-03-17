package com.sofkau.stepdefinition;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.apache.log4j.Logger;
import static com.sofkau.setup.ConstantSetUp.*;

public class ServicePlaceHolderGetPosts {
    private Response response;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePlaceHolderGetPosts.class));
    @When("hace la peticion de posts al servicio place holder")
    public void haceLaPeticionDePostsAlServicioPlaceHolder() {
        String url=PLACE_HOLDER_URL+PLACE_HOLDER_POSTS;
        response= RestAssured.get(url);
    }
    @Then("recibe un json con la lista de posts")
    public void recibeUnJsonConLaListaDePosts() {
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
