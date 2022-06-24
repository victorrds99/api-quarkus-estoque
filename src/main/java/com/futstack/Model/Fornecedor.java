package com.futstack.Model;


import java.io.Serializable;
import java.util.List;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor extends PanacheEntityBase implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fo_id;


    private String fo_nome;

    @ManyToMany
    private List<Produto> fo_list_produto;

    public int getFo_id() {
        return fo_id;
    }

    public void setFo_id(int fo_id) {
        this.fo_id = fo_id;
    }

    public String getFo_nome() {
        return fo_nome;
    }

    public void setFo_nome(String fo_nome) {
        this.fo_nome = fo_nome;
    }
    
   

    public List<Produto> getFo_list_produto() {
        return fo_list_produto;
    }

    public void setFo_list_produto(List<Produto> fo_list_produto) {
        this.fo_list_produto = fo_list_produto;
    }

    

}
