package ru.ergakov.gb.constructiondocapp.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ergakov.gb.constructiondocapp.model.Act;
import ru.ergakov.gb.constructiondocapp.service.ActService;

import java.util.List;

/**
 * Rest-контроллер
 */
@RestController
@RequestMapping("/acts-rest")
@RequiredArgsConstructor
public class ActControllerRest {
    private final ActService actService;

    /**
     * Метод получения списка всех актов
     *
     * @return список всех актов
     */
    @GetMapping
    public ResponseEntity<List<Act>> findAll() {
        return new ResponseEntity<>(actService.getAllActs(), HttpStatus.OK);
    }

    /**
     * Метод добавления акта
     *
     * @param act Акт, переданный в теле запроса
     * @return статус выполнения запроса
     */
    @PostMapping
    public ResponseEntity<Act> createAct(@RequestBody Act act) {
        return new ResponseEntity<>(actService.createAct(act), HttpStatus.CREATED);
    }

    /**
     * Метод удаления акта по id
     *
     * @param id id акта
     * @return статус выполнения запроса
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAct(@PathVariable("id") Long id) {
        actService.deleteAct(id);
        return ResponseEntity.ok().build();
    }

//    /**
//     * Метод изменения акта
//     *
//     * @param act Акт, переданный в теле запроса
//     * @return статус выполнения запроса
//     */
//    @PutMapping
//    @ResponseBody
//    public ResponseEntity<Act> updateProduct(@RequestBody Act act) {
//        return new ResponseEntity<>(actService.updateAct(act), HttpStatus.OK);
//    }
}
