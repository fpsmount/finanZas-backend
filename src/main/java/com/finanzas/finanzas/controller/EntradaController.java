package com.finanzas.finanzas.controller;

import com.finanzas.finanzas.model.Entrada;
import com.finanzas.finanzas.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    @Autowired
    private EntradaRepository entradaRepository;

    @GetMapping
    public List<Entrada> getAllEntradas() {
        return entradaRepository.findAll();
    }

    @PostMapping
    public Entrada createEntrada(@RequestBody Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @GetMapping("/{id}")
    public Entrada getEntradaById(@PathVariable Long id) {
        return entradaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Entrada updateEntrada(@PathVariable Long id, @RequestBody Entrada entradaDetails) {
        Entrada entrada = entradaRepository.findById(id).orElse(null);
        if (entrada != null) {
            entrada.setDescricao(entradaDetails.getDescricao());
            entrada.setValor(entradaDetails.getValor());
            entrada.setData(entradaDetails.getData());
            entrada.setSalario(entradaDetails.isSalario());
            return entradaRepository.save(entrada);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEntrada(@PathVariable Long id) {
        entradaRepository.deleteById(id);
    }
}