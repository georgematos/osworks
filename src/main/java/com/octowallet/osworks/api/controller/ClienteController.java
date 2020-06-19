package com.octowallet.osworks.api.controller;

import java.util.List;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {

        return clienteService.getClientes();
    }

    @GetMapping("/{nome}")
    public List<Cliente> listarPorNome(@PathVariable String nome) {
        return clienteService.getClientesPorNome(nome);
    }

    
}