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
public class PassthroughHandler {

    private final RestTemplate restTemplate;

    private final String targetHost;

    public PassthroughHandler(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${loadtarget.host}") String targetHost
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.targetHost = targetHost;
    }


    public MessageAck handlePassthrough(Message message) {
        ResponseEntity<MessageAck> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages", message, MessageAck.class);
        MessageAck messageAck = responseEntity.getBody();

        //some logic transforming the response

        return  messageAck;
    }

    public List<MessageAck> handlePassthroughMultiple(Message message) {
        ResponseEntity<MessageAck[]> responseEntity = this.restTemplate.postForEntity(targetHost + "/messages/multiple", message, MessageAck[].class);
        MessageAck[] messageAcks = responseEntity.getBody();

        //example of some transforming logic
        List<MessageAck> list = Arrays.stream(messageAcks).collect(Collectors.toList());

        return list;
    }
}
