package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.TipoPagamento;

/**
 *
 * @author Bárbara
 */
public class TipoPagamentoDAO {
    
    private TipoPagamentoDAO() {
    }
    
    public static int create(TipoPagamento tipo) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO tipopagamento (`Descricao`) VALUES ('"
                + tipo.getDescricao()+ "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        tipo.setId(key);
        return key;
    }

    public static TipoPagamento retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM tipopagamento where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new TipoPagamento(id,
                rs.getString("Descricao"));
    }

    public static ArrayList<TipoPagamento> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM tipopagamento";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<TipoPagamento> tipo = new ArrayList<>();
        while (rs.next()) {
            tipo.add(new TipoPagamento(
                    rs.getInt("id"),
                    rs.getString("Descricao")));
        }
        rs.next();
        return tipo;
    }

    public static void update(TipoPagamento tipo) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE tipopagamento SET "
                + "`Descricao`= '" + tipo.getDescricao()
                + "' WHERE `id`= "
                + tipo.getId();
        stm.execute(sql);
    }

    public static void delete(TipoPagamento tipo) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM tipopagamento WHERE `id`="
                + tipo.getId();
        stm.execute(sql);
    }

}

