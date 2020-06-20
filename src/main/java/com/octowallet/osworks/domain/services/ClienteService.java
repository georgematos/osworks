package com.octowallet.osworks.domain.services;

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

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {

        var entity = repository.findById(id).map(record -> {

            record.setNome(cliente.getNome());
            record.setEmail(cliente.getEmail());
            record.setTelefone(cliente.getTelefone());

            return record;

        }).orElse(null);

        return repository.save(entity);
    }

    public Boolean deletar(Long id) {
        var opt = repository.findById(id);

        if (opt.isPresent()) {
            repository.deleteById(id);
            return true;
        }

        return false;

    }

}