package com.example.demo.service;

import com.example.demo.pojo.County;
import com.example.demo.read.JsonReader;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CountryService {

  private static final String DE = "de";
  private final Predicate<County> dePredicate =
      c -> c.getLanguages().stream().anyMatch(l -> l.equalsIgnoreCase(DE));
  private final List<County> countyList;

  public CountryService(final JsonReader jsonReader) {
    countyList = jsonReader.readJson();
  }

  public int getCountriesInWorld() {
    return countyList.size();
  }

  public List<String> getCountriesThatSpeakDe() {
    return countyList.stream()
        .filter(dePredicate)
        .map(County::getCountry)
        .collect(Collectors.toList());
  }

  public long getCountAllLanguages() {
    return countyList.stream()
        .map(County::getLanguages)
        .flatMap(Collection::stream)
        .distinct()
        .count();
  }

  public String getCountryWithHighestNumberOfLanguages() {

    return countyList.stream()
        .collect(Collectors.toMap(Function.identity(), county -> county.getLanguages().size()))
        .entrySet()
        .stream()
        .max(Comparator.comparingLong(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .map(County::getCountry)
        .orElse(Strings.EMPTY);
  }

  public String getMostCommonLanguage() {
    return countyList.stream()
        .map(County::getLanguages)
        .flatMap(Collection::stream)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(Strings.EMPTY);
  }
}
