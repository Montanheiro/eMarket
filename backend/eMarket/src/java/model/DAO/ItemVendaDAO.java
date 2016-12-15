package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FinanceiroCaixa;
import model.ItemVenda;
import model.Produto;
import model.Status;

/**
 *
 * @author Bárbara
 */
public class ItemVendaDAO {

    private ItemVendaDAO() {
    }

    public static int create(ItemVenda iv) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO item_venda (`Quantidade`, `ValorDaVenda`, `Vendas_id`, `FinanceiroCaixa_id`, `Produtos_id`, `Status_id`) VALUES ('"
                + iv.getQuantidade() + "','"
                + iv.getValorVenda() + "','"
                + iv.getVendaId() + "','"
                + iv.getFinanceiro().getId() + "','"
                + iv.getProduto().getId() + "','"
                + iv.getStatus().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        iv.setId(key);

        return key;
    }

    public static ItemVenda retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM item_venda where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Produto p = ProdutoDAO.retreave(rs.getInt("Produtos_id"));
        Status st = StatusDAO.retreave(rs.getInt("Status_id"));
        FinanceiroCaixa fc = FinanceiroCaixaDAO.retreave(rs.getInt("FinanceiroCaixa_id"));
        return new ItemVenda(
                rs.getInt("id"),
                rs.getDouble("Quantidade"),
                rs.getDouble("ValorDaVenda"),
                p, fc, st,
                rs.getInt("Vendas_id"));
    }

    public static ArrayList<ItemVenda> retreaveByVenda(int vendaId) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM item_venda where venda_id = " + vendaId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemVenda> iv = new ArrayList<>();
        if (rs.next()) {
            Produto p = ProdutoDAO.retreave(rs.getInt("Produtos_id"));
            Status st = StatusDAO.retreave(rs.getInt("Status_id"));
            FinanceiroCaixa fc = FinanceiroCaixaDAO.retreave(rs.getInt("FinanceiroCaixa_id"));
            iv.add(new ItemVenda(
                    rs.getInt("id"),
                    rs.getDouble("Quantidade"),
                    rs.getDouble("ValorDaVenda"),
                    p, fc, st,
                    rs.getInt("Vendas_id")));
        }
        return iv;
    }

    public static ArrayList<ItemVenda> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM item_venda";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemVenda> iv = new ArrayList<>();
        while (rs.next()) {
            Produto p = ProdutoDAO.retreave(rs.getInt("Produtos_id"));
            Status st = StatusDAO.retreave(rs.getInt("Status_id"));
            FinanceiroCaixa fc = FinanceiroCaixaDAO.retreave(rs.getInt("FinanceiroCaixa_id"));
            iv.add(new ItemVenda(
                    rs.getInt("id"),
                    rs.getDouble("Quantidade"),
                    rs.getDouble("ValorDaVenda"),
                    p, fc, st,
                    rs.getInt("Vendas_id")));
        }
        rs.next();
        return iv;
    }

    public static void update(ItemVenda iv) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE item_venda SET "
                + "`Quantidade`= '" + iv.getQuantidade()
                + "', `ValorDaVenda`= '" + iv.getValorVenda()
                + "' WHERE `id`= " + iv.getId();
        stm.execute(sql);
    }

    public static void delete(ItemVenda iv) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM item_venda WHERE `id` = " + iv.getId();
        stm.execute(sql);
    }

}
