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
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Cliente;
import model.DAO.ClienteDAO;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("clientes")
public class ClientesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesResource
     */
    public ClientesResource() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos() throws SQLException{
        Gson gson = new Gson();
        ArrayList<Cliente> cliente = ClienteDAO.retreaveAll();
         return gson.toJson(cliente);
                
    }
    
        @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@QueryParam("id")int id) throws SQLException {
        Gson gson = new Gson();
        Cliente c = ClienteDAO.retreave(id);
        return gson.toJson(c);
    }
    
}
