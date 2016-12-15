
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;
import model.Cliente;
import model.Contato;
import model.DAO.CargoDAO;
import model.DAO.ContatoDAO;
import model.DAO.EmpresaDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.PessoaDAO;
import model.Email;
import model.Empresa;
import model.Endereco;
import model.Fornecedor;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author Barbara
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
 
/************Teste do Metodo CREATE do EnderecoDAO************
        Endereco e = new Endereco("Rua das bolinhas", "Bairro Feliz", "Mhos", "GO", "BR", "75650000");
        EnderecoDAO.create(e);
*/ 

/************Teste dos Metodos RETREAVE do EnderecoDAO************
 * 
 * 
/System.out.println(EnderecoDAO.retreave(1));
//System.out.println(EnderecoDAO.retreaveByPessoa(1));
        
        ArrayList<Endereco> teste = EnderecoDAO.retreaveAll();
        for (Endereco e : teste) {
            System.out.println(e);
        }

 * 
 * 
*/
        
/************Teste do Metodo UPDATE do EnderecoDAO************
 * 
 * 
        Endereco e = EnderecoDAO.retreave(2);
        e.setLogradouro("Rua das Pitangas");
        e.setBairro("Noroeste");
        EnderecoDAO.update(e);
 * 
 * 
*/

/************Teste do Metodo DELETE do EnderecoDAO************
 * 
 * 
        Endereco e = EnderecoDAO.retreave(2);
        EnderecoDAO.delete(e);        
 * 
 * 
*/


/*************************************************************************************************/
/************Teste do Metodo CREATE do ContatoDAO************
        Contato c = new Contato("99999999");
        ContatoDAO.create(c);
*/ 

/************Teste dos Metodos RETREAVE do ContatoDAO************
 * 
 * 
System.out.println(ContatoDAO.retreave(1));
System.out.println(ContatoDAO.retreaveByPessoa(1));
        

        ArrayList<Contato> teste = ContatoDAO.retreaveAll();
        for (Contato c : teste) {
            System.out.println(c);
        }

 * 
 * 
*/

/************Teste do Metodo UPDATE do ContatoDAO************
 * 
 * 
        Contato c = ContatoDAO.retreave(2);
        c.setTelefone("88888888");
        ContatoDAO.update(c);
 * 
 * 
*/

/************Teste do Metodo DELETE do ContatoDAO************
 * 
 * 
        Contato c = ContatoDAO.retreave(2);
        ContatoDAO.delete(c);        
 * 
 * 
*/


/*************************************************************************************************/
/************Teste do Metodo CREATE de PessoaDAO************
        Pessoa p = new Pessoa("987654", "Antonio");
        Contato con = new Contato("9999-9999");
        p.setContato(con);
        Endereco en = new Endereco("Rua das Flores", "Bairro Alegre", "Mhos", "GO", "BR", "75650000");
        p.setEndereco(en);

        PessoaDAO.create(p);
        System.out.println(p.getId());
*/ 

/************Teste dos Metodos RETREAVE de PessoaDAO************
 * 
 * 
System.out.println(PessoaDAO.retreave(1));
        

        ArrayList<Pessoa> teste = PessoaDAO.retreaveAll();
        for (Pessoa p : teste) {
            System.out.println(p);
        }

 * 
 * 
*/

/************Teste do Metodo UPDATE de PessoaDAO************
 * 
 * 
        Pessoa p = PessoaDAO.retreave(3);
        p.setNome("Joaquim");
        PessoaDAO.update(p);
 * 
 * 
*/

/************Teste do Metodo DELETE de PessoaDAO************
 * 
 * 
        Pessoa p = PessoaDAO.retreave(3);
        PessoaDAO.delete(p);        
 * 
 * 
*/
        
 

/*************************************************************************************************/
/************Teste do Metodo CREATE de FuncionarioDAO************
        Funcionario f = new Funcionario(1, 1000, 10, "10/01/10", "10/01/16", 1, 1);
        FuncionarioDAO.create(f);
*/ 

/************Teste dos Metodos RETREAVE de FuncionarioDAO************
 * 
 * 
System.out.println(ContatoDAO.retreave(1));
System.out.println(ContatoDAO.retreaveByPessoa(1));
        

        ArrayList<Contato> teste = ContatoDAO.retreaveAll();
        for (Contato c : teste) {
            System.out.println(c);
        }

 * 
 * 
*/

/************Teste do Metodo UPDATE do ContatoDAO************
 * 
 * 
        Contato c = ContatoDAO.retreave(2);
        c.setTelefone("88888888");
        ContatoDAO.update(c);
 * 
 * 
*/

/************Teste do Metodo DELETE do ContatoDAO************
 * 
 * 
        Contato c = ContatoDAO.retreave(2);
        ContatoDAO.delete(c);        
 * 
 * 
*/

    //Cliente c = new Cliente(new Date(10-01-12), 10012, 100, new Pessoa(""));

