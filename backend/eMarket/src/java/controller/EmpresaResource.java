package controller;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.DAO.EmpresaDAO;
import model.Empresa;

/**
 *
 * @author Mateus
 */
@Path("empresa")
public class EmpresaResource {
    @Context
    private UriInfo context;
    
    public EmpresaResource(){
    
}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(){
        Gson gson = new Gson();
        
        Empresa e = new Empresa("MorrinhosForts","teste","0001","date");
        
        EmpresaDAO.create(e);
        return gson.toJson(e);
        
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void puJson(String content){
}
}