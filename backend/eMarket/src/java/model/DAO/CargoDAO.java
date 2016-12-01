package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cargo;

/**
 *
 * @author Bárbara
 */
public class CargoDAO {

    private CargoDAO() {
    }

    //Metodo CREATE esta OK, testado e funcionando
    public static int create(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO `emark`.`cargo` (`Nome`) VALUES ('"
                    + c.getNome() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);
            return key;
            
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Cargo retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.cargo where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Cargo(id,
                    rs.getString("nome"));

        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Cargo> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.cargo";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Cargo> c = new ArrayList<>();
            while (rs.next()) {
                c.add(new Cargo(
                        rs.getInt("id"),
                        rs.getString("nome")));
            }
            rs.next();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM `emark`.`cargo` WHERE `id`="
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE `emark`.`cargo` SET "
                    + "`Nome`='" + c.getNome()
                    + "' WHERE `id`= "
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
