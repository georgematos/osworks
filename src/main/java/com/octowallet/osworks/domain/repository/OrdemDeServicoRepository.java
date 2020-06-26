package com.octowallet.osworks.domain.repository;

import com.octowallet.osworks.domain.model.OrdemDeServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {
    
}