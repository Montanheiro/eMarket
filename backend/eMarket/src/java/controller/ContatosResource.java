package controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.DAO.ContatoDAO;
import model.Contato;
import model.Token;

@Path("contatos")
public class ContatosResource {

    @Context
    private UriInfo context;

    public ContatosResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultar")
    public String consultarTodos(@HeaderParam("token") String t) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        ArrayList<Contato> contato = ContatoDAO.retreaveAll();
        return gson.toJson(contato);       
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarid")
    public String  consultarId(@HeaderParam("token") String t, @QueryParam("id")int id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Contato c = ContatoDAO.retreave(id);
        return gson.toJson(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarbypessoa")
    public String consultarByPessoa(@HeaderParam("token") String t, @QueryParam("id") int id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();       
        ArrayList<Contato> contato = ContatoDAO.retreaveByPessoa(id);
        return gson.toJson(contato);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public String inserir(@HeaderParam("token")String t, String data) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Contato c = gson.fromJson(data, Contato.class);

        return gson.toJson(ContatoDAO.create(c)); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deletar")
    public int deletar(@HeaderParam("token")String t, String id) throws SQLException, Exception {
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Contato c = gson.fromJson(id, Contato.class);
        ContatoDAO.delete(c);
        return 200;
    }    
        
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public void alterar (@HeaderParam("token")String t,String data) throws SQLException, Exception{
        if (!new Token().VerificarToken(t)) throw new Exception("token invalido");
        Gson gson = new Gson();
        Contato c = gson.fromJson(data, Contato.class);
        ContatoDAO.update(c);
    }
}
