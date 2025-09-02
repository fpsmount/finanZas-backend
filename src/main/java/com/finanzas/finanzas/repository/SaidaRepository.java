package com.finanzas.finanzas.repository;

import com.finanzas.finanzas.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long> {
    List<Saida> findByUserId(String userId);
}