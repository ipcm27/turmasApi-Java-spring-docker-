package com.letscode.turmasapiigor.controller;

import com.letscode.turmasapiigor.domain.Turma;
import com.letscode.turmasapiigor.repository.TurmaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping(path="/turma")
public class TurmaController {

    private final TurmaRepository turmaRepository;

    public TurmaController(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @PostMapping(path="/add")
    public ResponseEntity<Turma> addNewTurma(@RequestBody Turma turma){
            Turma persistedTurma = this.turmaRepository.save(turma);
            return ResponseEntity.created(URI.create(String.format("/turma/%s", persistedTurma.getId()))).body(persistedTurma);
    };

    @GetMapping(path ="/{id}")
    public ResponseEntity<Turma> getTurma(@PathVariable String id){
        Optional<Turma> turma = this.turmaRepository.findById(id);

        if (turma.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turma.get());
    }
}
