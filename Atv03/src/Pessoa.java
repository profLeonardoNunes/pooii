
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String tppessoa;
    private Double rendaAnual;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTppessoa() {
        return tppessoa;
    }

    public void setTppessoa(String tppessoa) {
        this.tppessoa = tppessoa;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
    
    public ArrayList<Pessoa> getPessoas(String busca){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        
        Connection conexao = new Banco().getConexao();
        String comando = "SELECT * FROM pessoas WHERE nome LIKE '%"+busca+"%'";
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            
            while(rs.next())
            {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setCnpj(rs.getString("cnpj"));
                p.setTppessoa(rs.getString("tppessoa"));
                p.setRendaAnual(rs.getDouble("rendaAnual"));
                pessoas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pessoas;
        
    }

}
