package com.octowallet.osworks.domain.model;

import com.octowallet.osworks.domain.dto.ClienteDTO;
import java.math.BigDecimal;

public class OrdemDeServicoModelInput {
  private ClienteDTO cliente;
  private String descricao;
  private BigDecimal preco;

  public ClienteDTO getCliente() {
    return cliente;
  }

  public void setCliente(ClienteDTO cliente) {
    this.cliente = cliente;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
