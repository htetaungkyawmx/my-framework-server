package org.example.framework.util;

import org.example.framework.controller.ControllerMapping;
import org.example.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationControllersFinder {

    public Map<String , IController> findControllers() {
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::getAsControllerClass)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));

    }

    private IController getControllerInstance(Class<IController> iControllerClass) {
        try {
            return iControllerClass.getConstructor().newInstance();
        }catch (Exception e) {
            throw new RuntimeException("Cannot create for IController Class.");
        }
    }

    private Class<IController> getAsControllerClass(Class<?> controller) {
        return (Class<IController>) controller;
    }

    private String getUri(IController icontroller) {
        return icontroller.getClass().getAnnotation(ControllerMapping.class)
                .value();
    }
}
