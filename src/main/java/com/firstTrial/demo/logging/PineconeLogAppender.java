package com.firstTrial.demo.logging;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PineconeLogAppender extends AppenderBase<ILoggingEvent> {

    private String pineconeApiKey;
    private String pineconeIndexUrl;
    private RestTemplate restTemplate;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void start() {
        this.restTemplate = new RestTemplate();
        super.start();
    }

    @Override
    protected void append(ILoggingEvent event) {
        try {
            float[] vector = getEmbeddingFromLog(event.getFormattedMessage());
            LogPayload payload = new LogPayload(
                    event.getTimeStamp(),
                    event.getLevel().toString(),
                    event.getFormattedMessage(),
                    vector
            );
            executorService.submit(() -> {
                try {
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Api-Key", pineconeApiKey);
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    HttpEntity<LogPayload> entity = new HttpEntity<>(payload, headers);
                    String url = pineconeIndexUrl + "/upsert";
                    String response = restTemplate.postForObject(url, entity, String.class);
                } catch (Exception e) {
                    addError("Error sending log to Pinecone", e);
                }
            });
        } catch (Exception e) {
            addError("Error processing log event", e);
        }
    }

    private float[] getEmbeddingFromLog(String logMessage) {
        // Rwe need actual embedding logic. for logs print
        return new float[]{0.1f, 0.2f, 0.3f};
    }

    public void setPineconeApiKey(String pineconeApiKey) {
        this.pineconeApiKey = pineconeApiKey;
    }

    public void setPineconeIndexUrl(String pineconeIndexUrl) {
        this.pineconeIndexUrl = pineconeIndexUrl;
    }
}
