package com.futstack.controller;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.futstack.Model.Movimentacao;

@Path("/movimentacao")
public class MovimentacaoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimentacao> listarTodos() {
        try {
            return Movimentacao.listAll();
        } catch (Exception e) {
            throw new NotFoundException("Não consegui consultar...");
        }
    }
}
