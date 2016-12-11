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
import javax.ws.rs.core.MediaType;
import model.DAO.FuncionarioDAO;
import model.Funcionario;

/**
 * REST Web Service
 *
 * @author dione
 */
@Path("funcionarios")
public class FuncionariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionariosResource
     */
    public FuncionariosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos() throws SQLException{
        Gson gson = new Gson();
        ArrayList<Funcionario> funcionario = FuncionarioDAO.retreaveAll();
         return gson.toJson(funcionario);
                
    }
}
