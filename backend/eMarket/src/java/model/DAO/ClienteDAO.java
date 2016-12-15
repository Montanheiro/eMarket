package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Pessoa;

/**
 *
 * @author Bárbara
 */
public class ClienteDAO {

    private ClienteDAO() {
    }

    public static int create(Cliente f) throws SQLException {
        PessoaDAO.create(f.getPessoa());
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO cliente (`DataNascimento`, `RG`, `Limite`, `pessoa_id`) VALUES ('"
                + f.getDataNascimento() + "','"
                + f.getRg() + "','"
                + f.getLimite() + "','"
                + f.getPessoa().getId() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        f.setId(key);
        return key;
    }

    public static Cliente retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM cliente where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Pessoa p = PessoaDAO.retreave(rs.getInt("pessoa_id"));        
        return new Cliente(id,
                rs.getString("DataNascimento"),
                rs.getInt("RG"),
                rs.getDouble("Limite"),
                p);
    }


    public static ArrayList<Cliente> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM cliente";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Cliente> f = new ArrayList<>();
        while (rs.next()) {
        Pessoa p = PessoaDAO.retreave(rs.getInt("pessoa_id"));        
            f.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("DataNascimento"),
                    rs.getInt("RG"),
                    rs.getDouble("Limite"),
                    p));
        }
        rs.next();
        return f;
    }

    public static void update(Cliente f) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE cliente SET "
                + "`DataNascimento`= '" + f.getDataNascimento()
                + "', `RG`= '" + f.getRg()
                + "', `Limite`= '" + f.getLimite()
                + "' WHERE `id`= "
                + f.getId();
        stm.execute(sql);
        PessoaDAO.update(f.getPessoa());        
    }

    public static void delete(Cliente f) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM cliente WHERE `id`="
                + f.getId();
        stm.execute(sql);
    }

}
