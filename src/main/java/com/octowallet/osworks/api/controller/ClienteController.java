package com.octowallet.osworks.api.controller;

import java.util.List;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok().body(clienteService.getClientes());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(clienteService.getClientesPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> oberPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(clienteService.getClientePorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        var clienteSalvo = clienteService.salvarCliente(cliente);
        
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        
        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente) {
        var clienteSalvo = clienteService.atualizarCliente(cliente);
        
        return ResponseEntity.ok().body(clienteSalvo);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}