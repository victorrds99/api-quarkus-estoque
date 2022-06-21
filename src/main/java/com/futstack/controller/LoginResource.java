package com.futstack.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.futstack.Model.Login;
import com.futstack.repository.LoginRepository;


@Path("/login")
public class LoginResource {

    @Inject
    LoginRepository loginRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Login> listarTodos(){
        return loginRepository.listAll();
    }

    @GET
    @Path("/total")
    @Produces(MediaType.APPLICATION_JSON)
    public long count(){
        return loginRepository.count();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Transactional
    public Response criaLogin(Login login) {
        loginRepository.persist(login);
        return Response.status(Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String exclui(@PathParam("id") Long id){
        loginRepository.deleteById(id);
        return "excluido com sucesso!!";
    }

    
}