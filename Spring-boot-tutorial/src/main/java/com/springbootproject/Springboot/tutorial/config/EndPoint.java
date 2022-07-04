package com.springbootproject.Springboot.tutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class EndPoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    public EndPoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(String featureName){
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
