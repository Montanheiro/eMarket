package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empresa;

/**
 *
 * @author Bárbara, Mateus
 */
public class EmpresaDAO {

    private EmpresaDAO() {
    }

    public static int create(Empresa e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO empresa (Nome, RazaoSocial, CNPJ, DataContratacao,DataCancelamnetoContrato, status_id) VALUES ('"
                + e.getNome() + ",'"
                + e.getRazaoSocial() + "','"
                + e.getCnpj() + "','"
                + e.getDataContratacao() + "','"
                + e.getDataCancelamentoContrato() + "','"
                + e.getStatusId() + "','"
                + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return key;

    }

    public static Empresa retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empresa WHERE id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();

        return new Empresa(id,
                rs.getString("Nome"),
                rs.getString("RazaoSocial"),
                rs.getString("CNPJ"),
                rs.getDate("DataContratacao"),
                rs.getDate("DataCancelamentoContrato"),
                rs.getInt("status_id"));
    }

    public static ArrayList<Empresa> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();

        String sql = "SELECT * FROM empresa";
        ResultSet rs = stm.executeQuery(sql);

        ArrayList<Empresa> em = new ArrayList<>();

        while (rs.next()) {
            em.add(new Empresa(
                    rs.getInt("id"),
                    rs.getString("Nome"),
                    rs.getString("RazaoSocial"),
                    rs.getString("CNPJ"),
                    rs.getDate("DataContratacao"),
                    rs.getDate("DataCancelamentoContrato"),
                    rs.getInt("status_id")));
        }

        return em;
    }

    public static void delete(Empresa c) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM empresa WHERE `id`="
                + c.getId();
        stm.execute(sql);
    }

    public static void update(Empresa c) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();

        String sql = "UPDATE empresa SET "
                + "`Nome`='" + c.getNome()
                + "`RazaoSocial`= '" + c.getRazaoSocial()
                + "', `CNPJ` = '" + c.getCnpj()
                + "', `DataContratacao` = '" + c.getDataContratacao()
                + "', DataCancelamentoContrato='" + c.getDataCancelamentoContrato()
                + "', status_id='" + c.getStatusId()
                + "' WHERE `id`= " + c.getId();

        stm.execute(sql);

    }

}
