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
 * @author Bárbara
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
                    = "INSERT INTO `emark`.`Empresa` (`Nome`, `RazaoSocial`, `CNPJ`, `DataContratacao`) VALUES ('"
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
            String sql = "SELECT * FROM emark.Empresa where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            Compra c = CompraDAO.retreaveByEmpresa(id);
            
            return new Empresa(id,
                    rs.getString("nome"), 
                    rs.getString("razaoSocial"), 
                    rs.getString("cnpj"), 
                    rs.getString("dataContratacao"),
                    c);

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ArrayList<Empresa> retreaveAll() {
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            
            String sql = "select * from clientes";
            
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList<Empresa> em = new ArrayList<>();
            
            while (rs.next()){
                Compra c = CompraDAO.retreaveByEmpresa(rs.getInt("id"));
                em.add(new Empresa(
                        rs.getInt("pk_cliente"), 
                        rs.getString("nome"),
                        rs.getString("nome"),
                        rs.getString("cpf"), 
                        c));
            }
            
            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;

    }

    public static void delete(Empresa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //DELETE FROM `emark`.`Empresa` WHERE `id`='4';
            String sql = "DELETE FROM `emark`.`Empresa` WHERE `id`="
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

            //UPDATE `emark`.`Empresa` SET `Nome`='Atendente' WHERE `id`='4';
            String sql = "UPDATE `emark`.`cargo` SET "
                    + "`Nome`='" + c.getNome()
                    + "' WHERE `id`= "
                    + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
