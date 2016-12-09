package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author Bárbara
 */
public class FuncionarioDAO {
    
    
    private FuncionarioDAO() {
    }

    
    public static int create(Funcionario f) throws SQLException {
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
                    + f.getCargo().getId() + "','"
                    + f.getPessoa().getId() + "')";
            stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            f.setId(key);
            return key;
    }

    public static Funcionario retreave(int id) throws SQLException {
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
    }

    public static ArrayList<Funcionario> retreaveAll() throws SQLException {
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
    }

   
    public static void update(Funcionario f) throws SQLException {
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
    }
    
    
    public static void delete(Funcionario f) throws SQLException {
            Statement stm
                    = BancoDados.createConnection().
                            createStatement();
            String sql = "DELETE FROM funcionario WHERE `id`="
                    + f.getId();
            stm.execute(sql);
    }

}
