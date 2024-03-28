package org.serverest.test;

import org.apache.http.HttpStatus;
import org.serverest.client.UsuarioClient;
import org.serverest.data.factory.UsuarioDataFactory;
import org.serverest.dto.UsuarioDTO;
import org.serverest.dto.UsuarioResponse;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;
import static org.testng.AssertJUnit.*;

public class UsuariosFuncionalTest extends UsuarioClient{
    SoftAssertions assertions = new SoftAssertions();

    // Testes funcionais de campos em branco
    @Test
    public void testCadastrarUsuarioNomeEmbranco(){
        UsuarioDTO usuario = UsuarioDataFactory.usuarioNomeEmBranco();

        var resultado = criarUsuario(usuario)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioResponse.class)
                ;

        assertNotNull(resultado.getNome());
        assertEquals("nome não pode ficar em branco", resultado.getNome());
        assertions.assertAll();
    }

    @Test
    public void testCadastrarUsuarioEmailEmBranco(){
        UsuarioDTO usuario = UsuarioDataFactory.usuarioEmailEmBranco();

        var resultado = criarUsuario(usuario)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioResponse.class)
            ;

        assertNotNull(resultado.getEmail());
        assertEquals("email não pode ficar em branco", resultado.getEmail());
        assertions.assertAll();
    }

    @Test
    public void testCadastrarUsuarioAdministradorEmBranco(){
        UsuarioDTO usuario = UsuarioDataFactory.usuarioAdministradorEmBranco();

        var resultado = criarUsuario(usuario)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioResponse.class)
            ;

        assertNotNull(resultado.getAdministrador());
        assertEquals("administrador deve ser 'true' ou 'false'", resultado.getAdministrador());
        assertions.assertAll();
    }

    @Test
    public void testCadastrarUsuarioSenhaEmBranco(){
        UsuarioDTO usuario = UsuarioDataFactory.usuarioSenhaEmBranco();

        var resultado = criarUsuario(usuario)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(UsuarioResponse.class)
            ;

        assertNotNull(resultado.getPassword());
        assertEquals("password não pode ficar em branco", resultado.getPassword());
        assertions.assertAll();
    }

}
