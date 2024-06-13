package org.serverest.test;

import org.serverest.UsuarioProvider;
import org.serverest.UsuarioDTO;
import org.serverest.specs.SetupSpecs;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsuariosProviderTest {

    @Test(dataProvider = "UsuarioCamposEmBranco", dataProviderClass = UsuarioProvider.class)
    public void testUsuariosCamposEmBranco(UsuarioDTO usuario, String keyCampo, int statusHttp, String mensagemDeErro){

        given()
            .spec(SetupSpecs.setupSpec())
            .body(usuario)
        .when()
            .post("/usuarios")
        .then()
            .statusCode(statusHttp)
            .body(keyCampo, is(equalTo(mensagemDeErro)))
        ;

    }

}
