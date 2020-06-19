package com.octowallet.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import com.octowallet.osworks.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {

        var c1 = new Cliente("Fulano", "fulano@email.com", "3999-2232");
        var c2 = new Cliente("Beltrano", "beltrano@email.com", "3999-2232");
        var c3 = new Cliente("Ciclano", "ciclano@email.com", "3999-2232");

        return Arrays.asList(c1, c2, c3);
    }
}