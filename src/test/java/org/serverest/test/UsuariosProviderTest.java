package org.serverest.test;


import io.restassured.response.Response;
import org.serverest.client.UsuarioClient;
import org.serverest.data.provider.UsuarioProvider;
import org.serverest.dto.UsuarioDTO;
import org.serverest.dto.UsuarioResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UsuariosProviderTest extends UsuarioClient {

    @Test(dataProvider = "UsuarioCamposEmBranco", dataProviderClass = UsuarioProvider.class)
    public void testUsuariosCamposEmBranco(UsuarioDTO usuario, String campo, Integer statusHttp, String mensagem){

       criarUsuario(usuario)
            .then()
                .statusCode(statusHttp)
                .body(campo, is(notNullValue()))
                .body(campo, equalTo(mensagem))
       ;
    }

}
