package com.vrsoftware.VR.Software.dto;

import com.vrsoftware.VR.Software.entities.Produto;

public class ProdutoDTO {

    public Long id;
    public String codigo;
    public String descricao;
    public Double preco;

    public ProdutoDTO() {

    }

    public ProdutoDTO(Long id, String codigo, String descricao, Double preco) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
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
}