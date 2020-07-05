package com.octowallet.osworks.domain.dto;

import com.octowallet.osworks.domain.model.StatusOrdemServico;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrdemDeServicoDTO {
  private Long id;
  private String cliente;
  private String descricao;
  private BigDecimal preco;
  private StatusOrdemServico status;
  private OffsetDateTime dataAbertura;
  private OffsetDateTime dataFinalizacao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getcliente() {
    return cliente;
  }

  public void setcliente(String cliente) {
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

  public StatusOrdemServico getStatus() {
    return status;
  }

  public void setStatus(StatusOrdemServico status) {
    this.status = status;
  }

  public OffsetDateTime getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(OffsetDateTime dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public OffsetDateTime getDataFinalizacao() {
    return dataFinalizacao;
  }

  public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
    this.dataFinalizacao = dataFinalizacao;
  }
}
