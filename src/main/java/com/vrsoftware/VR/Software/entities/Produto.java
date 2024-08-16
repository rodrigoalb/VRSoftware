package com.vrsoftware.VR.Software.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String codigo;
    public String descricao;
    public Double preco;

    public Produto() {

    }

    public Produto(Long id, String codigo, String descricao, Double preco) {
        validateCodigoPreco(id, codigo, descricao, preco);
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void validateCodigoPreco(Long id, String codigo, String descricao, Double preco){
        if (codigo == null || descricao == null) {
            throw new IllegalArgumentException("Código e Descrição não podem ser nulos");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
    }
}