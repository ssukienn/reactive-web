package pl.edu.agh.sukiennik.thesis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.sukiennik.thesis.Message;
import pl.edu.agh.sukiennik.thesis.MessageAck;
import pl.edu.agh.sukiennik.thesis.services.FilterHandler;

import java.util.List;

@RestController
public class FilterController {

    private final FilterHandler filterHandler;

    public FilterController(FilterHandler filterHandler) {
        this.filterHandler = filterHandler;
    }

    @RequestMapping("/sync/filter")
    public ResponseEntity<MessageAck> handleFilter(@RequestBody Message message) {
        return ResponseEntity.ok(
                filterHandler.handleFilter(message)
        );
    }

    @RequestMapping("/sync/filter/multiple")
    public ResponseEntity<List<MessageAck>> handleFilterMultiple(@RequestBody Message message) {
        return ResponseEntity.ok(
                filterHandler.handleFilterMultiple(message)
        );
    }
}
