package com.futstack.repository;



import javax.enterprise.context.ApplicationScoped;

import com.futstack.Model.Deposito;
import com.futstack.Model.Fornecedor;
import com.futstack.Model.Movimentacao;
import com.futstack.Model.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MovimentacaoRepository implements PanacheRepository<Movimentacao>{
    
    public void registraCriacaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Deposito foi criado!! id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome() + " !!");
        movimentacao.persist();
    }

    public void registraAlteracaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Deposito de id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome()  + " !!");
        movimentacao.persist();
    }
    public void registraExclusaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Deposito de id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome() + " !!");
        movimentacao.persist();
    }

    

    public void registraCriacaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Produto foi criado!! id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();
    }
    public void registraAlteracaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Produto de id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();
    }
    public void registraExclusaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Produto de id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();
    }


    

    public void registraCriacaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Fornecedor foi criado!! id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();
    }
    public void registraAlteracaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Fornecedor de id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();
    }
    
    public void registraExclusaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Fornecedor de id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();
    }



    public void registraAdicaoProdutoNoDeposito(Deposito depositoObjeto, Produto produtoObjeto){

        


        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
        movimentacao.persist();

    }

    public void registraSubtracaoProdutoNoDeposito(Deposito depositoObjeto, Produto produtoObjeto){




        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
        movimentacao.persist();

    }
    


  

    
}

