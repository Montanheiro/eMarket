package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Bárbara
 */
public class UsuarioDAO {

    private UsuarioDAO() {
    }

  
    public static int create(Usuario u) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO usuario (`Login`, `Senha`, `TokenSession`, `Funcionario_id`, `Status_id`) VALUES ('"
                    + u.getLogin()+ "','"
                    + u.getSenha()+ "','"
                    + u.getTokenSession()+ "','"
                    + u.getFuncionarioId()+ "','"
                    + u.getStatusId()+ "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            u.setId(key);
            return key;
            
    }


    public static Usuario retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM usuario where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Usuario(id,
                rs.getString("Login"),
                rs.getString("Senha"),
                rs.getString("TokenSession"),
                rs.getInt("Funcionario_id"),
                rs.getInt("Status_id"));
    }

    
    public static ArrayList<Usuario> retreaveAll() throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Usuario> u = new ArrayList<>();
            while (rs.next()) {
                u.add(new Usuario(rs.getInt("id"),
                        rs.getString("Login"),
                        rs.getString("Senha"),
                        rs.getString("TokenSession"),
                        rs.getInt("Funcionario_id"),
                        rs.getInt("Status_id")));
            }
            rs.next();
            return u;
    }

    public static void update(Usuario u) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE usuario SET "
                + "`Login`='" + u.getLogin()
                + "', `Senha`='" + u.getSenha()
                + "', `TokenSession`='" + u.getTokenSession()
                + "' WHERE `id`= "
                + u.getId();
        stm.execute(sql);
    }

    
    public static void delete(Usuario u) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM usuario WHERE `id`="
                + u.getId();
        stm.execute(sql);
    }

    

}
