package com.finanzas.finanzas.repository;

import com.finanzas.finanzas.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long> {
}