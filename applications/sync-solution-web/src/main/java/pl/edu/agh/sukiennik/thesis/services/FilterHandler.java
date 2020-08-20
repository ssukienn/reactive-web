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
public class FilterHandler {

    private final RestTemplate restTemplate;

    private final String targetHost;

    public FilterHandler(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${loadtarget.host}") String targetHost
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.targetHost = targetHost;
    }

    private Boolean filter(MessageAck msg) {
        return msg.getId().hashCode() % 2 == 0;
    }

    public MessageAck handleFilter(Message message) {
        ResponseEntity<MessageAck> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages", message, MessageAck.class);
        MessageAck messageAck = responseEntity.getBody();

        if(filter(messageAck)) {
            return messageAck;
        } else {
            return null;
        }
    }

    public List<MessageAck> handleFilterMultiple(Message message) {
        ResponseEntity<MessageAck[]> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages/multiple", message, MessageAck[].class);
        MessageAck[] messageAcks = responseEntity.getBody();

        return Arrays.stream(messageAcks).filter(this::filter).collect(Collectors.toList());
    }
}
