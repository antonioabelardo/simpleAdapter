package com.example.exercicio;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Produto {

  Long id;
  String cliente;
  String data;
  String produto;
  BigDecimal valor;

  public Produto(Long id, String cliente, String data, String produto , BigDecimal valor){
      this.id = id;
      this.cliente = cliente;
      this.data = data;
      this.produto = produto;
      this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", cliente='" + cliente + '\'' +
                ", data='" + data + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
