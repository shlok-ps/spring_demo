package com.firstTrial.demo.logging;

import java.util.List;
import java.util.Map;

public class PineconeVector {
    private String id;
    private List<Float> values;
    private Map<String, Object> metadata;

    public PineconeVector() {
    }

    public PineconeVector(String id, List<Float> values, Map<String, Object> metadata) {
        this.id = id;
        this.values = values;
        this.metadata = metadata;
    }

    // Getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Float> getValues() {
        return values;
    }
    public void setValues(List<Float> values) {
        this.values = values;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
