package org.serverest.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.serverest.utils.Auth;
import org.serverest.utils.Manipulation;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class UsuarioSpecs {
    public UsuarioSpecs(){}
    public static RequestSpecification usuarioSpec(){
        return new RequestSpecBuilder()
                .addRequestSpecification(SetupSpecs.setupSpec())
                .setContentType(ContentType.JSON)
                .build()
        ;
    }
}
