package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Fornecedor;
import model.Pessoa;
import model.Status;

/**
 *
 * @author Bárbara
 */
public class FornecedorDAO {
    
    private FornecedorDAO() {
    }

    public static int create(Fornecedor f) throws SQLException {
        PessoaDAO.create(f.getPessoa());
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO fornecedor (`Responsavel`, `IE`, `IM`, `Representante`, `Pessoa_id`, `Status_id`) VALUES ('"
                + f.getResponsavel() + "','"
                + f.getIE()+ "','"
                + f.getIM()+ "','"
                + f.getRepresentante() + "','"
                + f.getPessoa().getId() + "','"
                + f.getStatus().getId() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        f.setId(key);
        return key;
    }

    public static Fornecedor retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM fornecedor where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Pessoa p = PessoaDAO.retreave(rs.getInt("pessoa_id")); 
        Status st = StatusDAO.retreave(rs.getInt("Status_id"));                
        return new Fornecedor(id,
                rs.getString("Responsavel"),
                rs.getInt("IE"),
                rs.getString("IM"),
                rs.getString("Representante"),
                p, st);
    }

    public static ArrayList<Fornecedor> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM fornecedor";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Fornecedor> f = new ArrayList<>();
        while (rs.next()) {
        Pessoa p = PessoaDAO.retreave(rs.getInt("pessoa_id")); 
        Status st = StatusDAO.retreave(rs.getInt("Status_id"));                
            f.add(new Fornecedor(
                    rs.getInt("id"),
                rs.getString("Responsavel"),
                rs.getInt("IE"),
                rs.getString("IM"),
                rs.getString("Representante"),
                p, st));
        }
        rs.next();
        return f;
    }

    public static void update(Fornecedor f) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE fornecedor SET "
                + "`Responsavel`= '" + f.getResponsavel()
                + "', `IE`= '" + f.getIE()
                + "', `IM`= '" + f.getIM()
                + "', `Representante`= '" + f.getRepresentante()
                + "' WHERE `id`= "
                + f.getId();
        stm.execute(sql);
        PessoaDAO.update(f.getPessoa());                
    }

    public static void delete(Fornecedor f) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM fornecedor WHERE `id`="
                + f.getId();
        stm.execute(sql);
    }

}
