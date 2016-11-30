package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Compra;

/**
 *
 * @author Bárbara
 */
public class CompraDAO {

    private CompraDAO() {
    }

    public static int create(Compra c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //INSERT INTO `emark`.`compras` (`id`, `Data`, `ValorTotal`, `Caixa`, `Empresa_id`,
            //`Usuario_id`, `Fornecedor_id`) VALUES ('?', '?', '?', '?', '?', '?', '?');
            String sql
                    = "INSERT INTO `emark`.`compras` (`Data`, `ValorTotal`, `Caixa`) VALUES ('"
                    + c.getData() + "','"
                    + c.getValorTotal() + "','"
                    + c.getCaixa() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);

            return key;

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public static Compra retreave(int id) {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //SELECT * FROM emark.compras where id =1;
            String sql = "SELECT * FROM emark.compras where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new Compra(rs.getInt("id"),
                    rs.getString("data"),
                    rs.getDouble("valorTotal"),
                    rs.getString("caixa"),
                    rs.getInt("empresaId"),
                    rs.getInt("usuarioId"),
                    rs.getInt("fornecedorId"));

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ArrayList<Compra> retreaveAll() {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.compras";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Compra> c = new ArrayList<>();

            while (rs.next()) {
                c.add(new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal"),
                        rs.getString("caixa"),
                        rs.getInt("empresaId"),
                        rs.getInt("usuarioId"),
                        rs.getInt("fornecedorId")));
            }

            rs.next();
            return c;

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void delete(Compra c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //DELETE FROM `emark`.`cargo` WHERE `id`='4';
            String sql = "DELETE FROM `emark`.`compras` WHERE `id`="
                    + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Compra c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //INSERT INTO `emark`.`compras` (`id`, `Data`, `ValorTotal`, `Caixa`,
            //`Empresa_id`, `Usuario_id`, `Fornecedor_id`) VALUES ('1', '10/10', 
            //'100', '1', '1', '1', '1');
            String sql = "UPDATE `emark`.`compras` SET "
                    + "`Data`='" + c.getData()
                    +"', ValorTotal = '" + c.getValorTotal()
                    +"', Caixa = '" + c.getCaixa()
                    + "' WHERE `id`= "
                    + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
