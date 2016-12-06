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

    public static int create(Empresa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            //INSERT INTO `emark`.`empresa` (`id`, `Nome`, `RazaoSocial`, `CNPJ`, `DataContratacao`) VALUES ('1', 'Comercio de Balas', 'Balas e Cia', '123456789', '10/10/10');

            String sql
                    = "INSERT INTO empresa (`Nome`, `RazaoSocial`, `CNPJ`, `DataContratacao`) VALUES ('"
                    + c.getNome() + ",'"
                    + c.getRazaoSocial() + "','"
                    + c.getCnpj() + "','"
                    + c.getDataContratacao() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);

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
                    rs.getString("DataContratacao"));
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
                        rs.getString("DataContratacao")));
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

//UPDATE `emark`.`empresa` SET `Nome`='Comercio de Verduras', `RazaoSocial`='Hort Frut verdurex',
//`CNPJ`='1234567890', `DataContratacao`='2010-10-11' WHERE `id`='1';
            String sql = "UPDATE empresa SET "
                    + "`Nome`='" + c.getNome()
                    + "`RazaoSocial`= '" + c.getRazaoSocial()
                    + "', `CNPJ` = '" + c.getCnpj()
                    + "', `DataContratacao` = '" + c.getDataContratacao()
                    + "' WHERE `id`= " + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
