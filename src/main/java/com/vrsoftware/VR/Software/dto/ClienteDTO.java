package com.vrsoftware.VR.Software.dto;

import com.vrsoftware.VR.Software.entities.Cliente;

public class ClienteDTO {

    public Long id;
    public String codigo;
    public String nome;
    public Double limiteCompra;
    public Integer fechamentoFatura;

    public ClienteDTO() {

    }

    public ClienteDTO(Long id, String codigo, String nome, Double limiteCompra, Integer fechamentoFatura) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.limiteCompra = limiteCompra;
        this.fechamentoFatura = fechamentoFatura;
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        limiteCompra = cliente.getLimiteCompra();
        fechamentoFatura = cliente.getFechamentoFatura();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLimiteCompra() {
        return limiteCompra;
    }

    public void setLimiteCompra(Double limiteCompra) {
        this.limiteCompra = limiteCompra;
    }

    public Integer getFechamentoFatura() {
        return fechamentoFatura;
    }

    public void setFechamentoFatura(Integer fechamentoFatura) {
        this.fechamentoFatura = fechamentoFatura;
    }
}