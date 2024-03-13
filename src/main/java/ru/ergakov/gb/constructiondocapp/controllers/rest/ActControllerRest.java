package ru.ergakov.gb.constructiondocapp.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ergakov.gb.constructiondocapp.model.Act;
import ru.ergakov.gb.constructiondocapp.service.ActService;

import java.util.List;

@RestController
@RequestMapping("/acts-rest")
@RequiredArgsConstructor
public class ActControllerRest {
    private final ActService actService;
    @GetMapping
    public ResponseEntity<List<Act>> findAll() {
        return new ResponseEntity<>(actService.getAllActs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Act> createAct(@RequestBody Act act) {
        return new ResponseEntity<>(actService.createAct(act), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAct(@PathVariable("id") Long id) {
        actService.deleteAct(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Void> updateProduct(@RequestBody Act act) {
        actService.updateAct(act);
        return ResponseEntity.ok().build();
    }
}
