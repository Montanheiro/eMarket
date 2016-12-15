package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empresa;
import model.Produto;
import model.Promocao;

/**
 *
 * @author Bárbara
 */
public class ProdutoDAO {

    private ProdutoDAO() {
    }

    public static int create(Produto produto) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO produto (`CodBarras`, `Nome`, `Descricao`, `Margem`, `NCM`, `ValorUnitario`, `DataVencimento`, `Empresa_id`, `Promocao_id`) VALUES ('"
                + produto.getCodBarras() + "','"
                + produto.getNome() + "','"
                + produto.getDescricao() + "','"
                + produto.getMargem() + "','"
                + produto.getNcm() + "','"
                + produto.getValorUnitario() + "','"
                + produto.getDataVencimento() + "','"
                + produto.getEmpresa().getId() + "','"
                + produto.getPromocao().getId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        produto.setId(key);

        return key;
    }

    public static Produto retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produto where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
        Promocao promocao = PromocaoDAO.retreave(rs.getInt("Promocao_id"));
        return new Produto(
                rs.getInt("id"),
                rs.getInt("CodBarras"),
                rs.getString("Nome"),
                rs.getString("Descricao"),
                rs.getString("Margem"),
                rs.getString("NCM"),
                rs.getDouble("ValorUnitario"),
                rs.getString("DataVencimento"),
                empresa,
                promocao);
    }

    public static ArrayList<Produto> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produto";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Produto> produtos = new ArrayList<>();
        while (rs.next()) {
            Empresa empresa = EmpresaDAO.retreave(rs.getInt("Empresa_id"));
            Promocao promocao = PromocaoDAO.retreave(rs.getInt("Promocao_id"));
            produtos.add(new Produto(
                    rs.getInt("id"),
                    rs.getInt("CodBarras"),
                    rs.getString("Nome"),
                    rs.getString("Descricao"),
                    rs.getString("Margem"),
                    rs.getString("NCM"),
                    rs.getDouble("ValorUnitario"),
                    rs.getString("DataVencimento"),
                    empresa,
                    promocao));
        }
        rs.next();
        return produtos;
    }

    public static void update(Produto produto) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE produto SET "
                + "`CodBarras`='" + produto.getCodBarras()
                + ", `Nome`='" + produto.getNome()
                + ", `Descricao`='" + produto.getDescricao()
                + ", `Margem`='" + produto.getMargem()
                + ", `NCM`='" + produto.getNcm()
                + ", `ValorUnitario`='" + produto.getValorUnitario()
                + ", `DataVencimento`='" + produto.getDataVencimento()
                + "' WHERE `id`= "
                + produto.getId();
        stm.execute(sql);
    }

    public static void delete(Produto produto) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM produto WHERE `id`="
                + produto.getId();
        stm.execute(sql);
    }

}
