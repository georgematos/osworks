package com.octowallet.osworks.api.controller;

import java.util.List;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar() {

        return clienteService.getClientes();
    }
}