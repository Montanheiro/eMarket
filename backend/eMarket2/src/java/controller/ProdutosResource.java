package controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Produto;

/**
 * REST Web Service
 *
 * @author Bárbara
 */
@Path("produtos")
public class ProdutosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
    }

    /**
     * Retrieves representation of an instance of controller.ProdutosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        
/*        ArrayList<Produto> cs = new ArrayList<>();
        
        Produto pd1 = new Produto("Abobrinha", 1, 15);
        Produto pd2 = new Produto("Chuchu", 1, 15);
        Produto pd3 = new Produto("Cocada", 1, 15);
        Produto pd4 = new Produto("Beterraba", 1, 15);
        
        cs.add(pd1);
        cs.add(pd2);
        cs.add(pd3);
        cs.add(pd4);
*/        
        
        
        return gson.toJson("Produto");
        
    
    }

    /**
     * PUT method for updating or creating an instance of ProdutosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
