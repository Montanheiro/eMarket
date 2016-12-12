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
import model.DAO.FinanceiroCaixaDAO;
import model.FinanceiroCaixa;
import model.Token;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("financeirocaixa")
public class FinanceirocaixaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FinanceirocaixaResource
     */
    public FinanceirocaixaResource() {
    }

@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos(@QueryParam("token") String t) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        ArrayList<FinanceiroCaixa> fcaixa = FinanceiroCaixaDAO.retreaveAll();
         return gson.toJson(fcaixa);
                
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@QueryParam("token") String t, @QueryParam("id")int id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FinanceiroCaixa fcaixa = FinanceiroCaixaDAO.retreave(id);
        return gson.toJson(fcaixa);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public int inserir(@QueryParam("token")String t, String data) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FinanceiroCaixa fcaixa = gson.fromJson(data, FinanceiroCaixa.class);
        FinanceiroCaixaDAO.create(fcaixa); 
        return 200;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public int deletar(@QueryParam("token")String t, String id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FinanceiroCaixa fcaixa = gson.fromJson(id, FinanceiroCaixa.class);
        FinanceiroCaixaDAO.delete(fcaixa);
        return 200;
    }    
        
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public void alterar (@QueryParam("token")String t,String data) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        FinanceiroCaixa fcaixa = gson.fromJson(data, FinanceiroCaixa.class);
            FinanceiroCaixaDAO.update(fcaixa);
    }
}
