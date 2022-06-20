package com.futstack.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;
    private int id_fornecedor_fk;
    private String nome_produto;
    private int preco_produto;
    private int quantidade_produto;
    private String categoria_produto;
    private int reposicao_produto;


    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_fornecedor_fk() {
        return id_fornecedor_fk;
    }

    public void setId_fornecedor_fk(int id_fornecedor_fk) {
        this.id_fornecedor_fk = id_fornecedor_fk;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(int preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public String getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(String categoria_produto) {
        this.categoria_produto = categoria_produto;
    }
    public int getReposicao_produto(){
        return reposicao_produto;
    }

    public void setReposicao_produto(int reposicao_produto) {
        this.reposicao_produto = reposicao_produto;
    }
}
