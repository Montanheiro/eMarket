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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Cargo;
import model.DAO.CargoDAO;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("cargos")
public class CargosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CargosResource
     */
    public CargosResource() {
    }

    /**
     * Retrieves representation of an instance of controller.CargosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos() throws SQLException {
        Gson gson = new Gson();
         ArrayList<Cargo> cargo = CargoDAO.retreaveAll();
          return gson.toJson(cargo);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@QueryParam("id")int id) throws SQLException {
        Gson gson = new Gson();
        Cargo c = CargoDAO.retreave(id);
        return gson.toJson(c);
    }
    
   

    /**
     * PUT method for updating or creating an instance of CargosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCargos(String content) {
    }
}
