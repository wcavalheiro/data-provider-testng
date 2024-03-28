package org.serverest.client;

import io.restassured.response.Response;
import org.serverest.dto.UsuarioDTO;
import org.serverest.dto.UsuarioResponse;
import org.serverest.specs.SetupSpecs;
import org.serverest.specs.UsuarioSpecs;

import static io.restassured.RestAssured.given;

public class UsuarioClient {

    private static final String USUARIO_URL= "/usuarios";
    private static final String USUARIO_ID_URL= "/usuarios/{_id}";

    // PUT User
    public Response criarUsuario(UsuarioDTO login){
        return
                given()
                        .spec(UsuarioSpecs.usuarioSpec())
                        .body(login)
                .when()
                        .post(USUARIO_URL)
                ;
    }

    // GET all user
    public Response retornaUsuariosLista(){
        return
                given()
                        .spec(UsuarioSpecs.usuarioSpec())
                .when()
                        .get(USUARIO_URL)
                ;
    }

    // PUT user id
    public Response editarUsuarioPorId(String id, UsuarioDTO usuarioAtualizado){
        return
                given()
                        .spec(UsuarioSpecs.usuarioSpec())
                        .pathParam("_id", id)
                        .body(usuarioAtualizado)
                .when()
                        .get(USUARIO_URL)
                ;
    }

    // GET all user
    public Response retornaUsuarioPorId(UsuarioResponse usuario){
        return
                given()
                        .spec(UsuarioSpecs.usuarioSpec())
                        .pathParam("_id", usuario.get_id())
                .when()
                        .get(USUARIO_ID_URL)
                ;
    }

    // DELETE user id
    public Response deletarUsuarioPorId(UsuarioResponse usuario){
        return
                given()
                        .spec(UsuarioSpecs.usuarioSpec())
                        .pathParam("_id", usuario.get_id())
                .when()
                        .delete(USUARIO_ID_URL)
                ;
    }
}
