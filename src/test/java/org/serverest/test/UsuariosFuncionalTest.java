package org.serverest.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.serverest.UsuarioDTO;
import org.serverest.specs.SetupSpecs;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

        /*{
            "nome": "Fulano da Silva",
            "email": "beltrano@qa.com.br",
            "password": "teste",
            "administrador": "true"
        }*/

    // Testes funcionais de campos em branco

    @Test
    public void testCadastrarUsuarioNomeEmbranco(){
        UsuarioDTO usuario = new UsuarioDTO(StringUtils.EMPTY, "petter@email.com", "senhaDificil", "false");

        given()
            .spec(SetupSpecs.setupSpec())
            .body(usuario)
        .when()
            .post("/usuarios")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("nome", is(equalTo("nome não pode ficar em branco")))
        ;
    }

    @Test
    public void testCadastrarUsuarioEmailEmBranco(){
        UsuarioDTO usuario = new UsuarioDTO("Peter", StringUtils.EMPTY, "senhaDificil", "false");

        given()
            .spec(SetupSpecs.setupSpec())
            .body(usuario)
        .when()
            .post("/usuarios")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("email", is(equalTo("email não pode ficar em branco")))
        ;
    }

    @Test
    public void testCadastrarUsuarioAdministradorEmBranco(){
        UsuarioDTO usuario = new UsuarioDTO("Peter", "petter@email.com", "senhaDificil", StringUtils.EMPTY);

        given()
                .spec(SetupSpecs.setupSpec())
                .body(usuario)
        .when()
                .post("/usuarios")
        .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("administrador", is(equalTo("administrador deve ser 'true' ou 'false'")))
        ;
    }

    @Test
    public void testCadastrarUsuarioSenhaEmBranco(){
        UsuarioDTO usuario = new UsuarioDTO("Peter", "petter@email.com", StringUtils.EMPTY, "false");

        given()
            .spec(SetupSpecs.setupSpec())
            .body(usuario)
        .when()
            .post("/usuarios")
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("password", is(equalTo("password não pode ficar em branco")))
        ;
    }

}
