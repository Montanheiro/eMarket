package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author Bárbara
 */
public class FuncionarioDAO {
    
    
    private FuncionarioDAO() {
    }

    
    public static int create(Funcionario f) {

        try {
            
            PessoaDAO.create(f.getPessoa());
            //CargoDAO.retreave(f.getCargo().getId());
            
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql
                    = "INSERT INTO funcionario (`Salario`, `Comissao`, `DataAdmissao`, `DataDemissao`, `Cargo_id`, `Pessoa_id`) VALUES ('"
                    + f.getSalario() + "','"
                    + f.getComissao() + "','"
                    + f.getDataAdimissao() + "','"
                    + f.getDataDemissao() + "','"
                    + f.getCargoId() + "','"
                    + f.getPessoa().getId() + "')";
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            f.setId(key);
            return key;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static Funcionario retreave(int id) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM funcionario where id =" + id;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return new Funcionario(id,
                    rs.getDouble("Salario"),
                    rs.getInt("Comissao"),
                    rs.getDate("DataAdmissao"),
                    rs.getDate("DataDemissao"),
                    rs.getInt("Cargo_id"),
                    rs.getInt("Pessoa_id"));
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Funcionario> retreaveAll() {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "SELECT * FROM pessoa";
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Funcionario> p = new ArrayList<>();
            while (rs.next()) {
                p.add(new Funcionario(
                        rs.getInt("id"),
                        rs.getDouble("Salario"),
                        rs.getInt("Comissao"),
                        rs.getDate("DataAdmissao"),
                        rs.getDate("DataDemissao"),
                        rs.getInt("Cargo_id"),
                        rs.getInt("Pessoa_id")));
            }
            rs.next();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    public static void update(Funcionario f) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "UPDATE funcionario SET "
                    + "`Salario`= '" + f.getSalario()
                    + "', `Comissao`= '" + f.getComissao()
                    + "', `DataAdmissao`= '" + f.getDataAdimissao()
                    + "', `DataDemissao`= '" + f.getDataDemissao()
                    + "' WHERE `id`= "
                    + f.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void delete(Funcionario f) {
        try {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM funcionario WHERE `id`="
                    + f.getId();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
