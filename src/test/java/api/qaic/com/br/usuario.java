package api.qaic.com.br;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class usuario {


    @Test
    public void adicionarUsuarioComSucesso() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\":\"teste.kb@gmail.com\",\n" +
                        "    \"nome\": \"Kelle Balbino\",\n" +
                        "    \"senha\" : \"231513\",\n" +
                        "    \"rua\" : \"Avenida 20\",\n" +
                        "    \"numero\" : \"32\",\n" +
                        "    \"cep\": \"9257841\",\n" +
                        "    \"bairro\" : \"Voo livre\",\n" +
                        "    \"cidade\" : \"Sapiranga\",\n" +
                        "    \"estado\": \"RJ\"\n" +
                        "}")
        .when()
                .post("https://api.qaic.com.br/wp-json/qa/user")

        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void logarNoSistema() {
        String token = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\":\"teste.kb@gmail.com\",\n" +
                        "    \"password\" : \"231513\"\n" +
                        "}")

        .when()
                .post("https://api.qaic.com.br/wp-json/jwt-auth/v1/token")

        .then()
                .log().all()
                .statusCode(200)
                .extract().path("token");

        System.out.println("Token esta sendo armazenado aqui >>>>>> " + token);

    }

    @Test
           public void adicionarProduto(){

        String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJo" +
                "dHRwczovL2FwaS5xYWljLmNvbS5iciIsImlhdCI6MTY2Nzk1NTQ4OCwibmJmIjo" +
                "xNjY3OTU1NDg4LCJleHAiOjE2NjgwNDE4ODgsImRhdGEiOnsidXNlciI6eyJp" +
                "ZCI6IjI5In19fQ.XclZaNogU4jF9HwG_3VoD7yaw6ADfeZI3gDOvDnYZuw";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"nome\":\"Geladeira\",\n" +
                        "    \"descrição\" : \"Geladeira Consul\"\n" +
                        "    \"preço\": \"3.200\"\n" +
                        "}")
                .header("authorization", token)
        .when()
                .post("https://api.qaic.com.br/wp-json/qa/produto")

        .then();


    }

    }










