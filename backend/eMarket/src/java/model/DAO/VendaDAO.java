package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empresa;
import model.Usuario;
import model.Venda;

/**
 *
 * @author Bárbara
 */
public class VendaDAO {

    private VendaDAO() {
    }

    public static int create(Venda venda) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO venda (`DataDaVenda`, `ValorTotal`, `Empresa_id`, `Usuario_id`) VALUES ('"
                + venda.getDataVenda() + "','"
                + venda.getValorTotal() + "','"
                + venda.getEmpresa().getId() + "','"
                + venda.getUsuario().getId() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        venda.setId(key);
        return key;
    }

    public static Venda retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM venda where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
        Usuario usuario = UsuarioDAO.retreave(rs.getInt("Usuario_id"));
        return new Venda(id,
                rs.getDate("DataDaVenda"),
                rs.getDouble("ValorTotal"),
                empresa, usuario);
    }

    public static ArrayList<Venda> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM venda";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Venda> venda = new ArrayList<>();
        while (rs.next()) {
            Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
            Usuario usuario = UsuarioDAO.retreave(rs.getInt("Usuario_id"));
            venda.add(new Venda(
                    rs.getInt("id"),
                    rs.getDate("DataDaVenda"),
                    rs.getDouble("ValorTotal"),
                    empresa, usuario));
        }
        rs.next();
        return venda;
    }

    public static void update(Venda venda) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE venda SET "
                + "`DataDaVenda`= '" + venda.getDataVenda()
                + "', `ValorTotal`= '" + venda.getValorTotal()
                + "' WHERE `id`= "
                + venda.getId();
        stm.execute(sql);
    }

    public static void delete(Venda venda) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM venda WHERE `id`="
                + venda.getId();
        stm.execute(sql);
    }

}
