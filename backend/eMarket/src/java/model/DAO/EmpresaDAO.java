package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Compra;
import model.Empresa;

/**
 *
 * @author Bárbara,Mateus
 */
public class EmpresaDAO {

    private EmpresaDAO() {
    }

    public static int create(Empresa e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();        
            String sql
                    = "INSERT INTO empresa (Nome, RazaoSocial, CNPJ, DataContratacao,DataCancelamnetoContrato, status_id) VALUES ('"
                    + e.getNome() + ",'"
                    + e.getRazaoSocial() + "','"
                    + e.getCnpj() + "','"
                    + e.getDataContratacao() + "','"
                    +e.getDataCancelamentoContrato()+"','"
                    +e.getStatus()+ "','"
                    +"')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            e.setId(key);

            return key;

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public static Empresa retreave(int id) {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //SELECT * FROM emark.cargo where id =1;
            String sql = "SELECT * FROM empresa where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            //Compra c = CompraDAO.retreaveByEmpresa(id);

            return new Empresa(id,
                    rs.getString("Nome"),
                    rs.getString("RazaoSocial"),
                    rs.getString("CNPJ"),
                    rs.getDate("DataContratacao"),
                    rs.getDate("DataCancelamentoContrato"),
                    rs.getInt("Status"));
            /*,
                    c);*/

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Empresa> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            String sql = "SELECT * FROM empresa";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Empresa> em = new ArrayList<>();

            while (rs.next()) {
                //Compra c = CompraDAO.retreaveByEmpresa(rs.getInt("id"));
                em.add(new Empresa(
                        rs.getInt("id"),
                        rs.getString("Nome"),
                        rs.getString("RazaoSocial"),
                        rs.getString("CNPJ"),
                        rs.getDate("DataContratacao"),
                        rs.getDate("DataCancelamentoContrato"),
                        rs.getInt("Status")));
                /*,
                        c)*/
            }

            return em;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static void delete(Empresa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM empresa WHERE `id`="
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Empresa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            String sql = "UPDATE empresa SET "
                    + "`Nome`='" + c.getNome()
                    + "`RazaoSocial`= '" + c.getRazaoSocial()
                    + "', `CNPJ` = '" + c.getCnpj()
                    + "', `DataContratacao` = '" + c.getDataContratacao()
                    +"', DataCancelamentoContrato='"+ c.getDataCancelamentoContrato()
                    +"', status_id='"+ c.getStatus()
                    + "' WHERE `id`= " + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
