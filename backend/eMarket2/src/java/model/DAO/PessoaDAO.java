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

    public static int create(Pessoa p) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            //INSERT INTO `emark`.`pessoa` (`id`, `CPF/CPNJ`, `Nome`) VALUES ('?', '?', '?');

            String sql
                    = "INSERT INTO `emark`.`pessoa` (`CPF/CPNJ`, `Nome`) VALUES ('"
                    + p.getCpf_cnpj() + "','"
                    + p.getNome() + "')";

            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            p.setId(key);

            ContatoDAO.create(p.getContato());
            //EnderecoDAO.create(p.getEndereco());

            return key;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static Pessoa retreave(int id) {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //SELECT * FROM emark.cargo where id =1;
            String sql = "SELECT * FROM emark.pessoa where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            Endereco e = EnderecoDAO.retreaveByPessoa(id);
            Contato c = ContatoDAO.retreaveByPessoa(id);

            return new Pessoa(id,
                    rs.getString("cpf_cnpj"),
                    rs.getString("nome"),
                    c, e);

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ArrayList<Pessoa> retreaveAll() {

        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM emark.pessoa";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Pessoa> p = new ArrayList<>();

            while (rs.next()) {
                Endereco e = EnderecoDAO.retreaveByPessoa(rs.getInt("id"));
                Contato c = ContatoDAO.retreaveByPessoa(rs.getInt("id"));
                p.add(new Pessoa(
                        rs.getInt("id"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("nome"),
                        c, e));
            }

            rs.next();
            return p;

        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void delete(Pessoa p) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //DELETE FROM `emark`.`pessoa` WHERE `id`='4';
            String sql = "DELETE FROM `emark`.`pessoa` WHERE `id`="
                    + p.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Pessoa c) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();

            //UPDATE `emark`.`pessoa` SET `Nome`='Atendente' WHERE `id`='4';
            String sql = "UPDATE `emark`.`pessoa` SET "
                    + "`CPF/CNPJ`= '" + c.getCpf_cnpj()
                    + "', `Nome`= '" + c.getNome()
                    + "' WHERE `id`= "
                    + c.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
