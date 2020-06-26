package com.octowallet.osworks.domain.services;

import java.time.LocalDateTime;

import com.octowallet.osworks.domain.model.OrdemDeServico;
import com.octowallet.osworks.domain.model.StatusOrdemServico;
import com.octowallet.osworks.domain.repository.OrdemDeServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemDeServicoService {
    
    @Autowired
    public OrdemDeServicoRepository repository;

    public OrdemDeServico criar(OrdemDeServico ordem) {

        ordem.setStatus(StatusOrdemServico.ABERTA);
        ordem.setDataAbertura(LocalDateTime.now());

        return repository.save(ordem);   
    }

}