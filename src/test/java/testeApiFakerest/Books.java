package testeApiFakerest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Books {

    @Test
    public void buscarTodasOsLivros() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
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
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books/22")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void adicionarNovoLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 222,\n" +
                        "  \"title\": \"15 DE NOVEMBRO\",\n" +
                        "  \"description\": \"A INDEPENDÊNCIA\",\n" +
                        "  \"pageCount\": 0,\n" +
                        "  \"excerpt\": \"string\",\n" +
                        "  \"publishDate\": \"2022-11-12T01:21:25.859Z\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void alterarLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 2022 ,\n" +
                        "  \"title\": \"BRASIL\",\n" +
                        "  \"description\": \"PÁTRIA AMADA\",\n" +
                        "  \"pageCount\": 15,\n" +
                        "  \"excerpt\": \"string\",\n" +
                        "  \"publishDate\": \"2022-11-12T01:24:59.111Z\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Books/2022")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void deletarLivroExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Books/21")

        .then()
                .log().all()
                .statusCode(200);

    }


}


