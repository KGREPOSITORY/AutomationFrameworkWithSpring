package com.example.testdemo.utils;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
@Slf4j
public class FakerUtil {
    private final Faker faker = new Faker(new Locale("en-GB"));

    @Value("${generatedData.validPhoneNumberPattern}")
    private String validPhoneRegex;

    public String getValidName(){
        String name = faker.name().firstName();
        log.info("Generated name : " + name);
        return name;
    }

    public String getValidLastName(){
        String lastName = faker.pokemon().name();
        log.info("Generated last name : " + lastName);
        return lastName;
    }

    public String getValidNumber(){
        String number = faker.regexify(validPhoneRegex);
        log.info("Generated phone number : "+number);
        return number;
    }
}
