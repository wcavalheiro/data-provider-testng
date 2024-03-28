package org.serverest.utils;

import net.datafaker.Faker;

import java.util.Random;

public class DataFakerGenerator {
    static Faker faker = new Faker();
    static Random random = new Random();

    public static String nomeFaker(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return firstName + " " + lastName;
    }

    public static String emailFaker(){
        return faker.internet().emailAddress();
    }

    public static String senhaFaker(){
        return faker.internet().password();
    }

    public static boolean adminFaker(){
        return random.nextBoolean();
    }

}
