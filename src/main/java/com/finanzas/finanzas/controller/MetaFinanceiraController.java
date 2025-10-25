package com.finanzas.finanzas.controller;

import com.finanzas.finanzas.model.MetaFinanceira;
import com.finanzas.finanzas.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
@CrossOrigin(origins = "http://localhost:3000")
public class MetaFinanceiraController {

    @Autowired
    private MetaFinanceiraRepository metaFinanceiraRepository;

    @GetMapping
    public List<MetaFinanceira> getAllMetas(@RequestParam String userId) {
        return metaFinanceiraRepository.findByUserId(userId);
    }

    @PostMapping
    public MetaFinanceira createMeta(@RequestBody MetaFinanceira meta, @RequestParam String userId) {
        meta.setUserId(userId);
        meta.setValorAtual(meta.getValorAtual() != null ? meta.getValorAtual() : new java.math.BigDecimal("0.00"));
        return metaFinanceiraRepository.save(meta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaFinanceira> updateMeta(
            @PathVariable Long id,
            @RequestBody MetaFinanceira metaDetails,
            @RequestParam String userId) {

        return metaFinanceiraRepository.findById(id)
                .map(meta -> {
                    if (!meta.getUserId().equals(userId)) {
                        return ResponseEntity.status(403).<MetaFinanceira>build();
                    }

                    meta.setNomeMeta(metaDetails.getNomeMeta());
                    meta.setValorObjetivo(metaDetails.getValorObjetivo());
                    meta.setValorAtual(metaDetails.getValorAtual());
                    meta.setDataLimite(metaDetails.getDataLimite());
                    meta.setCategoria(metaDetails.getCategoria());

                    MetaFinanceira updatedMeta = metaFinanceiraRepository.save(meta);
                    return ResponseEntity.ok(updatedMeta);
                })
                .orElseGet(() -> ResponseEntity.notFound().<MetaFinanceira>build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeta(@PathVariable Long id, @RequestParam String userId) {
        return metaFinanceiraRepository.findById(id).map(meta -> {
            if (!meta.getUserId().equals(userId)) {
                return ResponseEntity.status(403).build(); // Proibido
            }
            metaFinanceiraRepository.delete(meta);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}