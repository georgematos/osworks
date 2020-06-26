package com.octowallet.osworks.domain.services;

import com.octowallet.osworks.api.exceptionhandler.customexceptions.DomainException;
import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository repository;

  public ClienteService() {}

  public Cliente salvar(Cliente cliente) {
    var record = repository.findByEmail(cliente.getEmail());

    if (record.isPresent()) {
      throw new DomainException("esse email já existe, tente outro.");
    }

    return repository.save(cliente);
  }

  public Cliente atualizar(Long id, Cliente cliente) {
    var entity = repository
      .findById(id)
      .map(record -> {
          record.setNome(cliente.getNome());
          record.setEmail(cliente.getEmail());
          record.setTelefone(cliente.getTelefone());

          return record;
        }
      )
      .orElse(null);

    if (entity == null) {
      return entity;
    }
    
    var clienteFromEmail = repository.findByEmail(cliente.getEmail()).orElse(null);
  
    if (clienteFromEmail != null && clienteFromEmail.getId() != entity.getId()) {
        throw new DomainException("esse email já existe, tente outro.");
      }

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
