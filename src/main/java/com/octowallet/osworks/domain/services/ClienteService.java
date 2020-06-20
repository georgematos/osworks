package com.octowallet.osworks.domain.services;

import java.util.List;
import java.util.Optional;

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
        return repository.findById(id).orElse(null);
    }

    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        var clienteAtual = getClientePorId(cliente.getId());
        var clienteEditado = processarClietenteParaAtualizacao(clienteAtual);
        return repository.save(clienteEditado);
    }

    public Cliente salvarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    private Cliente processarClietenteParaAtualizacao(Cliente clienteNovo) {
        var clienteEditado = new Cliente();
        clienteEditado.setId(clienteNovo.getId());
        clienteEditado.setNome(clienteNovo.getNome());
        clienteEditado.setEmail(clienteNovo.getEmail());
        clienteEditado.setTelefone(clienteNovo.getTelefone());

        return clienteEditado;
    }

}