package com.octowallet.osworks.domain.repository;

import java.util.List;
import java.util.Optional;

import com.octowallet.osworks.domain.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<List<Cliente>> findByNome(String nome);

    Optional<Cliente> findByEmail(String email);
}