package com.futstack.controller;

import com.futstack.Model.Produto;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarTodos() {
        try {
            return Produto.listAll();
        } catch (Exception e) {
            throw new NotFoundException("Não consegui consultar...");
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response criar(Produto produto) {
        try {
            produto.persist();
            Response retorno = Response.status(Response.Status.CREATED).build();
            return retorno;
        }catch (Exception e){
            throw new NotFoundException(e);
        }
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public String alterar(@PathParam("id") int id, Produto dto) {
        try {
            Optional<Produto> produtoOp = Produto.findByIdOptional(id);
            if (produtoOp.isEmpty()) {
                throw new NotFoundException();
            }
            Produto produto = produtoOp.get();


            produto.setNome_produto(dto.getNome_produto());
            produto.setPreco_produto(dto.getPreco_produto());
            produto.setQuantidade_produto(dto.getQuantidade_produto());
            produto.setCategoria_produto(dto.getCategoria_produto());
            produto.setReposicao_produto(dto.getReposicao_produto());

            produto.persist();

            return "Alteração feita com sucesso!";
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String exclui(@PathParam("id") int id){
        try {
            
        Optional<Produto> produtoOp = Produto.findByIdOptional(id);
        produtoOp.ifPresentOrElse(Produto::delete, () -> {throw new NotFoundException();});
        return "Produto excluido com sucesso!!";
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }
}