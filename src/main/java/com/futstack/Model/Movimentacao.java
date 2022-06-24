package com.futstack.Model;

import java.io.Serializable;
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
public class Movimentacao extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int mo_id;

	@CreationTimestamp
	private Date mo_data;

	public String mo_tipo;

	public Operacao operacao;

	public int mo_quantidade;

	public int mo_preco_produto;
	
	public int mo_id_produto_fk;
	
	public int mo_id_fornecedor_fk;
	 
	public int mo_id_deposito_origem_fk;

	public int mo_id_deposito_destino_fk;

	public int getMo_id() {
		return mo_id;
	}

	public void setMo_id(int mo_id) {
		this.mo_id = mo_id;
	}

	public Date getMo_data() {
		return mo_data;
	}

	public void setMo_data(Date mo_data) {
		this.mo_data = mo_data;
	}


	public String getMo_tipo() {
		return mo_tipo;
	}

	public void setMo_tipo(String mo_tipo) {
		this.mo_tipo = mo_tipo;
	}

	public int getMo_quantidade() {
		return mo_quantidade;
	}

	public void setMo_quantidade(int mo_quantidade) {
		this.mo_quantidade = mo_quantidade;
	}

	public int getMo_preco_produto() {
		return mo_preco_produto;
	}

	public void setMo_preco_produto(int mo_preco_produto) {
		this.mo_preco_produto = mo_preco_produto;
	}

	public int getMo_id_produto_fk() {
		return mo_id_produto_fk;
	}

	public void setMo_id_produto_fk(int mo_id_produto_fk) {
		this.mo_id_produto_fk = mo_id_produto_fk;
	}

	public int getMo_id_fornecedor_fk() {
		return mo_id_fornecedor_fk;
	}

	public void setMo_id_fornecedor_fk(int mo_id_fornecedor_fk) {
		this.mo_id_fornecedor_fk = mo_id_fornecedor_fk;
	}

	public int getMo_id_deposito_origem_fk() {
		return mo_id_deposito_origem_fk;
	}

	public void setMo_id_deposito_origem_fk(int mo_id_deposito_origem_fk) {
		this.mo_id_deposito_origem_fk = mo_id_deposito_origem_fk;
	}

	public int getMo_id_deposito_destino_fk() {
		return mo_id_deposito_destino_fk;
	}

	public void setMo_id_deposito_destino_fk(int mo_id_deposito_destino_fk) {
		this.mo_id_deposito_destino_fk = mo_id_deposito_destino_fk;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}


	
	

    
	
	
}
