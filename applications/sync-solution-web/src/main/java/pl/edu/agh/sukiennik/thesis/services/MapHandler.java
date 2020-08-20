package pl.edu.agh.sukiennik.thesis.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapHandler {

    private final RestTemplate restTemplate;

    private final String targetHost;

    public MapHandler(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${loadtarget.host}") String targetHost
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.targetHost = targetHost;
    }

    private MessageAck mapper(MessageAck msg) {
        return new MessageAck(msg.getId().toUpperCase(), msg.getReceived().toUpperCase(), "ack".toUpperCase());
    }

    public MessageAck handleMap(Message message) {
        ResponseEntity<MessageAck> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages", message, MessageAck.class);
        MessageAck messageAck = responseEntity.getBody();

        return this.mapper(messageAck);
    }

    public List<MessageAck> handleMapMultiple(Message message) {
        ResponseEntity<MessageAck[]> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages/multiple", message, MessageAck[].class);
        MessageAck[] messageAcks = responseEntity.getBody();

        return Arrays.stream(messageAcks).map(this::mapper).collect(Collectors.toList());
    }
}
