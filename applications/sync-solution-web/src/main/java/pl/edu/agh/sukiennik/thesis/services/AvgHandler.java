package pl.edu.agh.sukiennik.thesis.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;

import java.util.Arrays;
import java.util.OptionalDouble;

@Component
public class AvgHandler {

    private final RestTemplate restTemplate;

    private final String targetHost;

    public AvgHandler(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${loadtarget.host}") String targetHost
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.targetHost = targetHost;
    }


    public Integer handleAvg(Message message) {
        ResponseEntity<MessageAck> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages", message, MessageAck.class);
        MessageAck messageAck = responseEntity.getBody();

        return messageAck.getId().hashCode();
    }

    public Double handleAvgMultiple(Message message) {
        ResponseEntity<MessageAck[]> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages/multiple", message, MessageAck[].class);
        MessageAck[] messageAcks = responseEntity.getBody();

        OptionalDouble avg = Arrays.stream(messageAcks).mapToInt(value -> value.getId().hashCode()).average();

        return avg.orElse(0);
    }
}
