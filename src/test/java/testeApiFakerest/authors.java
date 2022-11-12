package testeApiFakerest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class authors {
    @Test
    public void buscarTodasOsAuthors() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void buscarAuthorExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/25")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void buscarLivroExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/23")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void adicionarNovoAuthor(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 790,\n" +
                        "  \"idBook\": 55,\n" +
                        "  \"firstName\": \"Kelle\",\n" +
                        "  \"lastName\": \"Balbbino\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Authors")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void alterarAuthor(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 15,\n" +
                        "  \"idBook\": 23,\n" +
                        "  \"firstName\": \"Sophia\",\n" +
                        "  \"lastName\": \"Balbino\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Authors/15")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void deletarAuthorExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Authors/13")

        .then()
                .log().all()
                .statusCode(200);

    }


}
