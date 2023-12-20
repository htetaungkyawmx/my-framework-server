package org.example.framework.model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model {
    private Map<String, String> hashMap = new HashMap<>();

    @Override
    public void set(String name, String value) {
        hashMap.put(name, value);
    }

    @Override
    public String get(String name) {
        return hashMap.get(name);
    }
}
