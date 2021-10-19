
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Contato {
    private int id;
    private String nome;
    private String tel;
    private String cel;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void Gravar(){
        Connection conexao = new Banco().getConexao();
        String comando = "insert into contatos (nome, tel, cel, endereco) values (?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, this.nome);
            ps.setString(2, this.tel);
            ps.setString(3, this.cel);
            ps.setString(4, this.endereco);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Contato armazenado com sucesso.");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Contato> Consultar(String busca){
        ArrayList<Contato> contatos = new ArrayList<>();
        Connection conexao = new Banco().getConexao();
        String comando = "select * from contatos where nome like '%"+busca+"%'"
                + " or tel = '%"+busca+"%'"
                + " or cel = '%"+busca+"%'";
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);            
            while(rs.next()){
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTel(rs.getString("tel"));
                c.setCel(rs.getString("cel"));
                c.setEndereco(rs.getString("endereco"));
                contatos.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return contatos;
    }    
    public void Alterar(){
        Connection conexao = new Banco().getConexao();
        String comando = "update contatos set nome = ?, tel = ?, cel = ?, endereco = ? where id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, this.nome);
            ps.setString(2, this.tel);
            ps.setString(3, this.cel);
            ps.setString(4, this.endereco);
            ps.setInt(5, this.id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso.");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Deletar(int id){
        Connection conexao = new Banco().getConexao();
        String comando = "delete from contatos where id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);            
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Contato deletado com sucesso.");
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public Contato Consultar(int id){
        ArrayList<Contato> contatos = new ArrayList<>();
        Connection conexao = new Banco().getConexao();
        String comando = "select * from contatos where id = "+id;
        Statement stmt;
        Contato c = new Contato();
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);            
            while(rs.next()){                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTel(rs.getString("tel"));
                c.setCel(rs.getString("cel"));
                c.setEndereco(rs.getString("endereco"));                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        return c;
    }    
    
}
