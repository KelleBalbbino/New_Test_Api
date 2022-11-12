package testeApiFakerest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class user {


    @Test
    public void buscarTodasOsUsuários() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void buscarUsuárioExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users/5")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void adicionarNovoUsuário(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 11,\n" +
                        "  \"userName\": \"KelleBalbbino\",\n" +
                        "  \"password\": \"1234\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void alterarUsuário(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 9,\n" +
                        "  \"userName\": \"Kelle9\",\n" +
                        "  \"password\": \"102030\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Users/9")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void deletarUsuárioExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Users/3")

                .then()
                .log().all()
                .statusCode(200);

    }

}