//        Funcionario f = new Funcionario(
//                2000, 5, "10-01-12", "15-10-16", 1, 
//                new Pessoa("9876543210", "Lucas Cagao", 
//                        new Endereco("Rua das Flores", "Centro", "Mhos", "GO", "BR", "75650000"),
//                        new ArrayList<Contato>[("9999999")],
//                                new ArrayList<Email>("barbara@mail.com");
//        FuncionarioDAO.create(f);
//



       

//Cliente c = new Cliente("Batista", "6633613");
// c.setEndereco(e);
        
//        Cargo c = new Cargo("Gerente");
//        CargoDAO.create(c);
//        System.out.println(c.getId());

        
        
//// /*     
//        Fornecedor f = new Fornecedor("Comercio de Bugingangas", "8888888");
//        Fornecedor_Endereco fe = new Fornecedor_Endereco("Rua das Flores", "Bairro Alegre", "Mhos", "GO", "BR", "75650000");
//        f.setEndereco(fe);
//        
//        FornecedorDAO.create(f);
//
//        System.out.println(f.getPk_fornecedor());
////         */
 /*
        Funcionario func = new Funcionario("Getulio da Silva", "8888888", 1);
        Funcionario_Endereco fe = new Funcionario_Endereco("Rua das Abelhas", "Bairro das Flores", "Gtba", "GO", "BR", "75650000");
        func.setEndereco(fe);
        
        FuncionarioDAO.create(func);

        System.out.println(func.getPk_funcionario());
   
         */
 /*        Produto p = new Produto("Balinha", 20, 25);
        ProdutoDAO.create(p);
        System.out.println(p.getPk_produto());
         */
        //System.out.println(EnderecoDAO.retreave(5));
        //System.out.println(EnderecoDAO.retreaveByCliente(7));
        /*        ArrayList<Endereco> teste = EnderecoDAO.retreaveAll();
        for (Endereco e : teste) {
            System.out.println(e);
        }
         */

 /*
        ArrayList<Cliente> cli = ClienteDAO.retreaveAll();
        for (Cliente c : cli) {
            System.out.println(c);
        }
         */
   // System.out.println(CargoDAO.retreave(1));

    /*
        ArrayList<Cargo> carg = CargoDAO.retreaveAll();
        for (Cargo c : carg) {
            System.out.println(c);
        }
     */
        
        
//System.out.println(Fornecedor_EnderecoDAO.retreave(3));
//System.out.println(Fornecedor_EnderecoDAO.retreaveByFornecedor(3));
        /*        ArrayList<Fornecedor_Endereco> teste = Fornecedor_EnderecoDAO.retreaveAll();
        for (Fornecedor_Endereco e : teste) {
            System.out.println(e);
        }
         */
 /*
        ArrayList<Funcionario> cli = FuncionarioDAO.retreaveAll();
        for (Funcionario c : cli) {
            System.out.println(c);
        }
         */
//System.out.println(Funcionario_EnderecoDAO.retreave(1));
//System.out.println(Funcionario_EnderecoDAO.retreaveByFuncionario(7));
/*        ArrayList<Funcionario_Endereco> teste = Funcionario_EnderecoDAO.retreaveAll();
        for (Funcionario_Endereco e : teste) {
            System.out.println(e);
        }
        
         */
//System.out.println(ProdutoDAO.retreave(5));

        /*        ArrayList<Produto> pro = ProdutoDAO.retreaveAll();
        for (Produto c : pro) {
            System.out.println(c);
        }
         */
 /*        ArrayList<Cliente> clientessssss =ClienteDAO.retreaveAll();
        for (Cliente c:clientessssss){
            System.out.println(c);
        }
         */
 
 
//Endereco e = EnderecoDAO.retreave(5);
//EnderecoDAO.delete(e);

/*      
        Endereco e = EnderecoDAO.retreave(5);
        e.setLogradouro("Rua das Pitangas");
        e.setBairro("Bairro dos Chuchus");
        EnderecoDAO.update(e);
*/


//    Cargo e = CargoDAO.retreave(5);
//    CargoDAO.delete(e);

/*      
        Cargo e = CargoDAO.retreave(5);
        e.setNome("Gerente");
        CargoDAO.update(e);
*/

//Produto e = ProdutoDAO.retreave(7);
//ProdutoDAO.delete(e);

/*      
        Produto e = ProdutoDAO.retreave(6);
        e.setQtd_estoque(15);
        e.setEstoque_min(10);
        ProdutoDAO.update(e);
*/


//Cliente c = ClienteDAO.retreave(7);
//ClienteDAO.delete(c);

/*      
        Cliente c = ClienteDAO.retreave(6);
        c.setNome("Mara Maravilha");
        c.setCpf("111111");
        ClienteDAO.update(c);
*/


//Fornecedor c = FornecedorDAO.retreave(5);
//FornecedorDAO.delete(c);

/*        Fornecedor c = FornecedorDAO.retreave(3);
        c.setNome("Loja da Sucata");
        c.setCpf("111111");
        FornecedorDAO.update(c);

*/

 
   // new TelaControleClientes().setVisible(true);

   /*
   Empresa e = new Empresa("eMatket", "Projeto_IFGOIANO", "01.002.003/0004-05","2016-12-07",null,1);       
        EmpresaDAO.create(e);

        System.out.println(e);
*/
    }
}
