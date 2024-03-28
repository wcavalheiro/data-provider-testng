package org.serverest.data.provider;

import org.serverest.data.factory.UsuarioDataFactory;
import org.testng.annotations.DataProvider;

public class UsuarioProvider {

    @DataProvider(name = "UsuarioCamposEmBranco")
    public static Object[][] UsuarioCamposEmBranco() {
        return new Object[][] {
                {UsuarioDataFactory.usuarioNomeEmBranco(), "nome", 400, "nome não pode ficar em branco"},
                {UsuarioDataFactory.usuarioEmailEmBranco(), "email", 400, "email não pode ficar em branco"},
                {UsuarioDataFactory.usuarioSenhaEmBranco(), "password", 400, "password não pode ficar em branco"},
                {UsuarioDataFactory.usuarioAdministradorEmBranco(), "administrador", 400, "administrador deve ser 'true' ou 'false'"}
        };
    }

}
