package com.futstack.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.futstack.Model.Deposito;
import com.futstack.Model.Fornecedor;
import com.futstack.Model.Movimentacao;
import com.futstack.Model.Produto;
import com.futstack.repository.LoginRepository;
import com.futstack.repository.MovimentacaoRepository;


@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Service {
    MovimentacaoRepository movimentacaoRepository;
    LoginRepository loginRepository;

    @PUT
    @Path("/fornecedor/{id_fornecedor}/produto/{id_produto}")
    @Transactional
    public Fornecedor FornecedorAddProduto(@PathParam("id_fornecedor") int id_fornecedor, @PathParam("id_produto") int id_produto) {

        try {
            Optional<Fornecedor> fornecedorOp = Fornecedor.findByIdOptional(id_fornecedor);
            if(fornecedorOp.isEmpty()) {
                throw new NullPointerException();
            }
            Optional<Produto> produtoOp = Produto.findByIdOptional(id_produto);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }

            Fornecedor fornecedorObjeto = fornecedorOp.get();
            Produto produtoObjeto = produtoOp.get();

            List<Produto> produtoList = new ArrayList<>();

            produtoList.add(produtoObjeto);
            fornecedorObjeto.setFo_list_produto(produtoList);
            fornecedorObjeto.persist();

            ProdutoAddFornecedor(id_produto, id_fornecedor);
            
            try {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setMo_tipo("Fornecedor com id: "+ fornecedorObjeto.getFo_id() + ", nome: "+ fornecedorObjeto.getFo_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
                movimentacao.persist();
            } catch (Exception e) {
                throw new Exception(e);
            }
           
            return fornecedorObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    public void ProdutoAddFornecedor(int id_produto, int id_fornecedor){
        Optional<Fornecedor> fornecedorOp = Fornecedor.findByIdOptional(id_fornecedor);
            if(fornecedorOp.isEmpty()) {
                throw new NullPointerException();
            }
            Optional<Produto> produtoOp = Produto.findByIdOptional(id_produto);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }

            Produto produtoOb = produtoOp.get();
            Fornecedor fornecedorOb = fornecedorOp.get();

            produtoOb.setPr_id_fornecedor_fk(fornecedorOb);
            produtoOb.persist();
    }   


    @PUT
    @Path("/deposito/{id_deposito}/produto/{id_produto}")
    @Transactional
    public Deposito DepositoAddProduto(@PathParam("id_deposito") int id_deposito, @PathParam("id_produto") int id_produto) {

        try {
            Optional<Deposito> depositoOp = Deposito.findByIdOptional(id_deposito);
            if(depositoOp.isEmpty()) {
                throw new NullPointerException();
            }
            Optional<Produto> produtoOp = Produto.findByIdOptional(id_produto);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }

            Deposito depositoObjeto = depositoOp.get();
            Produto produtoObjeto = produtoOp.get();

            List<Produto> produtoList = depositoObjeto.getDe_id_fk();


            produtoList.add(produtoObjeto);
            depositoObjeto.setDe_id_fk(produtoList);
            depositoObjeto.persist();
           
            try {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
                movimentacao.persist();
            } catch (Exception e) {
                throw new Exception(e);
            }
            return depositoObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    
    @DELETE
    @Path("/deposito/{id_deposito}/produto/{id_produto}")
    @Transactional
    public Deposito DepositoRemoveProduto(@PathParam("id_deposito") int id_deposito, @PathParam("id_produto") int id_produto) {

        try {
            Optional<Deposito> depositoOp = Deposito.findByIdOptional(id_deposito);
            if(depositoOp.isEmpty()) {
                throw new NullPointerException();
            }
            Optional<Produto> produtoOp = Produto.findByIdOptional(id_produto);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }

            Deposito depositoObjeto = depositoOp.get();
            Produto produtoObjeto = produtoOp.get();

            List<Produto> produtoList = depositoObjeto.getDe_id_fk();

            produtoList.remove(produtoObjeto);
            depositoObjeto.setDe_id_fk(produtoList);
            depositoObjeto.persist();

           try {
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
            movimentacao.persist();
           } catch (Exception e) {
                throw new Exception(e);
           }
           
            return depositoObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    
    
}
