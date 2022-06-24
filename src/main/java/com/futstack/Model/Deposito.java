package com.futstack.Model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity

@Table(name = "tb_deposito")
public class Deposito extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int de_id;
    
    private String de_nome;
    
    @OneToMany
    private List<Produto> de_id_fk;

    public int getDe_id() {
        return de_id;
    }

    public void setDe_id(int de_id) {
        this.de_id = de_id;
    }

    public String getDe_nome() {
        return de_nome;
    }

    public void setDe_nome(String de_nome) {
        this.de_nome = de_nome;
    }

    public List<Produto> getDe_id_fk() {
        return de_id_fk;
    }

    public void setDe_id_fk(List<Produto> de_id_fk) {
        this.de_id_fk = de_id_fk;
    }

    

    

  

    

}
