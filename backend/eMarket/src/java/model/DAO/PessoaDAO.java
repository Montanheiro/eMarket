package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Contato;
import model.Email;
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
    public static int create(Pessoa p) throws SQLException {
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
       
        EnderecoDAO.create(p.getEndereco());
        
        for (Contato c : p.getContato()) {
            c.setPessoaId(key);
            ContatoDAO.create(c);
        }

        for (Email em : p.getEmail()) {
            em.setPessoaId(key);
            EmailDAO.create(em);
        }

        return key;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Pessoa retreave(int id) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Endereco e = EnderecoDAO.retreaveByPessoa(id);
        ArrayList<Contato> todosOscontatos = ContatoDAO.retreaveByPessoa(id);
        ArrayList<Email> todosOsEmails = EmailDAO.retreaveByPessoa(id);
        return new Pessoa(id,
                rs.getString("cpf_cnpj"),
                rs.getString("Nome"),
                e, todosOscontatos, todosOsEmails);
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Pessoa> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "SELECT * FROM pessoa";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Pessoa> p = new ArrayList<>();
        ArrayList<Contato> todosOscontatos;
        ArrayList<Email> todosOsEmails;
        while (rs.next()) {
            todosOscontatos = ContatoDAO.retreaveByPessoa(rs.getInt("id"));
            Endereco e = EnderecoDAO.retreaveByPessoa(rs.getInt("id"));
            todosOsEmails = EmailDAO.retreaveByPessoa(rs.getInt("id"));
            p.add(new Pessoa(
                    rs.getInt("id"),
                    rs.getString("cpf_cnpj"),
                    rs.getString("Nome"),
                    e, todosOscontatos, todosOsEmails));
        }
        rs.next();
        return p;
    }
    
    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Pessoa c) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "UPDATE pessoa SET "
                + "`cpf_cnpj`= '" + c.getCpf_cnpj()
                + "', `Nome`= '" + c.getNome()
                + "' WHERE `id`= "
                + c.getId();
        stm.execute(sql);

        EnderecoDAO.update(c.getEndereco());

        for (Contato cs : c.getContato()) {
            if (cs.getId() != 0) {
                ContatoDAO.update(cs);
            } else {
                cs.setPessoaId(c.getId());
                ContatoDAO.create(cs);
            }
        }

        for (Email em : c.getEmail()) {
            if (em.getId() != 0) {
                EmailDAO.update(em);
            } else {
                em.setPessoaId(c.getId());
                EmailDAO.create(em);
            }
        }

    }

    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Pessoa p) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                        createStatement();
        String sql = "DELETE FROM pessoa WHERE `id`="
                + p.getId();
        stm.execute(sql);
    }

}
