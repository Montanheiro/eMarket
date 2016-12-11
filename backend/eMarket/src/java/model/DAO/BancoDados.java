package model.DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Bárbara
// */
//public class BancoDados {
//
//    private static Connection conn;
//    
//    private BancoDados(){
//        
//    }
//    
//    public static Connection createConnection() {
//        if (conn != null){
//            return conn;
//        }
//        
//        try {
//            Class.forName(BDConfig.DRIVER);
//            conn = DriverManager.getConnection(
//                        BDConfig.URL,
//                        BDConfig.USR, 
//                        BDConfig.PWD);           
//            return conn;
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return null;
//        
//    }
//    
//    
//    
//}

//TUTORIAL: http://www.devmedia.com.br/criando-uma-conexao-java-mysql-server/16753

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
 
//Início da classe de conexão//
public class BancoDados { 
    
    public static String status = "Não conectou...";
 
    //Método Construtor da Classe//
        public BancoDados() {
    }
 
    //Método de Conexão//
    public static java.sql.Connection createConnection() {
        Connection connection;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);

            connection = DriverManager.getConnection(BDConfig.URL, BDConfig.USR, BDConfig.PWD);

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } 
            else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
 
    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

   //Método que fecha sua conexão//
    public static boolean FecharConexao() {
 
        try {
            BancoDados.createConnection().close(); 
            return true;
 
        } catch (SQLException e) {
            return false;
        }
    }
  
    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return BancoDados.createConnection();
    }
}