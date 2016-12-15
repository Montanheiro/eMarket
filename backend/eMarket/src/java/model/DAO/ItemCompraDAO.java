package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItemCompra;

/**
 *
 * @author Bárbara
 */
public class ItemCompraDAO {

    private ItemCompraDAO() {
    }

    public static int create(ItemCompra ic) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO item_compra (`Quantidade`, `ValorCompra`, `DataCompra`, `Compras_id`, `Produtos_id`, `Status_id`) VALUES ('"
                + ic.getQuantidade() + "','"
                + ic.getValorCompra() + "','"
                + ic.getDataCompra() + "','"
                + ic.getCompraId() + "','"
                + ic.getProdutoId() + "','"
                + ic.getStatusId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        ic.setId(key);

        return key;
    }

    public static ItemCompra retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM item_compra where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ItemCompra(rs.getInt("id"),
                rs.getDouble("Quantidade"),
                rs.getDouble("ValorCompra"),
                rs.getString("DataCompra"),
                rs.getInt("Compras_id"),
                rs.getInt("Produtos_id"),
                rs.getInt("Status_id"));
    }

    public static ArrayList<ItemCompra> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM item_compra";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ItemCompra> ic = new ArrayList<>();
        while (rs.next()) {
            ic.add(new ItemCompra(
                    rs.getInt("id"),
                    rs.getDouble("Quantidade"),
                    rs.getDouble("ValorCompra"),
                    rs.getString("DataCompra"),
                    rs.getInt("Compras_id"),
                    rs.getInt("Produtos_id"),
                    rs.getInt("Status_id")));
        }
        rs.next();
        return ic;
    }

    public static void update(ItemCompra ic) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE item_compra SET "
                + "`Quantidade`= '" + ic.getQuantidade()
                + "', `ValorCompra`= '" + ic.getValorCompra()
                + "', `DataCompra`= '" + ic.getDataCompra()
                + "' WHERE `id`= "
                + ic.getId();
        stm.execute(sql);
    }

    public static void delete(ItemCompra ic) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM item_compra WHERE `id`="
                + ic.getId();
        stm.execute(sql);
    }

}
