package org.serverest.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AuthSpecs {
    private AuthSpecs(){}
    public static RequestSpecification authSpec(){
        return new RequestSpecBuilder()
                .addRequestSpecification(SetupSpecs.setupSpec())
                .setContentType(ContentType.JSON)
                .build()
        ;
    }
}
