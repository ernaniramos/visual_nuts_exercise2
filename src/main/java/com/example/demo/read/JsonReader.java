package com.example.demo.read;

import com.example.demo.config.AppConfiguration;
import com.example.demo.exception.InvalidJsonException;
import com.example.demo.pojo.County;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class JsonReader {

    private final AppConfiguration appConfiguration;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonReader(final AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public List<County> readJson() {
    try (InputStream inputStream =
        Thread.currentThread()
            .getContextClassLoader()
            .getResourceAsStream(appConfiguration.getFileName())) {
            return mapper.readValue(inputStream ,
                    new TypeReference<List<County>>(){});
        }
        catch(Exception e){
            throw new InvalidJsonException("Invalid Json", e);
        }
    }
}
