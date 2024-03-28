package org.serverest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nome;
    private String email;
    private String password;
    private String administrador;

    public UsuarioDTO(String email, String password){
        this.nome = email;
        this.password = password;
    }
}
