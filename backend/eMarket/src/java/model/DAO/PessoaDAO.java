package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;
import model.Endereco;
import model.Pessoa;

/**
 *
 * @author Bárbara
 */
public class PessoaDAO {

    private PessoaDAO() {
    }

    //Metodo CREATE esta OK, testado e funcionando
    public static int create(Pessoa p) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO pessoa (`cpf_cnpj`, `Nome`) VALUES ('"
                    + p.getCpf_cnpj() + "','"
                    + p.getNome() + "')";
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            p.setId(key);
            ContatoDAO.create(p.getContato());
            EnderecoDAO.create(p.getEndereco());
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Pessoa retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM pessoa where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            Endereco e = EnderecoDAO.retreaveByPessoa(id);
            Contato c = ContatoDAO.retreaveByPessoa(id);
            return new Pessoa(id,
                    rs.getString("cpf_cnpj"),
                    rs.getString("Nome"),
                    c, e);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Pessoa> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM pessoa";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Pessoa> p = new ArrayList<>();
            while (rs.next()) {
                Contato c = ContatoDAO.retreaveByPessoa(rs.getInt("id"));
                Endereco e = EnderecoDAO.retreaveByPessoa(rs.getInt("id"));
                p.add(new Pessoa(
                        rs.getInt("id"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("Nome"),
                        c, e));
            }
            rs.next();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Pessoa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE pessoa SET "
                    + "`cpf_cnpj`= '" + c.getCpf_cnpj()
                    + "', `Nome`= '" + c.getNome()
                    + "' WHERE `id`= "
                    + c.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Pessoa p) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM pessoa WHERE `id`="
                    + p.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
