package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Bárbara
 */
public class ClienteDAO {
    
    
    private ClienteDAO() {
    }

    
    public static int create(Cliente c) throws SQLException {
            PessoaDAO.create(c.getPessoa());

            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO cliente (`DataNascimento`, `RG`, `Limite`, `pessoa_id`) VALUES ('"
                    + c.getDataNascimento()+ "','"
                    + c.getRg()+ "','"
                    + c.getLimite()+ "','"
                    + c.getPessoa().getId() + "')";
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);
            return key;
    }

    public static Cliente retreave(int id) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM cliente where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Cliente(id,
                    rs.getDate("DataNascimento"),
                    rs.getInt("RG"),
                    rs.getInt("Limite"),
                    rs.getInt("pessoa_id"));
    }

    public static ArrayList<Cliente> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM cliente";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Cliente> c = new ArrayList<>();
        while (rs.next()) {
            c.add(new Cliente(
                    rs.getInt("id"),
                    rs.getDate("DataNascimento"),
                    rs.getInt("RG"),
                    rs.getInt("Limite"),
                    rs.getInt("Pessoa_id")));
        }
        rs.next();
        return c;
    }

   
    public static void update(Cliente c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE funcionario SET "
                    + "`DataNascimento`= '" + c.getDataNascimento()
                    + "', `RG`= '" + c.getRg()
                    + "', `Limite`= '" + c.getLimite()
                    + "' WHERE `id`= "
                    + c.getId();
            stm.execute(sql);
    }
    
    
    public static void delete(Cliente c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM cliente WHERE `id`="
                    + c.getId();
            stm.execute(sql);
    }

}
