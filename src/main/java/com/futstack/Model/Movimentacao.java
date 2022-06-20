package com.futstack.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao extends PanacheEntityBase {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_movimentacao;

	@CreationTimestamp
	private Date data_movimentacao;

	public String tipo_movimentacao;

	public int quantidade_movimentacao;
	
	public int id_produto_fk;
	
	public int id_fornecedor_fk;

    
	public int getId_movimentacao() {
        return id_movimentacao;
    }

    public void setId_movimentacao(int id_movimentacao) {
        this.id_movimentacao = id_movimentacao;
    }

    public Date getData_movimentacao() {
		return data_movimentacao;
	}

	public void setData_movimentacao(Date data_movimentacao) {
		this.data_movimentacao = data_movimentacao;
	}

	public String getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(String tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	public int getQuantidade_movimentacao() {
		return quantidade_movimentacao;
	}

	public void setQuantidade_movimentacao(int quantidade_movimentacao) {
		this.quantidade_movimentacao = quantidade_movimentacao;
	}

    public int getId_produto_fk() {
        return id_produto_fk;
    }

    public void setId_produto_fk(int id_produto_fk) {
        this.id_produto_fk = id_produto_fk;
    }

    public int getId_fornecedor_fk() {
        return id_fornecedor_fk;
    }

    public void setId_fornecedor_fk(int id_fornecedor_fk) {
        this.id_fornecedor_fk = id_fornecedor_fk;
    }

    

	
}
