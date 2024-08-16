package com.vrsoftware.VR.Software.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String codigo;
    public String nome;
    public Double limiteCompra;
    public Integer fechamentoFatura;

    public Cliente() {

    }

    public Cliente(Long id, String codigo, String nome, Double limiteCompra, Integer fechamentoFatura) {
        validateFechamento(id, codigo, nome, limiteCompra, fechamentoFatura);
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.limiteCompra = limiteCompra;
        this.fechamentoFatura = fechamentoFatura;
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

    public void validateFechamento(Long id, String codigo, String nome, Double limiteCompra, Integer fechamentoFatura){
        if (fechamentoFatura < 1 || fechamentoFatura > 31) {
            throw new IllegalArgumentException("Dia de fechamento da fatura deve estar entre 1 e 31");
        }
    }
}