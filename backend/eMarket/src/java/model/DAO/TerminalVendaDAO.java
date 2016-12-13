package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empresa;
import model.TerminalVenda;
import model.Usuario;


/**
 *
 * @author Bárbara
 */
public class TerminalVendaDAO {

    private TerminalVendaDAO() {
    }
    
    public static int create(TerminalVenda terminal) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO terminalvenda (`NumeroDaMaquina`, `Token`, `Empresa_id`, `Usuario_id`) VALUES ('"
                + terminal.getNumeroMaquina()+ "','"
                + terminal.getToken()+ "','"
                + terminal.getEmpresa().getId() + "','"
                + terminal.getUsuario().getId() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        terminal.setId(key);
        return key;
    }

    public static TerminalVenda retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM terminalvenda where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
        Usuario usuario = UsuarioDAO.retreave(rs.getInt("Usuario_id"));
        return new TerminalVenda(id,
                rs.getInt("NumeroDaMaquina"),
                rs.getString("Token"),
                empresa, usuario);
    }

    public static ArrayList<TerminalVenda> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM terminalvenda";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<TerminalVenda> terminal = new ArrayList<>();
        while (rs.next()) {
            Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
            Usuario usuario = UsuarioDAO.retreave(rs.getInt("Usuario_id"));
            terminal.add(new TerminalVenda(
                    rs.getInt("id"),
                    rs.getInt("NumeroDaMaquina"),
                    rs.getString("Token"),
                    empresa, usuario));
        }
        rs.next();
        return terminal;
    }

    public static void update(TerminalVenda terminal) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE terminalvenda SET "
                + "`NumeroDaMaquina`= '" + terminal.getNumeroMaquina()
                + "', `Token`= '" + terminal.getToken()
                + "' WHERE `id`= "
                + terminal.getId();
        stm.execute(sql);
    }

    public static void delete(TerminalVenda terminal) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM terminalvenda WHERE `id`="
                + terminal.getId();
        stm.execute(sql);
    }

}
