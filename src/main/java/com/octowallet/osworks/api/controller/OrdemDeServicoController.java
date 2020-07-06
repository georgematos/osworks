package com.octowallet.osworks.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.octowallet.osworks.domain.dto.OrdemDeServicoDTO;
import com.octowallet.osworks.domain.model.OrdemDeServico;
import com.octowallet.osworks.domain.repository.OrdemDeServicoRepository;
import com.octowallet.osworks.domain.services.OrdemDeServicoService;

import org.modelmapper.ModelMapper;
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

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  public ResponseEntity<List<OrdemDeServicoDTO>> listar() {
    
    List<OrdemDeServicoDTO> ordens = new ArrayList<>();
    
    repository.findAll().stream().forEach(ordem -> {
      ordens.add(modelMapper.map(ordem, OrdemDeServicoDTO.class));
    });
    
    return ResponseEntity.ok().body(ordens);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<OrdemDeServicoDTO> obterPorId(@PathVariable Long id) {
    return repository
      .findById(id)
      .map(record -> ResponseEntity.ok().body(modelMapper.map(record, OrdemDeServicoDTO.class)))
      .orElse(ResponseEntity.notFound().build());
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
