package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Email;

/**
 *
 * @author Bárbara
 */
public class EmailDAO {

    private EmailDAO() {
    }

    //Metodo CREATE esta OK, testado e funcionando
    public static Email create(Email e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO email (`Email`, `Pessoa_id`) VALUES ('"
                + e.getEmail() + "','"
                + e.getPessoaId() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        e.setId(key);

        return e;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Email retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM email where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Email(rs.getInt("id"),
                rs.getString("Email"),
                rs.getInt("pessoa_id"));
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Email> retreaveByPessoa(int pessoaId) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM email where Pessoa_id =" + pessoaId;
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Email> temp = new ArrayList<>();
        while (rs.next()) {
            temp.add(new Email(
                    rs.getInt("id"),
                    rs.getString("Email"),
                    rs.getInt("pessoa_id")));
        }
        return temp;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Email> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM email";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Email> e = new ArrayList<>();
        while (rs.next()) {
            e.add(new Email(
                    rs.getInt("id"),
                    rs.getString("Email"),
                    rs.getInt("pessoa_id")));
        }
        rs.next();
        return e;
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Email e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE email SET "
                + "`Email`='" + e.getEmail()
                + "' WHERE `id`= "
                + e.getId();
        stm.execute(sql);
    }

//Metodo DELETE esta OK, testado e funcionando    
    public static void delete(Email e) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM email WHERE `id`="
                + e.getId();
        stm.execute(sql);
    }

}
