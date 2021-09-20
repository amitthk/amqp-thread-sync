package com.boot.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EntityUtils {
    public static HashMap<String,Object> getNonNulFields(Object objectToDeserialize) throws IOException {
        final Gson gson = new Gson();
        final HashMap<String, Object> result = new ObjectMapper().readValue(gson.toJson(objectToDeserialize),
                new TypeReference<Map<String, Object>>() {
                });
        return result;
    }
}
