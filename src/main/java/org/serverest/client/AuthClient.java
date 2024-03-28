package org.serverest.client;

import io.restassured.response.Response;
import org.serverest.dto.UsuarioDTO;
import org.serverest.specs.AuthSpecs;

import static io.restassured.RestAssured.given;

public class AuthClient {
    public static String login(UsuarioDTO login){
                Response loginValido =
                given()
                        .spec(AuthSpecs.authSpec())
                        .body(login)
                .when()
                        .post("/login")
                ;

        return loginValido.jsonPath().getString("authorization");
    }
}
