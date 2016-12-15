package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Promocao;

/**
 *
 * @author Bárbara
 */
public class PromocaoDAO {

    private PromocaoDAO() {
    }

    public static int create(Promocao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO promocao (`Descricao`, `DataInicio`, `DataFinal`, `Porcentagem`) VALUES ('"
                + e.getDescricao() + "','"
                + e.getDataInicio() + "','"
                + e.getDataFim() + "','"
                + e.getPorcentagem() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;
    }

    public static Promocao retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM promocao where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Promocao(rs.getInt("id"),
                rs.getString("Descricao"),
                rs.getString("DataInicio"),
                rs.getString("DataFinal"),
                rs.getInt("Porcentagem"));
    }

    public static ArrayList<Promocao> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM produto";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Promocao> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new Promocao(
                    rs.getInt("id"),
                    rs.getString("Descricao"),
                    rs.getString("DataInicio"),
                    rs.getString("DataFinal"),
                    rs.getInt("Porcentagem")));
        }
        rs.next();
        return e;
    }

    public static void update(Promocao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE promocao SET "
                + "`Descricao`='" + e.getDescricao()
                + ", `DataInicio`='" + e.getDataInicio()
                + ", `DataFinal`='" + e.getDataFim()
                + ", `Porcentagem`='" + e.getPorcentagem()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }

    public static void delete(Promocao e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM promocao WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
