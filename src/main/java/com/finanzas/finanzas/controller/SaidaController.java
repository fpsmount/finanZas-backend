package com.finanzas.finanzas.controller;

import com.finanzas.finanzas.model.Saida;
import com.finanzas.finanzas.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saidas")
public class SaidaController {

    @Autowired
    private SaidaRepository saidaRepository;

    @GetMapping
    public List<Saida> getAllSaidas() {
        return saidaRepository.findAll();
    }

    @PostMapping
    public Saida createSaida(@RequestBody Saida saida) {
        return saidaRepository.save(saida);
    }

    @GetMapping("/{id}")
    public Saida getSaidaById(@PathVariable Long id) {
        return saidaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Saida updateSaida(@PathVariable Long id, @RequestBody Saida saidaDetails) {
        Saida saida = saidaRepository.findById(id).orElse(null);
        if (saida != null) {
            saida.setDescricao(saidaDetails.getDescricao());
            saida.setValor(saidaDetails.getValor());
            saida.setData(saidaDetails.getData());
            saida.setTipo(saidaDetails.getTipo());
            return saidaRepository.save(saida);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSaida(@PathVariable Long id) {
        saidaRepository.deleteById(id);
    }
}