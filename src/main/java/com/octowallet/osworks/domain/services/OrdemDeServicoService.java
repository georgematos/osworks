package com.octowallet.osworks.domain.services;

import java.time.LocalDateTime;

import com.octowallet.osworks.api.exceptionhandler.customexceptions.DomainException;
import com.octowallet.osworks.domain.model.OrdemDeServico;
import com.octowallet.osworks.domain.model.StatusOrdemServico;
import com.octowallet.osworks.domain.repository.ClienteRepository;
import com.octowallet.osworks.domain.repository.OrdemDeServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class OrdemDeServicoService {

    @Autowired
    public ClienteRepository cliRepository;
    
    @Autowired
    public OrdemDeServicoRepository repository;

    public OrdemDeServico criar(OrdemDeServico ordem) throws NotFoundException {

        ordem.setStatus(StatusOrdemServico.ABERTA);
        ordem.setDataAbertura(LocalDateTime.now());
        var cliente = cliRepository.findById(ordem.getCliente().getId()).orElseThrow(() -> new DomainException("Cliente não encontrado."));
        ordem.setCliente(cliente);

        return repository.save(ordem);
    }

}