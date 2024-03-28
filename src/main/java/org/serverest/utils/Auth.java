package org.serverest.utils;

import org.serverest.client.AuthClient;
import org.serverest.dto.UsuarioDTO;

public class Auth {
    public static String tokenAdm(){
        UsuarioDTO loginAdm = new UsuarioDTO(
                Manipulation.getProp().getProperty("emailAdmin"),
                Manipulation.getProp().getProperty("password")
        );

        return AuthClient.login(loginAdm);
    }

    public static String tokenComum(){
        UsuarioDTO loginComum = new UsuarioDTO(
                Manipulation.getProp().getProperty("emailComum"),
                Manipulation.getProp().getProperty("password")
        );

        return AuthClient.login(loginComum);
    }
}
