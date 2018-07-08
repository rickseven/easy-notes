package id.digisys.easynotes;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT, classes = EasyNotesApplication.class)
public class NotControllerTest extends EasyNotesApplicationTests {
    @Test
    public void shouldReturnStatusCode404WhenIdNotExist(){
        given()
                .contentType("application/json")
                .when().get("/api/notes/1").then()
                .statusCode(404);
    }

    @Test
    public void shouldReturnStatusCode200WhenPostSuccess() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("title", "Spring Boot");
        body.put("content", "Spring Boot Rest Assured");
        given()
                .contentType("application/json")
                .body(body.toString())
                .when().post("/api/notes").then()
                .statusCode(200);
    }
}
