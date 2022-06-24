package com.futstack.controller;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
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
import com.futstack.Model.Operacao;
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

            List<Produto> produtoList = fornecedorObjeto.getFo_list_produto();
            if(produtoList.contains(produtoObjeto)){
                throw new BadRequestException("Já tem esse produto irmao ");
            }
            produtoList.add(produtoObjeto);
            fornecedorObjeto.setFo_list_produto(produtoList);
            fornecedorObjeto.persist();

            ProdutoAddFornecedor(id_produto, id_fornecedor);
            
            try {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setMo_id_fornecedor_fk(fornecedorObjeto.getFo_id());
                movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
                movimentacao.setMo_tipo("Fornecedor com id: "+ fornecedorObjeto.getFo_id() + ", nome: "+ fornecedorObjeto.getFo_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
                movimentacao.persist();
            } catch (Exception e) {
                throw new Exception(e);
            }
           
            return fornecedorObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }

    @Transactional
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

            List<Fornecedor> fornecedorlist = produtoOb.getPr_id_fornecedor_fk();
            fornecedorlist.add(fornecedorOb);

            produtoOb.setPr_id_fornecedor_fk(fornecedorlist);
            produtoOb.persist();
    }   

    @DELETE
    @Path("/fornecedor/{id_fornecedor}/produto/{id_produto}")
    @Transactional
    public Fornecedor FornecedorRemoveProduto(@PathParam("id_fornecedor") int id_fornecedor, @PathParam("id_produto") int id_produto) {

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

            List<Produto> produtoList = fornecedorObjeto.getFo_list_produto();

            produtoList.remove(produtoObjeto);
            fornecedorObjeto.setFo_list_produto(produtoList);
            fornecedorObjeto.persist();

           try {
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setMo_id_fornecedor_fk(fornecedorObjeto.getFo_id());
            movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
            movimentacao.setMo_tipo("Fornecedor com id: "+ fornecedorObjeto.getFo_id() + ", nome: "+ fornecedorObjeto.getFo_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
            movimentacao.persist();
           } catch (Exception e) {
                throw new Exception(e);
           }
           
            return fornecedorObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("/deposito/{id_deposito}/produto/{id_produto}/doacao")
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
                movimentacao.setMo_id_deposito_origem_fk(depositoObjeto.getDe_id());
                movimentacao.setMo_id_deposito_destino_fk(depositoObjeto.getDe_id());
                movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
                movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
                Operacao operacao = Operacao.entrada_por_doacao;
                movimentacao.setOperacao(operacao);
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
    @Path("/deposito/{id_deposito}/produto/{id_produto}/doacao")
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
            movimentacao.setMo_id_deposito_origem_fk(depositoObjeto.getDe_id());
            movimentacao.setMo_id_deposito_destino_fk(depositoObjeto.getDe_id());
            movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
            movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
            Operacao operacao = Operacao.saida_por_doacao;
            movimentacao.setOperacao(operacao);
            movimentacao.persist();
           } catch (Exception e) {
                throw new Exception(e);
           }
           
            return depositoObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("/deposito/{id_deposito}/produto/{id_produto}/NF")
    @Transactional
    public Deposito DepositoAddProdutoNF(@PathParam("id_deposito") int id_deposito, @PathParam("id_produto") int id_produto) {

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
                movimentacao.setMo_id_deposito_origem_fk(depositoObjeto.getDe_id());
                movimentacao.setMo_id_deposito_destino_fk(depositoObjeto.getDe_id());
                movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
                movimentacao.setMo_preco_produto(produtoObjeto.getPr_preco());
                movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + ", nome: " + produtoObjeto.getPr_nome() + " e preco: " + movimentacao.getMo_preco_produto());
                Operacao operacao = Operacao.entrada_por_nota_fiscal;
                movimentacao.setOperacao(operacao);
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
    @Path("/deposito/{id_deposito}/produto/{id_produto}/NF")
    @Transactional
    public Deposito DepositoRemoveProdutoNF(@PathParam("id_deposito") int id_deposito, @PathParam("id_produto") int id_produto) {

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
            movimentacao.setMo_id_deposito_origem_fk(depositoObjeto.getDe_id());
            movimentacao.setMo_id_deposito_destino_fk(depositoObjeto.getDe_id());
            movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
            movimentacao.setMo_preco_produto(produtoObjeto.getPr_preco());
            movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " vendeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome() + " e preco: " + movimentacao.getMo_preco_produto());
            Operacao operacao = Operacao.saida_por_nota_fiscal;
            movimentacao.setOperacao(operacao);
            movimentacao.persist();
           } catch (Exception e) {
                throw new Exception(e);
           }
           
            return depositoObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }


    @PUT
    @Path("/depositoOrigem/{id_depositoOrigem}/produto/{id_produto}/depositoDestino/{id_depositoDestino}")
    @Transactional
    public Deposito DepositoTransfereProduto(@PathParam("id_depositoOrigem") int id_depositoOrigem, 
    @PathParam("id_depositoDestino") int id_depositoDestino, @PathParam("id_produto") int id_produto) {

        try {
            Optional<Deposito> depositoOp = Deposito.findByIdOptional(id_depositoOrigem);
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

            //
            Optional<Deposito> depositoOp2 = Deposito.findByIdOptional(id_depositoDestino);
            if(depositoOp2.isEmpty()) {
                throw new NullPointerException();
            }
            

            Deposito depositoObjeto2 = depositoOp2.get();
          

            List<Produto> produtoList2 = depositoObjeto2.getDe_id_fk();


            produtoList2.add(produtoObjeto);
            depositoObjeto2.setDe_id_fk(produtoList2);
            depositoObjeto2.persist();
            
           try {
            
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setMo_id_deposito_origem_fk(depositoObjeto.getDe_id());
            movimentacao.setMo_id_deposito_destino_fk(depositoObjeto2.getDe_id());
            movimentacao.setMo_id_produto_fk(produtoObjeto.getPr_id());
            movimentacao.setMo_preco_produto(produtoObjeto.getPr_preco());
            movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " transferiu o produto de id: " + produtoObjeto.getPr_id() + " nome: " + produtoObjeto.getPr_nome() + ", preço: " + movimentacao.getMo_preco_produto() + " para o deposito de id: "+ depositoObjeto2.getDe_id() + ", nome: "+ depositoObjeto2.getDe_nome());
            Operacao operacao = Operacao.transferencia;
            movimentacao.setOperacao(operacao);
            movimentacao.persist();
           } catch (Exception e) {
                throw new Exception(e);
           }
           
            return depositoObjeto;
           
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
    


    public boolean remover(int id_depositoOrigem, int id_produto){
        try {
            Optional<Deposito> depositoOp = Deposito.findByIdOptional(id_depositoOrigem);
            if(depositoOp.isEmpty()) {
                throw new NullPointerException();
            }
            Optional<Produto> produtoOp = Produto.findByIdOptional(id_produto);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }
         

            Deposito depositoObjeto = depositoOp.get();
            
            Produto produtoObjeto = produtoOp.get();

            if(depositoObjeto.getDe_id_fk().contains(produtoObjeto)){
                List<Produto> produtoList = depositoObjeto.getDe_id_fk();
          
            produtoList.remove(produtoObjeto);

            depositoObjeto.setDe_id_fk(produtoList);
            depositoObjeto.persist();
            return true;
            } 

            
            return false;
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }


}
