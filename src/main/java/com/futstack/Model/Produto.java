package com.futstack.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto extends PanacheEntityBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pr_id;
    
    private String pr_nome;
    private int pr_preco;
    private int pr_quantidade;
    private String pr_categoria;
    private int pr_reposicao;

    private boolean pr_pont_repo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonbTransient
    private List<Fornecedor> pr_id_fornecedor_fk;

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_nome() {
        return pr_nome;
    }

    public void setPr_nome(String pr_nome) {
        this.pr_nome = pr_nome;
    }

    public int getPr_preco() {
        return pr_preco;
    }

    public void setPr_preco(int pr_preco) {
        this.pr_preco = pr_preco;
    }

    public int getPr_quantidade() {
        return pr_quantidade;
    }

    public void setPr_quantidade(int pr_quantidade) {
        this.pr_quantidade = pr_quantidade;
    }

    public String getPr_categoria() {
        return pr_categoria;
    }

    public void setPr_categoria(String pr_categoria) {
        this.pr_categoria = pr_categoria;
    }

    public int getPr_reposicao() {
        return pr_reposicao;
    }

    public void setPr_reposicao(int pr_reposicao) {
        this.pr_reposicao = pr_reposicao;
    }

    public List<Fornecedor> getPr_id_fornecedor_fk() {
        return pr_id_fornecedor_fk;
    }

    public void setPr_id_fornecedor_fk(List<Fornecedor> pr_id_fornecedor_fk) {
        this.pr_id_fornecedor_fk = pr_id_fornecedor_fk;
    }

    public boolean isPr_pont_repo() {
        return pr_pont_repo;
    }

    public void setPr_pont_repo(boolean pr_pont_repo) {
        this.pr_pont_repo = pr_pont_repo;
    }

    public static List<Produto> findByCategories(String categoria) {
        return find("pr_categoria", categoria).list();
    }
    public static List<Produto>ProdutosEmPontoReposicao() {
        boolean reposicao = true;
        return find("pr_pont_repo",reposicao).list();
    }




}
