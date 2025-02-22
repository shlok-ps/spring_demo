package com.firstTrial.demo.logging;

public class LogPayload {
    private long timestamp;
    private String level;
    private String message;
    private float[] vector;

    public LogPayload(long timestamp, String level, String message, float[] vector) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
        this.vector = vector;
    }

    // Getters and setters
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public float[] getVector() {
        return vector;
    }
    public void setVector(float[] vector) {
        this.vector = vector;
    }
}

