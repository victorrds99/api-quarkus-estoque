package com.futstack.controller;

import com.futstack.Model.Deposito;
import com.futstack.Model.Fornecedor;
import com.futstack.Model.Movimentacao;
import com.futstack.Model.Produto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Path("/consultas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Consultas {

    @GET
    @Path("/categoria/{categoria}")
    public List<Produto> buscarPorCategoria(String categoria) {
        return Produto.findByCategories(categoria);
    }

    @GET
    @Path("/reposicao")
    public List<Produto> buscarProdutosEmPontoDeResposicao() {

        return Produto.ProdutosEmPontoReposicao();
    }

    @GET
    @Path("/reposicao/deposito/{id_deposito}")
    public List<Produto> buscarProdutosEmDepositoComPontoDeResposicao(int id_deposito) {
        Optional<Deposito> depositoOp = Deposito.findByIdOptional(id_deposito);
        if(depositoOp.isEmpty()) {
            throw new NullPointerException();
        }
        Deposito depos = depositoOp.get();
        List<Produto> prodList = depos.getDe_id_fk();

        List<Produto> lista = new ArrayList<>();
        for(Produto prod : prodList){
            if(prod.isPr_pont_repo()){
                lista.add(prod);
            }    
        }
        return lista;
    }

    

    @GET
    @Path("/movimentacao")
    public List<Movimentacao> buscarMovimentacaoGeral() {
        return Movimentacao.listAll();
    }

    @GET
    @Path("/movimentacao/depositoOrigem/{id_deposito}")
    public List<Movimentacao> buscarMovimentacaoPorDepositoOrigem(int id_deposito) {
        return Movimentacao.find("mo_id_deposito_origem_fk",   id_deposito).list();
    }

    @GET
    @Path("/movimentacao/depositoDestino/{id_deposito}")
    public List<Movimentacao> buscarMovimentacaoPorDepositoDestino(int id_deposito) {
        return Movimentacao.find("mo_id_deposito_destino_fk",   id_deposito).list();
    }

    @GET
    @Path("/movimentacao/produto/{id_produto}")
    public List<Movimentacao> buscarMovimentacaoPorProduto(int id_produto) {
        return Movimentacao.find("mo_id_produto_fk",   id_produto).list();
    }


    @GET
    @Path("/fornecedor/produto/reposicao")
    public HashMap<Produto,List<Fornecedor>> buscarProdutoEmPontoDeReposicaoEFornecedores() {
        
        List<Produto> prodList = Produto.ProdutosEmPontoReposicao();
        HashMap<Produto,List<Fornecedor>> prdLisFor = new HashMap<Produto,List<Fornecedor>>();
        for(Produto prod :prodList){
            prdLisFor.put(prod, prod.getPr_id_fornecedor_fk()) ; 
        }
     
       


       

        
        return prdLisFor;
    }


}
