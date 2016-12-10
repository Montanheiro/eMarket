package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MovimentacaoFinanceira;

/**
 *
 * @author Bárbara
 */
public class MovimentacaoFinanceiraDAO {

    private MovimentacaoFinanceiraDAO() {
    }


    public static int create(MovimentacaoFinanceira e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO movimentacao_financeira (`Realizado`, `AReceber`) VALUES ('"
                + e.getRealizado() + "','"
                + e.getaReceber() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;
    }


    public static MovimentacaoFinanceira retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM movimentacao_financeira where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new MovimentacaoFinanceira(rs.getInt("id"),
                rs.getDouble("Realizado"),
                rs.getDouble("AReceber"));
    }

    
    public static ArrayList<MovimentacaoFinanceira> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM movimentacao_financeira";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<MovimentacaoFinanceira> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new MovimentacaoFinanceira(
                    rs.getInt("id"),
                    rs.getDouble("Realizado"),
                    rs.getDouble("AReceber")));
        }
        rs.next();
        return e;
    }

   
    public static void update(MovimentacaoFinanceira e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE movimentacao_financeira SET "
                + "`Realizado`='" + e.getRealizado()
                + ", `AReceber`='" + e.getaReceber()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }


    public static void delete(MovimentacaoFinanceira e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM movimentacao_financeira WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
