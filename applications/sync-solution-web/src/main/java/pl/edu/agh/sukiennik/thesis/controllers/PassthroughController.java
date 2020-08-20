package pl.edu.agh.sukiennik.thesis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;
import pl.edu.agh.sukiennik.thesis.services.PassthroughHandler;

import java.util.List;

@RestController
public class PassthroughController {

    private final PassthroughHandler passthroughHandler;

    public PassthroughController(PassthroughHandler passthroughHandler) {
        this.passthroughHandler = passthroughHandler;
    }

    @RequestMapping("/passthrough/messages")
    public ResponseEntity<MessageAck> handlePassthrough(@RequestBody Message message) {
        return ResponseEntity.ok(
                passthroughHandler.handlePassthrough(message)
        );
    }

    @RequestMapping("/passthrough/messages/multiple")
    public ResponseEntity<List<MessageAck>> handlePassthroughMultiple(@RequestBody Message message) {
        return ResponseEntity.ok(
                passthroughHandler.handlePassthroughMultiple(message)
        );
    }
}
