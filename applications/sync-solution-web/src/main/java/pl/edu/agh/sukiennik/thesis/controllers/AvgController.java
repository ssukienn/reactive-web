package pl.edu.agh.sukiennik.thesis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;
import pl.edu.agh.sukiennik.thesis.services.AvgHandler;

import java.util.List;

@RestController
public class AvgController {

    private final AvgHandler avgHandler;

    public AvgController(AvgHandler avgHandler) {
        this.avgHandler = avgHandler;
    }

    @RequestMapping("/sync/average")
    public ResponseEntity<Integer> handleAvg(@RequestBody Message message) {
        return ResponseEntity.ok(
                avgHandler.handleAvg(message)
        );
    }

    @RequestMapping("/sync/average/multiple")
    public ResponseEntity<Double> handleAvgMultiple(@RequestBody Message message) {
        return ResponseEntity.ok(
                avgHandler.handleAvgMultiple(message)
        );
    }
}
