package com.octowallet.osworks.domain.services;

import java.util.List;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteService() {

    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public List<Cliente> getClientesPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public Cliente getClientePorId(Long id) {
        return repository.findById(id).get();
    }

}