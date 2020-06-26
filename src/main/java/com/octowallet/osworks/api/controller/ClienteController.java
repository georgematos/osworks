package com.octowallet.osworks.api.controller;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.repository.ClienteRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
  @Autowired
  private ClienteRepository repository;

  @Autowired
  private com.octowallet.osworks.domain.services.ClienteService service;

  @GetMapping
  public ResponseEntity<List<Cliente>> listar() {
    return ResponseEntity.ok().body(repository.findAll());
  }

  @GetMapping("/nome/{nome}")
  public ResponseEntity<List<Cliente>> listarPorNome(
    @PathVariable String nome
  ) {
    return repository
      .findByNome(nome)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> oberPorId(@PathVariable Long id) {
    return repository
      .findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Cliente> salvarCliente(
    @Valid @RequestBody Cliente cliente
  ) {
    var clienteSalvo = service.salvar(cliente);

    var uri = ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("/{id}")
      .buildAndExpand(cliente.getId())
      .toUri();

    return ResponseEntity.created(uri).body(clienteSalvo);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> atualizarCliente(
    @PathVariable Long id,
    @Valid @RequestBody Cliente cliente
  ) {
    var entity = service.atualizar(id, cliente);

    if (entity == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(entity);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
    if (service.deletar(id)) {
      return ResponseEntity.ok().build();
    }

    return ResponseEntity.notFound().build();
  }
}
