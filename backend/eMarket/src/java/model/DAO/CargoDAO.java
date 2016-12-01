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

    public static int create(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            //INSERT INTO `emark`.`cargo` (`id`, `Nome`) VALUES ('1', 'Secretario');

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

    public static Cargo retreave(int id) {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //SELECT * FROM emark.cargo where id =1;
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

    public static void delete(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //DELETE FROM `emark`.`cargo` WHERE `id`='4';
            
            String sql = "DELETE FROM `emark`.`cargo` WHERE `id`="
                    + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Cargo c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            
            //UPDATE `emark`.`cargo` SET `Nome`='Atendente' WHERE `id`='4';
            
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
