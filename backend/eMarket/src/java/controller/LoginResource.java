package controller;

import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.DAO.UsuarioDAO;
import model.Token;
import model.Usuario;

@Stateless
@Path("login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/logar")
    public String postJson(String dados) throws SQLException, Exception {
        
        Gson gson = new Gson();
        
        Usuario u = gson.fromJson(dados, Usuario.class);
        System.out.println("Usuário >>>>>" + u);
        u = UsuarioDAO.retreave(u.getLogin(), u.getSenha());
        System.out.println("Usuário válido, gerando token");
        
        String token = new Token().GerarToken("eMarket", String.valueOf(u.getId()), 43200000);
        return token;
    }   
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/verificar")
    public String getJson(@HeaderParam("token") String token) throws Exception {
        
        System.out.println("Verificando >>>> " + token);
        if(!new Token().VerificarToken(token)) throw new Exception("Token invalido.");
        
        return "200";
    }
}
