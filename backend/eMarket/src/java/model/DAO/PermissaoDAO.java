package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Permissao;

/**
 *
 * @author Bárbara
 */
public class PermissaoDAO {

    private PermissaoDAO() {
    }

    public static int create(Permissao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO permissao (`Descricao`, `Modulo_URL`, `Icon`) VALUES ('"
                + e.getDescricao() + "','"
                + e.getModuloURL() + "','"
                + e.getIcon() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;
    }

    public static Permissao retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM permissao where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Permissao(rs.getInt("id"),
                rs.getString("Descricao"),
                rs.getString("Modulo_URL"),
                rs.getString("Icon"));
    }

    public static ArrayList<Permissao> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM permissao";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Permissao> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new Permissao(
                    rs.getInt("id"),
                    rs.getString("Descricao"),
                    rs.getString("Modulo_URL"),
                    rs.getString("Icon")));
        }
        rs.next();
        return e;
    }

    public static void update(Permissao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE permissao SET "
                + "`Descricao`='" + e.getDescricao()
                + ", `Modulo_URL`='" + e.getModuloURL()
                + ", `Icon`='" + e.getIcon()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }

    public static void delete(Permissao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM permissao WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
