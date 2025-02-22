package com.firstTrial.demo.logging;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PineconeLogAppender extends AppenderBase<ILoggingEvent> {

    private String pineconeApiKey = "pcsk_5Zs2pR_DHZzF7nQa4HcJDYsbDfLL5DXBpn2BxZXb55u39zhDLzGRCZfGG1hXGT9tXk7szb";
    // pineconeIndexUrl should be your index base URL (e.g. https://your-index.svc.us-west1-gcp.pinecone.io)
    private String pineconeIndexUrl = "https://logs-vector-0zldvla.svc.aped-4627-b74a.pinecone.io";
    private RestTemplate restTemplate;
    // Executor for asynchronous HTTP calls
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void start() {
        this.restTemplate = new RestTemplate();
        super.start();
    }

    @Override
    protected void append(ILoggingEvent event) {
        try {
            // Generate a unique vector id
            String vectorId = "log-" + event.getTimeStamp() + "-" + UUID.randomUUID().toString();

            // Convert log message to an embedding vector (dummy logic; replace with your actual embedding method)
            float[] vectorArray = getEmbeddingFromLog(event.getFormattedMessage());
            List<Float> vectorValues = new ArrayList<>();
            for (float v : vectorArray) {
                vectorValues.add(v);
            }

            // Create metadata from the log event details
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("timestamp", event.getTimeStamp());
            metadata.put("level", event.getLevel().toString());
            metadata.put("message", event.getFormattedMessage());

            // Build the PineconeVector object
            PineconeVector pineconeVector = new PineconeVector(vectorId, vectorValues, metadata);

            // Wrap it into an upsert request (Pinecone expects a JSON object with a "vectors" array)
            PineconeUpsertRequest upsertRequest = new PineconeUpsertRequest(Collections.singletonList(pineconeVector));

            // Asynchronously send the upsert request
            executorService.submit(() -> {
                try {
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Api-Key", pineconeApiKey);
                    headers.setContentType(MediaType.APPLICATION_JSON);

                    HttpEntity<PineconeUpsertRequest> entity = new HttpEntity<>(upsertRequest, headers);
                    // The endpoint is typically /vectors/upsert as per Pinecone docs.
                    String url = pineconeIndexUrl + "/vectors/upsert";

                    // Execute the POST request
                    String response = restTemplate.postForObject(url, entity, String.class);
                    // Optionally log or process the response if needed
                } catch (Exception e) {
                    addError("Error sending log vector to Pinecone", e);
                }
            });
        } catch (Exception e) {
            addError("Error processing log event", e);
        }
    }

    // we need to replace for actual format
    private float[] getEmbeddingFromLog(String logMessage) {
        return new float[]{0.1f, 0.2f, 0.3f};
    }

    public void setPineconeApiKey(String pineconeApiKey) {
        this.pineconeApiKey = pineconeApiKey;
    }

    public void setPineconeIndexUrl(String pineconeIndexUrl) {
        this.pineconeIndexUrl = pineconeIndexUrl;
    }
}
