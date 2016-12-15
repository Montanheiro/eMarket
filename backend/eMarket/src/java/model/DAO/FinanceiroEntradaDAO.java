package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FinanceiroEntrada;

/**
 *
 * @author Bárbara
 */
public class FinanceiroEntradaDAO {

    private FinanceiroEntradaDAO() {
    }

    public static int create(FinanceiroEntrada fe) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO financeiro_entrada (`DataVencimento`, `Valor`, `NumeroParcela`, `DataBaixa`, `MovimentacaoFinanceira_id`, `FormasDePagamento_id`, `Vendas_id`, `Status_id`) VALUES ('"
                + fe.getDataVencimento() + "','"
                + fe.getValor() + "','"
                + fe.getNumParcela() + "','"
                + fe.getDataBaixa() + "','"
                + fe.getMovimentacaoFinanceiraId() + "','"
                + fe.getFormaPagamentoId() + "','"
                + fe.getVendaId() + "','"
                + fe.getStatusId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fe.setId(key);

        return key;
    }

    public static FinanceiroEntrada retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_entrada where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new FinanceiroEntrada(rs.getInt("id"),
                rs.getString("DataVencimento"),
                rs.getDouble("Valor"),
                rs.getInt("NumeroParcela"),
                rs.getString("DataBaixa"),
                rs.getInt("MovimentacaoFinanceira_id"),
                rs.getInt("FormasDePagamento_id"),
                rs.getInt("Vendas_id"),
                rs.getInt("Status_id"));
    }

    public static ArrayList<FinanceiroEntrada> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_entrada";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<FinanceiroEntrada> fe = new ArrayList<>();
        while (rs.next()) {
            fe.add(new FinanceiroEntrada(
                    rs.getInt("id"),
                    rs.getString("DataVencimento"),
                    rs.getDouble("Valor"),
                    rs.getInt("NumeroParcela"),
                    rs.getString("DataBaixa"),
                    rs.getInt("MovimentacaoFinanceira_id"),
                    rs.getInt("FormasDePagamento_id"),
                    rs.getInt("Vendas_id"),
                    rs.getInt("Status_id")));
        }
        rs.next();
        return fe;
    }

    public static void update(FinanceiroEntrada fe) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE financeiro_entrada SET "
                + "`DataVencimento`= '" + fe.getDataVencimento()
                + "', `Valor`= '" + fe.getValor()
                + "', `NumeroParcela`= '" + fe.getNumParcela()
                + "', `DataBaixa`= '" + fe.getDataBaixa()
                + "' WHERE `id`= "
                + fe.getId();
        stm.execute(sql);
    }

    public static void delete(FinanceiroEntrada fe) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM financeiro_entrada WHERE `id`="
                + fe.getId();
        stm.execute(sql);
    }

}
