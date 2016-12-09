package controller;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.Cargo;
import model.DAO.CargoDAO;


@Path("cargos")
public class CargosResource {

 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     @Path("/consultar")
    public String getJson(@QueryParam("id") int id) {
        Gson gson = new Gson();

       
         Cargo cargo = CargoDAO.retreave(id);
          return gson.toJson(cargo);
      
           // ArrayList<Cargo> cargos = CargoDAO.retreaveAll();
            //return gson.toJson(cargos);
       

      }
   
    /**
     * PUT method for updating or creating an instance of CargosResource
     *
     * @param content representation for the resource
     * @path nome
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(@QueryParam("nome") String nome) {

        Gson gson = new Gson();

        return gson.toJson(nome);

    }
    
    
/*    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public void postJson(@Context HttpServletRequest req) {
        Gson gson = new Gson();
        
        Cargo c = gson.fromJson(req, Cargo.class);
        CargoDAO.create(c);

//          System.out.println("Nome " + nome);
//          System.out.println("c " + c);
    }
*/    
    
}
