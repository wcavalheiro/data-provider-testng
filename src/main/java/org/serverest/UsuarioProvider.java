package org.serverest;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

public class UsuarioProvider {

    // Constantes
    private static final String MENSAGEM_NOME = "nome não pode ficar em branco";
    private static final String MENSAGEM_EMAIL = "email não pode ficar em branco";
    private static final String MENSAGEM_SENHA = "password não pode ficar em branco";
    private static final String MENSAGEM_ADM = "administrador deve ser 'true' ou 'false'";

    private static final String KEY_NOME = "nome";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_SENHA = "password";
    private static final String KEY_ADM = "administrador";

    private static final int HTTP_STATUS = 400;

    @DataProvider(name = "ExemploDeEstrutura")
    public static Object[][] NomeDoProvider() {
        return new Object[][] {

        };
    }

    @DataProvider(name = "UsuarioCamposEmBranco")
    public static Object[][] UsuarioCamposEmBranco() {
        UsuarioDTO usuarioSemAdm = new UsuarioDTO("Peter", "petter@email.com", "senhaDificil", StringUtils.EMPTY);
        UsuarioDTO usuarioSemNome = new UsuarioDTO(StringUtils.EMPTY, "petter@email.com", "senhaDificil", "false");
        UsuarioDTO usuarioSemEmail = new UsuarioDTO("Peter", StringUtils.EMPTY, "senhaDificil", "false");
        UsuarioDTO usuarioSemSenha = new UsuarioDTO("Peter", "petter@email.com", StringUtils.EMPTY, "false");

        return new Object[][] {
                {usuarioSemAdm, KEY_ADM, HTTP_STATUS, MENSAGEM_ADM},
                {usuarioSemSenha, KEY_SENHA, HTTP_STATUS, MENSAGEM_SENHA},
                {usuarioSemEmail, KEY_EMAIL, HTTP_STATUS, MENSAGEM_EMAIL},
                {usuarioSemNome, KEY_NOME, HTTP_STATUS, MENSAGEM_NOME}
        };
    }
}
