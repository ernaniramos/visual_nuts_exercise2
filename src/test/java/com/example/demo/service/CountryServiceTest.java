package com.example.demo.service;

import com.example.demo.config.AppConfiguration;
import com.example.demo.read.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
 class CountryServiceTest {

    private CountryService countryService;

    @BeforeEach
    void init() {
        AppConfiguration appConfiguration;
        JsonReader jsonReader;
        appConfiguration = new AppConfiguration();
        appConfiguration.setFileName("Countries.json");
        jsonReader = new JsonReader(appConfiguration);
        countryService = new CountryService(jsonReader);
    }

    @Test
    void getCountriesInWorld() {
        Assertions.assertEquals(5, countryService.getCountriesInWorld());
    }

    @Test
    void getCountriesThatSpeakDe() {
        String collect =
                countryService.getCountriesThatSpeakDe().stream().map(String::toUpperCase).collect(Collectors.joining(","));
        Assertions.assertEquals("BE,DE", collect);
    }

    @Test
    void getCountAllLanguages() {
        Assertions.assertEquals(6, countryService.getCountAllLanguages());
    }

    @Test
    void getCountryWithHighestNumberOfLanguages() {
        Assertions.assertEquals("BE", countryService.getCountryWithHighestNumberOfLanguages().toUpperCase());
    }

    @Test
    void getMostCommonLanguage() {
        Assertions.assertEquals("DE", countryService.getMostCommonLanguage().toUpperCase());
    }

}
