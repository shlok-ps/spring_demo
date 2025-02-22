package com.firstTrial.demo.logging;

import java.util.List;

public class PineconeUpsertRequest {
    private List<PineconeVector> vectors;

    public PineconeUpsertRequest() {
    }

    public PineconeUpsertRequest(List<PineconeVector> vectors) {
        this.vectors = vectors;
    }

    public List<PineconeVector> getVectors() {
        return vectors;
    }
    public void setVectors(List<PineconeVector> vectors) {
        this.vectors = vectors;
    }
}
