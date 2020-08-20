package pl.edu.agh.sukiennik.thesis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;
import pl.edu.agh.sukiennik.thesis.services.MapHandler;

import java.util.List;

@RestController
public class MapController {

    private final MapHandler mapHandler;

    public MapController(MapHandler passthroughHandler) {
        this.mapHandler = passthroughHandler;
    }

    @RequestMapping("/sync/map")
    public ResponseEntity<MessageAck> handlePassthrough(@RequestBody Message message) {
        return ResponseEntity.ok(
                mapHandler.handleMap(message)
        );
    }

    @RequestMapping("/sync/map/multiple")
    public ResponseEntity<List<MessageAck>> handlePassthroughMultiple(@RequestBody Message message) {
        return ResponseEntity.ok(
                mapHandler.handleMapMultiple(message)
        );
    }
}
