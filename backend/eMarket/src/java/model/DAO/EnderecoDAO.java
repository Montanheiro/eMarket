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

    public static int create(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            //INSERT INTO clientes_enderecos(
            //pk_enderenco, fk_cliente, logradouro, bairro, cidade, estado, 
            //pais, cep)VALUES (?, ?, ?, ?, ?, ?, ?, ?);

            String sql
                    = "insert into clientes_enderecos (fk_cliente, logradouro, bairro, cidade, estado, pais, cep) values ("
                    + e.getessoaId() + ",'"
                    + e.getLogradouro() + "','"
                    + e.getBairro() + "','"
                    + e.getCidade() + "','"
                    + e.getEstado() + "','"
                    + e.getPais() + "','"
                    + e.getCep() + "')";
            System.out.println(sql);
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            e.setId(key);

            return key;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static Endereco retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "Select * from clientes_enderecos where pk_endereco =" + id;
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

    public static Endereco retreaveByPessoa(int pessoaId) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "Select * from enderecos where fk_cliente =" + pessoaId;
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

    public static ArrayList<Endereco> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "Select * from clientes_enderecos";
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
                        rs.getInt("fk_cliente")));
            }

            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void delete(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "delete from "
                    + "clientes_enderecos"
                    + " where pk_endereco ="
                    + e.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Endereco e) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "update clientes_enderecos set "
                    + "logradouro = '" + e.getLogradouro()
                    + "', bairro = '" + e.getBairro()
                    + "', cidade = '" + e.getCidade()
                    + "', estado = '" + e.getEstado()
                    + "', pais = '" + e.getPais()
                    + "', cep = '" + e.getCep()
                    + "' Where pk_endereco = "
                    + e.getId();

            stm.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
