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
import model.DAO.VendaDAO;
import model.Token;
import model.Venda;
import model.DAO.VendaDAO;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("vendas")
public class VendasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VendasResource
     */
    public VendasResource() {
    }

        @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos(@QueryParam("token") String t) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        ArrayList<Venda> v = VendaDAO.retreaveAll();
         return gson.toJson(v);
                
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@QueryParam("token") String t, @QueryParam("id")int id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Venda v = VendaDAO.retreave(id);
        return gson.toJson(v);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public int inserir(@QueryParam("token")String t, String data) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Venda v = gson.fromJson(data, Venda.class);
        VendaDAO.create(v); 
        return 200;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public int deletar(@QueryParam("token")String t, String id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Venda v = gson.fromJson(id, Venda.class);
        VendaDAO.delete(v);
        return 200;
    }    
        
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public void alterar (@QueryParam("token")String t,String data) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Venda v = gson.fromJson(data, Venda.class);
            VendaDAO.update(v);
    }
}
