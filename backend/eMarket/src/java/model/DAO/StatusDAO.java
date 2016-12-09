package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Status;

/**
 *
 * @author Bárbara
 */
public class StatusDAO {

    private StatusDAO() {
    }

  
    public static int create(Status s) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO status (`Descricao`) VALUES ('"
                    + s.getDescricao()+ "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            s.setId(key);
            return key;
            
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    public static Status retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM status where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Status(id,
                    rs.getString("decricao"));

        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static ArrayList<Status> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM status";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Status> c = new ArrayList<>();
            while (rs.next()) {
                c.add(new Status(
                        rs.getInt("id"),
                        rs.getString("descricao")));
            }
            rs.next();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static void delete(Status s) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM status WHERE `id`="
                    + s.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void update(Status s) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE cargo SET "
                    + "`Nome`='" + s.getDescricao()
                    + "' WHERE `id`= "
                    + s.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
