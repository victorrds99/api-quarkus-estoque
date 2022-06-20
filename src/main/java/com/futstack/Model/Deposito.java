package com.futstack.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "tb_deposito")
public class Deposito extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_deposito;

    private int id_produto_fk;
    
    private String nome_deposito;

    private int reposicao_deposito;
    
    public int getId_deposito() {
        return id_deposito;
    }

    public void setId_deposito(int id_deposito) {
        this.id_deposito = id_deposito;
    }

    public int getId_produto_fk() {
        return id_produto_fk;
    }

    public void setId_produto_fk(int id_produto_fk) {
        this.id_produto_fk = id_produto_fk;
    }

    public String getNome_deposito() {
        return nome_deposito;
    }

    public void setNome_deposito(String nome_deposito) {
        this.nome_deposito = nome_deposito;
    }

    public int getReposicao_deposito() {
        return reposicao_deposito;
    }

    public void setReposicao_deposito(int reposicao_deposito) {
        this.reposicao_deposito = reposicao_deposito;
    }

    



}
