package org.serverest.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class SetupSpecs {

    public static RequestSpecification setupSpec(){

        return new RequestSpecBuilder()
                .setBaseUri(Manipulation.getProp().getProperty("baseUrl"))
                .setPort(3000)
                .setContentType(ContentType.JSON)
                .setConfig(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build()
                ;
    }
}
