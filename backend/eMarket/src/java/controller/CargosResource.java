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
import model.Cargo;
import model.DAO.CargoDAO;

/**
 * REST Web Service
 *
 * @author Bárbara
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
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        Gson gson = new Gson();

        Cargo c = new Cargo("Vendedor");

        CargoDAO.create(c);

        //System.out.println(c.getId());

        return gson.toJson(c);
    }

    /**
     * PUT method for updating or creating an instance of CargosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
