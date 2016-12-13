package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Status;

/**
 *
 * @author Bárbara
 */
public class StatusDAO {

    private StatusDAO() {
    }

    public static int create(Status st) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO status (`Descricao`) VALUES ('"
                + st.getDescricao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        st.setId(key);
        return key;

    }

    public static Status retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM status where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Status(id,
                rs.getString("descricao"));
    }

    public static ArrayList<Status> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM status";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Status> st = new ArrayList<>();
        while (rs.next()) {
            st.add(new Status(
                    rs.getInt("id"),
                    rs.getString("descricao")));
        }
        rs.next();
        return st;
    }

    public static void update(Status st) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE cargo SET "
                + "`Nome`='" + st.getDescricao()
                + "' WHERE `id`= "
                + st.getId();
        stm.execute(sql);
    }

    public static void delete(Status st) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM status WHERE `id`="
                + st.getId();
        stm.execute(sql);
    }

}
