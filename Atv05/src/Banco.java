
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class Banco {
    public Connection getConexao(){
    
        try{
            Connection conexao = null;
            String url = "jdbc:mariadb://localhost:3306/atv06";
            String usuario = "root";
            String senha = "root";
            
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            if(conexao != null)
            {
                System.out.println("Conectado com sucesso!");
            }
            
            return conexao;
        }
        catch(SQLException ex)
        {
            System.out.println("Erro na conexão com o banco dados" + ex);
            return null;
        }        
        catch(Exception ex)
        {
            System.out.println("Erro na conexão com o banco dados" + ex);
            return null;
        }
    }
}
