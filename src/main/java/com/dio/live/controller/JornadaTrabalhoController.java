package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(jornadaService.findById(id).orElseThrow(() -> new NoSuchElementException("Not found")));
    }

    @PutMapping(value = "/{id}")
    public JornadaTrabalho updateJornada(@PathVariable Long id, @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(id, jornadaTrabalho);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
