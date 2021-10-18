
import java.sql.Connection;
import java.sql.*;
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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexao = null;
        Banco b = new Banco();
        conexao = b.getConexao();
        
        try {
            String comando = "insert into pessoas (nome,idade,peso,altura) values(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(comando);
            
            ps.setString(1, "Beltrano");
            ps.setInt(2, 50);
            ps.setDouble(3, 90);
            ps.setDouble(4, 1.90);
            ps.execute();
            System.out.println("Dados armazenados com sucesso!");
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
