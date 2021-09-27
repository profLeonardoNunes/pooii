
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   public Connection getConexao() {
        try {
            Connection conexao = null;

            String url = "jdbc:mariadb://localhost:3306/nutricao";
            String usuario = "root";
            String senha = "root";

            conexao = DriverManager.getConnection(url, usuario, senha);
            if(conexao != null)
            {
                System.out.println("Conexão realizada com sucesso");
            }
            return conexao;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex);
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
}
