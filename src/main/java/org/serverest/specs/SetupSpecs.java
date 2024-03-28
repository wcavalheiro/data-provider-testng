package org.serverest.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.serverest.utils.Manipulation;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class SetupSpecs {
    private SetupSpecs(){}
    public static RequestSpecification setupSpec(){

        return new RequestSpecBuilder()
                .setBaseUri(Manipulation.getProp().getProperty("baseUrl"))
                .setPort(3000)
                .setConfig(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build()
        ;
    }

}
