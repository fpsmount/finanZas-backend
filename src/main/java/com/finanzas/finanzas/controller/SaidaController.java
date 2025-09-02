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
    public List<Saida> getAllSaidas(@RequestParam String userId) {
        return saidaRepository.findByUserId(userId);
    }

    @PostMapping
    public Saida createSaida(@RequestBody Saida saida, @RequestParam String userId) {
        saida.setUserId(userId);
        return saidaRepository.save(saida);
    }

    @GetMapping("/{id}")
    public Saida getSaidaById(@PathVariable Long id, @RequestParam String userId) {
        return saidaRepository.findById(id).filter(s -> s.getUserId().equals(userId)).orElse(null);
    }

    @PutMapping("/{id}")
    public Saida updateSaida(@PathVariable Long id, @RequestBody Saida saidaDetails, @RequestParam String userId) {
        Saida saida = saidaRepository.findById(id).orElse(null);
        if (saida != null && saida.getUserId().equals(userId)) {
            saida.setDescricao(saidaDetails.getDescricao());
            saida.setValor(saidaDetails.getValor());
            saida.setData(saidaDetails.getData());
            saida.setTipo(saidaDetails.getTipo());
            return saidaRepository.save(saida);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSaida(@PathVariable Long id, @RequestParam String userId) {
        Saida saida = saidaRepository.findById(id).orElse(null);
        if (saida != null && saida.getUserId().equals(userId)) {
            saidaRepository.deleteById(id);
        }
    }
}