package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FinanceiroSaida;

/**
 *
 * @author Bárbara
 */
public class FinanceiroSaidaDAO {

    private FinanceiroSaidaDAO() {
    }

    public static int create(FinanceiroSaida fs) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO financeiro_saida (`DataVencimento`, `Databaixa`, `DataEmissao`, `Valor`, `MovimentacaoFinanceira_id`, `Compras_id`, `FormasDePagamento_id`, `Status_id`) VALUES ('"
                + fs.getDataVencimento() + "','"
                + fs.getDataBaixa() + "','"
                + fs.getDataEmissao() + "','"
                + fs.getValor() + "','"
                + fs.getMovimentacaoFinanceiraId() + "','"
                + fs.getCompraId() + "','"
                + fs.getFormaPagamentoId() + "','"
                + fs.getStatusId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fs.setId(key);

        return key;
    }

    public static FinanceiroSaida retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_saida where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new FinanceiroSaida(rs.getInt("id"),
                rs.getString("DataVencimento"),
                rs.getString("Databaixa"),
                rs.getString("DataEmissao"),
                rs.getDouble("Valor"),
                rs.getInt("MovimentacaoFinanceira_id"),
                rs.getInt("Compras_id"),
                rs.getInt("FormasDePagamento_id"),
                rs.getInt("Status_id"));
    }

    public static ArrayList<FinanceiroSaida> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_saida";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<FinanceiroSaida> fs = new ArrayList<>();
        while (rs.next()) {
            fs.add(new FinanceiroSaida(
                    rs.getInt("id"),
                    rs.getString("DataVencimento"),
                    rs.getString("Databaixa"),
                    rs.getString("DataEmissao"),
                    rs.getDouble("Valor"),
                    rs.getInt("MovimentacaoFinanceira_id"),
                    rs.getInt("Compras_id"),
                    rs.getInt("FormasDePagamento_id"),
                    rs.getInt("Status_id")));
        }
        rs.next();
        return fs;
    }

    public static void update(FinanceiroSaida fs) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE financeiro_saida SET "
                + "`DataVencimento`= '" + fs.getDataVencimento()
                + "', `Databaixa`= '" + fs.getDataBaixa()
                + "', `DataEmissao`= '" + fs.getDataEmissao()
                + "', `Valor`= '" + fs.getValor()
                + "' WHERE `id`= "
                + fs.getId();
        stm.execute(sql);
    }

    public static void delete(FinanceiroSaida fs) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM financeiro_saida WHERE `id`="
                + fs.getId();
        stm.execute(sql);
    }

}
