package controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bárbara
 */
@Path("pessoas")
public class PessoasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PessoasResource
     */
    public PessoasResource() {
    }

    /**
     * Retrieves representation of an instance of controller.PessoasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Lucas dione mateus luis";
    }

    /**
     * PUT method for updating or creating an instance of PessoasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
