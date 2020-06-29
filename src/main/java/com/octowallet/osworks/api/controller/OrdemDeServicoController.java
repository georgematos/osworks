package com.octowallet.osworks.api.controller;

import com.octowallet.osworks.domain.model.OrdemDeServico;
import com.octowallet.osworks.domain.repository.OrdemDeServicoRepository;
import com.octowallet.osworks.domain.services.OrdemDeServicoService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.NotFoundException;

@RestController
@RequestMapping("/ordens-de-servico")
public class OrdemDeServicoController {
  @Autowired
  private OrdemDeServicoRepository repository;

  @Autowired
  private OrdemDeServicoService service;

  @GetMapping
  public ResponseEntity<List<OrdemDeServico>> listar() {
    return ResponseEntity.ok().body(repository.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<OrdemDeServico> obterPorId(@PathVariable Long id) {
    return repository
      .findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.badRequest().build());
  }

  @PostMapping
  public ResponseEntity<OrdemDeServico> salvarOrdem(
    @Valid @RequestBody OrdemDeServico ordem
  ) throws NotFoundException {
    var savedEntity = service.criar(ordem);

    var uri = ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("{id}")
      .build()
      .toUri();

    return ResponseEntity.created(uri).body(savedEntity);
  }
}
