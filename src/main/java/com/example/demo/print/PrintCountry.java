package com.example.demo.print;

import com.example.demo.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PrintCountry {

  private final CountryService countryService;

  PrintCountry(CountryService countryService) {
    this.countryService = countryService;
  }

  @PostConstruct
  private void print() {
    getCountriesInWorld();
    getCountriesThatSpeakDe();
    getCountAllLanguages();
    getCountryWithHighestNumberOfLanguages();
    getMostCommonLanguage();
  }

  public void getCountriesInWorld() {
    System.out.println(
        String.format(
            "The number of countries in the world are: %d", countryService.getCountriesInWorld()));
  }

  public void getCountriesThatSpeakDe() {
    String collect =
            String.join(",", countryService.getCountriesThatSpeakDe());
    System.out.println(
        String.format(
            "The countries with the most official languages, where they officially speak German (de) are: %s",
            collect));
  }

  public void getCountAllLanguages() {
    System.out.println(String.format("All the official languages spoken in the listed countries: %d", countryService.getCountAllLanguages()));
  }

  public void getCountryWithHighestNumberOfLanguages() {
    System.out.println(String.format("The country with the highest number of official languages is: %s", countryService.getCountryWithHighestNumberOfLanguages()));
  }

  public void getMostCommonLanguage() {
    System.out.println(String.format("The most common official language(s), of all countries is: %s", countryService.getMostCommonLanguage()));
  }
}
