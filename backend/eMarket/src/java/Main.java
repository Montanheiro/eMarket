
import java.util.ArrayList;
import model.Cargo;
import model.DAO.CargoDAO;
import model.DAO.EnderecoDAO;
import model.Endereco;

/**
 *
 * @author Barbara
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
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


        

       

//Cliente c = new Cliente("Batista", "6633613");
// c.setEndereco(e);
        
//        Cargo c = new Cargo("Gerente");
//        CargoDAO.create(c);
//        System.out.println(c.getId());

        
        
 /*     Fornecedor f = new Fornecedor("Comercio de Bugingangas", "8888888");
        Fornecedor_Endereco fe = new Fornecedor_Endereco("Rua das Flores", "Bairro Alegre", "Mhos", "GO", "BR", "75650000");
        f.setEndereco(fe);
        
        FornecedorDAO.create(f);

        System.out.println(f.getPk_fornecedor());
         */
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


    }
}
