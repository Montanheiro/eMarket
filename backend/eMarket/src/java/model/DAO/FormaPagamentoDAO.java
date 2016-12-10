package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FormaPagamento;

/**
 *
 * @author Bárbara
 */
public class FormaPagamentoDAO {

    private FormaPagamentoDAO() {
    }

    public static int create(FormaPagamento fp) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO formapagamento (`Nome`, `MaxParcela`, `TipoPagamento_id`) VALUES ('"
                + fp.getNome() + "','"
                + fp.getMaxParcela() + "','"
                + fp.getTipoPagamentoId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fp.setId(key);

        return key;
    }

    public static FormaPagamento retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM formapagamento where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new FormaPagamento(rs.getInt("id"),
                rs.getString("Nome"),
                rs.getInt("MaxParcela"),
                rs.getInt("TipoPagamento_id"));
    }

    public static ArrayList<FormaPagamento> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM formapagamento";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<FormaPagamento> fp = new ArrayList<>();
        while (rs.next()) {
            fp.add(new FormaPagamento(
                    rs.getInt("id"),
                    rs.getString("Nome"),
                    rs.getInt("MaxParcela"),
                    rs.getInt("TipoPagamento_id")));
        }
        rs.next();
        return fp;
    }

    public static void update(FormaPagamento fp) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE formapagamento SET "
                + "`Nome`= '" + fp.getNome()
                + "', `MaxParcela`= '" + fp.getMaxParcela()
                + "' WHERE `id`= "
                + fp.getId();
        stm.execute(sql);
    }

    public static void delete(FormaPagamento fp) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM formapagamento WHERE `id`="
                + fp.getId();
        stm.execute(sql);
    }

}
