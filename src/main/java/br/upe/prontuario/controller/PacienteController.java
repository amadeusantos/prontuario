package br.upe.prontuario.controller;

import br.upe.prontuario.domain.Paciente;
import br.upe.prontuario.domain.dto.PacienteDTO;
import br.upe.prontuario.service.PacienteService;
import br.upe.prontuario.utils.ProntuarioException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaePaciente(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPaciente(id));
        } catch (ProntuarioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                throw new ProntuarioException(String.join("; ", result.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
            }
            return ResponseEntity.status(201).body(pacienteService.adicionarPaciente(pacienteDTO));
        } catch (ProntuarioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarPaciente(@PathVariable Long id, @RequestBody @Valid PacienteDTO pacienteDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                throw new ProntuarioException(String.join("; ", result.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
            }
            return ResponseEntity.ok(pacienteService.alterarPaciente(id, pacienteDTO));
        } catch (ProntuarioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPaciente(@PathVariable Long id) {
        try {
            pacienteService.excluirPaciente(id);
            return ResponseEntity.noContent().build();
        } catch (ProntuarioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
