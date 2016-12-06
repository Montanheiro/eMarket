package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;

/**
 *
 * @author Bárbara
 */
public class ContatoDAO {
    
    private ContatoDAO() {
    }
    
    //Metodo CREATE esta OK, testado e funcionando
        public static int create(Contato c){
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO contato (`Telefone`, `Pessoa_id`) VALUES ('"
                    + c.getTelefone() + "','"
                    + c.getPessoaId() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            c.setId(key);
            
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    
    //Metodo RETREAVE esta OK, testado e funcionando
    public static Contato retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM contato where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Contato(rs.getInt("id"),
                    rs.getString("Telefone"),
                    rs.getInt("Pessoa_id"));
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Contato retreaveByPessoa(int pessoaId) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM contato where Pessoa_id =" + pessoaId;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                return new Contato(
                        rs.getInt("id"),
                        rs.getString("Telefone"),
                        rs.getInt("Pessoa_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Contato> retreaveAll() {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM contato";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Contato> c = new ArrayList<>();
            while (rs.next()) {
                c.add(new Contato(
                        rs.getInt("id"),
                        rs.getString("Telefone"),
                        rs.getInt("Pessoa_id")));
            }
            rs.next();
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Contato c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE contato SET "
                    + "`Telefone`='" + c.getTelefone()
                    + "' WHERE `id`= "
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Metodo DELETE esta OK, testado e funcionando    
    public static void delete(Contato c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM contato WHERE `id`="
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
