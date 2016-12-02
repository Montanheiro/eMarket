package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;

/**
 *
 * @author Bárbara
 */
public class EnderecoDAO {
    
    //Metodo CREATE esta OK, testado e funcionando
    public static int create(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO endereco (`Logradouro`, `Bairro`, `Cidade`, `Estado`, `Pais`, `Cep`, `Pessoa_id`) VALUES ('"
                    + e.getLogradouro() + "','"
                    + e.getBairro() + "','"
                    + e.getCidade() + "','"
                    + e.getEstado() + "','"
                    + e.getPais() + "','"
                    + e.getCep() + "','"         
                    + e.getPessoaId() + "')";
            System.out.println(sql);
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            e.setId(key);

            return key;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Endereco retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM endereco WHERE id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            return new Endereco(
                    rs.getInt("id"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("pais"),
                    rs.getString("cep"),
                    rs.getInt("pessoa_id"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static Endereco retreaveByPessoa(int pessoaId) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM endereco WHERE Pessoa_id = " + pessoaId;
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {

                return new Endereco(
                        rs.getInt("id"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("cep"),
                        rs.getInt("pessoa_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Metodo RETREAVE esta OK, testado e funcionando
    public static ArrayList<Endereco> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM endereco;";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Endereco> e = new ArrayList<>();

            while (rs.next()) {
                e.add(new Endereco(
                        rs.getInt("id"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("cep"),
                        rs.getInt("pessoa_id")));
            }

            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //Metodo UPDATE esta OK, testado e funcionando
    public static void update(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE endereco SET "
                    + "`Logradouro`='" + e.getLogradouro()
                    + "', `Bairro`='" + e.getBairro()
                    + "', `Cidade`='" + e.getCidade()
                    + "', `Estado`='" + e.getEstado()
                    + "', `Pais`='" + e.getPais()
                    + "', `Cep`='" + e.getCep()
                    + "' WHERE `id`="
                    + e.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo DELETE esta OK, testado e funcionando
    public static void delete(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM endereco WHERE `id`="
                    + e.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
