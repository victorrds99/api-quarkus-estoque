package com.futstack.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.futstack.Model.Deposito;
import com.futstack.repository.MovimentacaoRepository;

@Path("/deposito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepositoResource {
   
    @Inject
    MovimentacaoRepository movimentacaoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Deposito> listarTodos() {
        try {
            return Deposito.listAll();
        } catch (Exception e) {
            throw new NotFoundException("Não consegui consultar...");
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response criar(Deposito dto) {
        try {
            dto.persist();
            movimentacaoRepository.registraCriacaoDeposito(dto);

            Response retorno = Response.status(Response.Status.CREATED).build();
            return retorno;
        }catch (Exception e){
            throw new NotFoundException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public String alterar(@PathParam("id") int id, Deposito deposito) {
        try {
            Optional<Deposito> depositoOp = Deposito.findByIdOptional(id);
            if (depositoOp.isEmpty()) {
                throw new NotFoundException();
            }
            Deposito dto = depositoOp.get();


            dto.setDe_nome(deposito.getDe_nome());
            
            dto.persist();
            movimentacaoRepository.registraAlteracaoDeposito(dto);
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
            
        Optional<Deposito> depositoOp = Deposito.findByIdOptional(id);
        Deposito dto = depositoOp.get();
        depositoOp.ifPresentOrElse(Deposito::delete, () -> {throw new NotFoundException();});
        movimentacaoRepository.registraExclusaoDeposito(dto);
        return "Deposito excluido com sucesso!!";
        } catch (Exception e) {
            throw new NotFoundException(e);
        }
    }
}
