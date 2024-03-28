package org.serverest.data.factory;

import org.apache.commons.lang3.StringUtils;
import org.serverest.dto.UsuarioDTO;
import org.serverest.utils.DataFakerGenerator;

public class UsuarioDataFactory {
    public static UsuarioDTO usuarioValido(){
        UsuarioDTO login = new UsuarioDTO();
        login.setNome(DataFakerGenerator.nomeFaker());
        login.setEmail(DataFakerGenerator.emailFaker());
        login.setPassword(DataFakerGenerator.senhaFaker());
        login.setAdministrador(String.valueOf(DataFakerGenerator.adminFaker()));
        return login;
    }

    public static UsuarioDTO usuarioNomeEmBranco(){
        UsuarioDTO login = new UsuarioDTO();
        login.setNome(StringUtils.EMPTY);
        login.setEmail(DataFakerGenerator.emailFaker());
        login.setPassword(DataFakerGenerator.senhaFaker());
        login.setAdministrador(String.valueOf(DataFakerGenerator.adminFaker()));
        return login;
    }

    public static UsuarioDTO usuarioEmailEmBranco(){
        UsuarioDTO login = new UsuarioDTO();
        login.setNome(DataFakerGenerator.nomeFaker());
        login.setEmail(StringUtils.EMPTY);
        login.setPassword(DataFakerGenerator.senhaFaker());
        login.setAdministrador(String.valueOf(DataFakerGenerator.adminFaker()));
        return login;
    }

    public static UsuarioDTO usuarioAdministradorEmBranco(){
        UsuarioDTO login = new UsuarioDTO();
        login.setNome(DataFakerGenerator.nomeFaker());
        login.setEmail(DataFakerGenerator.emailFaker());
        login.setPassword(DataFakerGenerator.senhaFaker());
        login.setAdministrador(StringUtils.EMPTY);
        return login;
    }

    public static UsuarioDTO usuarioSenhaEmBranco(){
        UsuarioDTO login = new UsuarioDTO();
        login.setNome(DataFakerGenerator.nomeFaker());
        login.setEmail(DataFakerGenerator.emailFaker());
        login.setPassword(StringUtils.EMPTY);
        login.setAdministrador(String.valueOf(DataFakerGenerator.adminFaker()));
        return login;
    }






}
