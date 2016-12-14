package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empresa;
import model.Status;

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
                = "INSERT INTO empresa (`Nome`, `RazaoSocial`, `CNPJ`, `DataContratacao`, `DataCancelamentoContrato`, `status_id`) VALUES ('"
                + e.getNome() + ",'"
                + e.getRazaoSocial() + "','"
                + e.getCnpj() + "','"
                + e.getDataContratacao() + "','"
                + e.getDataCancelamentoContrato() + "','"
                + e.getStatus().getId() + "')";

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
        Status st = StatusDAO.retreave(rs.getInt("status_id"));        
        return new Empresa(id,
                rs.getString("Nome"),
                rs.getString("RazaoSocial"),
                rs.getString("CNPJ"),
                rs.getString("DataContratacao"),
                rs.getString("DataCancelamentoContrato"),
                st);
    }

    public static ArrayList<Empresa> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM empresa";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Empresa> em = new ArrayList<>();
        while (rs.next()) {
        Status st = StatusDAO.retreave(rs.getInt("status_id"));        
            em.add(new Empresa(
                    rs.getInt("id"),
                    rs.getString("Nome"),
                    rs.getString("RazaoSocial"),
                    rs.getString("CNPJ"),
                    rs.getString("DataContratacao"),
                    rs.getString("DataCancelamentoContrato"),
                    st));
        }

        return em;
    }

    public static void update(Empresa em) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE empresa SET "
                + "`Nome` = '" + em.getNome()
                + "', `RazaoSocial` = '" + em.getRazaoSocial()
                + "', `CNPJ` = '" + em.getCnpj()
                + "', `DataContratacao` = '" + em.getDataContratacao()
                + "', DataCancelamentoContrato = '" + em.getDataCancelamentoContrato()
                + "', status_id = '" + em.getStatusId()
                + "' WHERE `id` = " + em.getId();
        stm.execute(sql);
    }

    public static void delete(Empresa em) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM empresa WHERE `id`="
                + em.getId();
        stm.execute(sql);
    }

}
