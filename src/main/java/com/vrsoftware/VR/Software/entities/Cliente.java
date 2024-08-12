package com.vrsoftware.VR.Software.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public Double limiteCompra;
    public Integer fechamentoFatura;

    public Cliente() {

    }

    public Cliente(Long id, String nome, Double limiteCompra, Integer fechamentoFatura) {
        this.id = id;
        this.nome = nome;
        this.limiteCompra = limiteCompra;
        this.fechamentoFatura = fechamentoFatura;
    }

    public Cliente(Cliente cliente) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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