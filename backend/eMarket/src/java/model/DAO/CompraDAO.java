package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Compra;

/**
 *
 * @author Bárbara
 */
public class CompraDAO {

    private CompraDAO() {
    }

    public static int create(Compra c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO compra (`Data`, `ValorTotal`, `Caixa`) VALUES ('"
                    + c.getData() + "','"
                    + c.getValorTotal() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);

            return key;

    }

    public static Compra retreave(int id) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            String sql = "SELECT * FROM compra where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new Compra(rs.getInt("id"),
                    rs.getString("data"),
                    rs.getDouble("valorTotal"),
                    rs.getInt("empresaId"),
                    rs.getInt("usuarioId"),
                    rs.getInt("fornecedorId"));

    }

    public static ArrayList<Compra> retreaveAll() throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM compra";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Compra> c = new ArrayList<>();

            while (rs.next()) {
                c.add(new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal"),
                        rs.getInt("empresaId"),
                        rs.getInt("usuarioId"),
                        rs.getInt("fornecedorId")));
            }

            rs.next();
            return c;

    }

    public static Compra retreaveByEmpresa(int empresaId) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM compra where Empresa_id =" + empresaId;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {

                return new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal"),
                        rs.getInt("empresaId"),
                        rs.getInt("usuarioId"),
                        rs.getInt("fornecedorId"));
            }
        return null;
    }

    public static Compra retreaveByUsuario(int usuarioId) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM compra where Usuario_id =" + usuarioId;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {

                return new Compra(
                        rs.getInt("id"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal"),
                        rs.getInt("empresaId"),
                        rs.getInt("usuarioId"),
                        rs.getInt("fornecedorId"));
            }
        return null;
    }

    public static void delete(Compra c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            String sql = "DELETE FROM compra WHERE `id`="
                    + c.getId();

            stm.execute(sql);

    }

    public static void update(Compra c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE compras SET "
                    + "`Data`='" + c.getData()
                    + "', ValorTotal = '" + c.getValorTotal()
                    + "' WHERE `id`= "
                    + c.getId();

            stm.execute(sql);

    }

}
