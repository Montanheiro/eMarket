package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Bárbara
 */
public class ProdutoDAO {

    private ProdutoDAO() {
    }

    public static int create(Produto e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produto (`CodBarras`, `Nome`, `Descricao`, `Margem`, `NCM`, `ValorUnitario`, `DataVencimento`, `Empresa_id`, `Promocao_id`) VALUES ('"
                + e.getCodBarras() + "','"
                + e.getNome() + "','"
                + e.getDescricao() + "','"
                + e.getMargem() + "','"
                + e.getNcm() + "','"
                + e.getValorUnitario() + "','"
                + e.getDataVencimento() + "','"
                + e.getEmpresaId() + "','"
                + e.getPromocaoId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;
    }

    public static Produto retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produto where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Produto(rs.getInt("id"),
                rs.getInt("CodBarras"),
                rs.getString("Nome"),
                rs.getString("Descricao"),
                rs.getString("Margem"),
                rs.getString("NCM"),
                rs.getDouble("ValorUnitario"),
                rs.getString("DataVencimento"),
                rs.getInt("Empresa_id"),
                rs.getInt("Promocao_id"));
    }

    public static ArrayList<Produto> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produto";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Produto> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new Produto(
                    rs.getInt("id"),
                    rs.getInt("CodBarras"),
                    rs.getString("Nome"),
                    rs.getString("Descricao"),
                    rs.getString("Margem"),
                    rs.getString("NCM"),
                    rs.getDouble("ValorUnitario"),
                    rs.getString("DataVencimento"),
                    rs.getInt("Empresa_id"),
                    rs.getInt("Promocao_id")));
        }
        rs.next();
        return e;
    }

    public static void update(Produto e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE produto SET "
                + "`CodBarras`='" + e.getCodBarras()
                + ", `Nome`='" + e.getNome()
                + ", `Descricao`='" + e.getDescricao()
                + ", `Margem`='" + e.getMargem()
                + ", `NCM`='" + e.getNcm()
                + ", `ValorUnitario`='" + e.getValorUnitario()
                + ", `DataVencimento`='" + e.getDataVencimento()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }

    public static void delete(Produto e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM produto WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
