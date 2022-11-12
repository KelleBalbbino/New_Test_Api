package testeApiFakerest;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class coverPhotos {
    @Test
    public void buscarTodasAsCoverPhotos() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void buscarCoverPhotoExistente() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/198")

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
                .get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/books/covers/150")

        .then()
                .log().all()
                .statusCode(200);

    }


    @Test
    public void adicionarNovaCoverPhoto(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 225,\n" +
                        "  \"idBook\": 225,\n" +
                        "  \"url\": \"Ele Reina\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void alterarCoverPhoto(){
        given()
                .log().all()
                .contentType(ContentType.JSON)

                .body("{\n" +
                        "  \"id\": 33,\n" +
                        "  \"idBook\": 33,\n" +
                        "  \"url\": \"Mateus seis\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/33")

        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void deletarCoverPhoto() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/13")

        .then()
                .log().all()
                .statusCode(200);

    }


}




