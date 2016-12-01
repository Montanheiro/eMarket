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
    
    public static int create(Contato c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            //INSERT INTO `emark`.`contatos` (`id`, `Nome`) VALUES ('1', 'Secretario');

            String sql
                    = "INSERT INTO `emark`.`contatos` (`Nome`) VALUES ('"
                    + c.getTelefone() + "')";
            
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
    
    public static Contato retreave(int id) {
        
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //SELECT * FROM emark.cargo where id =1;
            String sql = "SELECT * FROM emark.contatos where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
            return new Contato(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("pessoaId"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static Contato retreaveByPessoa(int pessoaId) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.contatos where Pessoa_id =" + pessoaId;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                
                return new Contato(
                        rs.getInt("id"),
                        rs.getString("telefone"),
                        rs.getInt("pessoa_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Contato> retreaveAll() {
        
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.contatos";
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList<Contato> c = new ArrayList<>();
            
            while (rs.next()) {
                c.add(new Contato(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("Pessoa_id")));
            }
            
            rs.next();
            return c;
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static void delete(Contato c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //DELETE FROM `emark`.`contatos` WHERE `id`='4';
            String sql = "DELETE FROM `emark`.`contatos` WHERE `id`="
                    + c.getId();
            
            stm.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(Contato c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //UPDATE `emark`.`contatos` SET `Nome`='Atendente' WHERE `id`='4';
            String sql = "UPDATE `emark`.`contatos` SET "
                    + "`Nome`='" + c.getTelefone()
                    + "' WHERE `id`= "
                    + c.getId();
            
            stm.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
