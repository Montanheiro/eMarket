package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bárbara
 */
public class BancoDados {

    private static Connection conn;
    
    private BancoDados(){
        
    }
    
    public static Connection createConnection() {
        if (conn != null){
            return conn;
        }
        
        try {
            Class.forName(BDConfig.DRIVER);
            conn = DriverManager.getConnection(
                        BDConfig.URL,
                        BDConfig.USR, 
                        BDConfig.PWD);           
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    
    
}
