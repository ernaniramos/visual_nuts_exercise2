package com.example.demo.pojo;

import java.util.List;
import java.util.Objects;

public class County {
    private String country;
    private List<String> languages;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        County county = (County) o;
        return Objects.equals(country, county.country) && Objects.equals(languages, county.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, languages);
    }
}
