package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.PessoaEmpresa;

/**
 *
 * @author Bárbara
 */
public class PessoaEmpresaDAO {

    private PessoaEmpresaDAO() {
    }

    public static int create(PessoaEmpresa e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO pessoa_empresa (`Pessoa_id`, `Empresa_id`) VALUES ('"
                + e.getPessoa().getId() + "','"
                + e.getEmpresa().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;
    }

    public static PessoaEmpresa retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa_empresa where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new PessoaEmpresa(rs.getInt("id"),
                rs.getInt("Pessoa_id"),
                rs.getInt("Empresa_id"));
    }

    public static ArrayList<PessoaEmpresa> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa_empresa";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<PessoaEmpresa> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new PessoaEmpresa(
                    rs.getInt("id"),
                    rs.getInt("Pessoa_id"),
                    rs.getInt("Empresa_id")));
        }
        rs.next();
        return e;
    }

    public static void update(PessoaEmpresa e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE pessoa_empresa SET "
                + "`Pessoa_id`='" + e.getPessoaId()
                + ", `Empresa_id`='" + e.getEmpresaId()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }

    public static void delete(PessoaEmpresa e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM pessoa_empresa WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
