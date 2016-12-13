/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.DAO.FormaPagamentoDAO;
import model.FormaPagamento;
import model.Token;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("formapagamento")
public class FormapagamentoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FormapagamentoResource
     */
    public FormapagamentoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos(@QueryParam("token") String t) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        ArrayList<FormaPagamento> fpagamento = FormaPagamentoDAO.retreaveAll();
         return gson.toJson(fpagamento);
                
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@QueryParam("token") String t, @QueryParam("id")int id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FormaPagamento fpagamento = FormaPagamentoDAO.retreave(id);
        return gson.toJson(fpagamento);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public int inserir(@QueryParam("token")String t, String data) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FormaPagamento fpagamento = gson.fromJson(data, FormaPagamento.class);
        FormaPagamentoDAO.create(fpagamento); 
        return 200;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public int deletar(@QueryParam("token")String t, String id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FormaPagamento fpagamento = gson.fromJson(id, FormaPagamento.class);
        FormaPagamentoDAO.delete(fpagamento);
        return 200;
    }    
        
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public void alterar (@QueryParam("token")String t,String data) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FormaPagamento fpagamento = gson.fromJson(data, FormaPagamento.class);
            FormaPagamentoDAO.update(fpagamento);
    }
}
