#Exercise 2
#### Image you have a set of data in JSON, describing official languages spoken by countries, as such:
```json
[
  {
    "country": "US",
    "languages": [
      "en"
    ]
  },
  {
    "country": "BE",
    "languages": [
      "nl",
      "fr",
      "de"
    ]
  },
  {
    "country": "NL",
    "languages": [
      "nl",
      "fy"
    ]
  },
  {
    "country": "DE",
    "languages": [
      "de"
    ]
  },
  {
    "country": "ES",
    "languages": [
      "es"
    ]
  }
]
```

### Write a function in Java that:

- returns the number of countries in the world
- finds the country with the most official languages, where they officially speak German (de). 
- that counts all the official languages spoken in the listed countries.
- to find the country with the highest number of official languages.
- to find the most common official language(s), of all countries.

### Run app
```shell
./mvnw spring-boot:run
```