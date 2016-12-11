package controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.jstl.sql.Result;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    
   @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public int inserir(String nome) throws SQLException {
        Gson gson = new Gson();
        Cargo c = gson.fromJson(nome, Cargo.class);
        CargoDAO.create(c); 
        return 200;

    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/deletar")
//    public String deletar(@QueryParam("id")int id) throws SQLException {
//        Gson gson = new Gson();
//        Cargo c = CargoDAO.retreave(id);
//        CargoDAO.delete(c);
//        return "deletado";
//    }
//    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public int deletar(String id) throws SQLException {
        Gson gson = new Gson();
        Cargo c = gson.fromJson(id, Cargo.class);
        CargoDAO.delete(c);
        return 200;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public void alterar(String data) throws SQLException{
        Gson gson = new Gson();
        System.out.println(data);
        Cargo c = gson.fromJson(data, Cargo.class);

            CargoDAO.update(c);


   
        
    }

}