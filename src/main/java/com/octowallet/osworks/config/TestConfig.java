package com.octowallet.osworks.config;

import com.octowallet.osworks.domain.model.Cliente;
import com.octowallet.osworks.domain.repository.ClienteRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
  private ClienteRepository clienteRepository;

  @Autowired
  public TestConfig(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    var cliente1 = new Cliente(
      "Fulano da Silva",
      "fulano@email.com",
      "9999-9999"
    );
    var cliente2 = new Cliente(
      "Ciclano de Oliveira",
      "ciclano@email.com",
      "9999-8888"
    );
    var cliente3 = new Cliente(
      "Beltrano de Matos",
      "beltrano@email.com",
      "9999-7777"
    );
    var cliente4 = new Cliente(
      "Josefa da Mata",
      "josefa@email.com",
      "9999-6666"
    );

    clienteRepository.saveAll(
      Arrays.asList(cliente1, cliente2, cliente3, cliente4)
    );
  }
}
