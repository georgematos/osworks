package com.octowallet.osworks.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.octowallet.osworks.domain.ValidationGroup;

@Entity
public class OrdemDeServico implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Valid
  @ConvertGroup(from = Default.class, to = ValidationGroup.ClienteId.class)
  @NotNull
  @ManyToOne
  private Cliente cliente;

  @NotNull
  private String descricao;

  @NotNull
  private BigDecimal preco;

  @Enumerated(EnumType.STRING)
  @JsonProperty(access = Access.READ_ONLY)
  private StatusOrdemServico status;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime dataAbertura;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime dataFinalizacao;

  public OrdemDeServico() {}

  public OrdemDeServico(
    @NotNull Cliente cliente,
    @NotNull String descricao,
    @NotNull BigDecimal preco,
    StatusOrdemServico status,
    @NotNull LocalDateTime dataAbertura
  ) {
    this.cliente = cliente;
    this.descricao = descricao;
    this.preco = preco;
    this.status = status;
    this.dataAbertura = dataAbertura;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
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

  public LocalDateTime getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(LocalDateTime dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public LocalDateTime getDataFinalizacao() {
    return dataFinalizacao;
  }

  public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
    this.dataFinalizacao = dataFinalizacao;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OrdemDeServico other = (OrdemDeServico) obj;
    if (cliente == null) {
      if (other.cliente != null) return false;
    } else if (!cliente.equals(other.cliente)) return false;
    return true;
  }
}
