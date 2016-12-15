package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FinanceiroCaixa;

/**
 *
 * @author Bárbara
 */
public class FinanceiroCaixaDAO {

    private FinanceiroCaixaDAO() {
    }

    public static int create(FinanceiroCaixa fc) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO financeiro_caixa (`ValorInicial`, `ValorFinal`, `DataAbertura`, `DataFechamento`, `Sangria`, `Suprimentos`, `Descicao`, `TerminaldeVenda_id`) VALUES ('"
                + fc.getValorInicial() + "','"
                + fc.getValorFinal() + "','"
                + fc.getDataAbertura() + "','"
                + fc.getDataFechamento() + "','"
                + fc.getSangria() + "','"
                + fc.getSuprimento() + "','"
                + fc.getDescricao() + "','"
                + fc.getTerminalVendaId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        fc.setId(key);

        return key;
    }

    public static FinanceiroCaixa retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_caixa where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new FinanceiroCaixa(rs.getInt("id"),
                rs.getDouble("ValorInicial"),
                rs.getDouble("ValorFinal"),
                rs.getString("DataAbertura"),
                rs.getString("DataFechamento"),
                rs.getDouble("Sangria"),
                rs.getDouble("Suprimentos"),
                rs.getString("Descicao"),
                rs.getInt("TerminaldeVenda_id"));
    }

    public static ArrayList<FinanceiroCaixa> retreaveByTerminal(int terminalVendaId) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_caixa where TerminaldeVenda_id =" + terminalVendaId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<FinanceiroCaixa> temp = new ArrayList<>();
        if (rs.next()) {
            temp.add(new FinanceiroCaixa(
                    rs.getInt("id"),
                    rs.getDouble("ValorInicial"),
                    rs.getDouble("ValorFinal"),
                    rs.getString("DataAbertura"),
                    rs.getString("DataFechamento"),
                    rs.getDouble("Sangria"),
                    rs.getDouble("Suprimentos"),
                    rs.getString("Descicao"),
                    rs.getInt("TerminaldeVenda_id")));
        }
        return temp;
    }

    public static ArrayList<FinanceiroCaixa> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM financeiro_caixa";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<FinanceiroCaixa> fc = new ArrayList<>();
        while (rs.next()) {
            fc.add(new FinanceiroCaixa(
                    rs.getInt("id"),
                    rs.getDouble("ValorInicial"),
                    rs.getDouble("ValorFinal"),
                    rs.getString("DataAbertura"),
                    rs.getString("DataFechamento"),
                    rs.getDouble("Sangria"),
                    rs.getDouble("Suprimentos"),
                    rs.getString("Descicao"),
                    rs.getInt("TerminaldeVenda_id")));
        }
        rs.next();
        return fc;
    }

    public static void update(FinanceiroCaixa fc) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE financeiro_caixa SET "
                + "`ValorInicial`= '" + fc.getValorInicial()
                + "', `ValorFinal`= '" + fc.getValorFinal()
                + "', `DataAbertura`= '" + fc.getDataAbertura()
                + "', `DataFechamento`= '" + fc.getDataFechamento()
                + "', `Sangria`= '" + fc.getSangria()
                + "', `Suprimentos`= '" + fc.getSuprimento()
                + "', `Descicao`= '" + fc.getDescricao()
                + "' WHERE `id`= "
                + fc.getId();
        stm.execute(sql);
    }

    public static void delete(FinanceiroCaixa fc) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM financeiro_caixa WHERE `id`="
                + fc.getId();
        stm.execute(sql);
    }

}
