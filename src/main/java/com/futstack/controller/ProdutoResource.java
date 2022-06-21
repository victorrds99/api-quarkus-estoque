package com.futstack.controller;

import com.futstack.Model.Produto;
import com.futstack.repository.MovimentacaoRepository;

import javax.inject.Inject;
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
    @Inject
    MovimentacaoRepository movimentacaoRepository;

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
    public Response criar(Produto dto) {
        try {
            dto.persist();
            movimentacaoRepository.registraCriacaoProduto(dto);
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


            produto.setPr_nome(dto.getPr_nome());
            produto.setPr_preco(dto.getPr_preco());
            produto.setPr_quantidade(dto.getPr_quantidade());
            produto.setPr_categoria(dto.getPr_categoria());
            produto.setPr_reposicao(dto.getPr_reposicao());

            produto.persist();
            movimentacaoRepository.registraAlteracaoProduto(dto);
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
        Produto dto = produtoOp.get();
        produtoOp.ifPresentOrElse(Produto::delete, () -> {throw new NotFoundException();});
        movimentacaoRepository.registraExclusaoProduto(dto);
        return "Produto excluido com sucesso!!";
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }
}