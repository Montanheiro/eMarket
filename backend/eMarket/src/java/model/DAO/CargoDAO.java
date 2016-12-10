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
    public static int create(Cargo c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO cargo (`Nome`) VALUES ('"
                    + c.getNome() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);
            return key;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Cargo retreave(int id) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM cargo where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Cargo(id,
                    rs.getString("nome"));

    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Cargo> retreaveAll() throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM cargo";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Cargo> c = new ArrayList<>();
            while (rs.next()) {
                c.add(new Cargo(
                        rs.getInt("id"),
                        rs.getString("nome")));
            }
            rs.next();
            return c;
    }

    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Cargo c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM cargo WHERE `id`="
                    + c.getId();
            stm.execute(sql);
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Cargo c) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE cargo SET "
                    + "`Nome`='" + c.getNome()
                    + "' WHERE `id`= "
                    + c.getId();
            stm.execute(sql);
    }

}
