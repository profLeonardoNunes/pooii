
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class Aluno {

    private int id;
    private String nome;
    private Double media;
    private Double renda;
    private Double frequencia;

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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public void Gravar() {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "insert into alunos (nome, media, renda, frequencia) "
                    + "values (?, ?, ?, ?)";

            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, this.nome);
            ps.setDouble(2, this.media);
            ps.setDouble(3, this.renda);
            ps.setDouble(4, this.frequencia);
            ps.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Aluno> Consultar(String busca) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Connection conexao = new Banco().getConexao();
        String comando = "select * from alunos where nome like '%" + busca + "%'";

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setFrequencia(rs.getDouble("frequencia"));
                a.setMedia(rs.getDouble("media"));
                a.setRenda(rs.getDouble("renda"));
                alunos.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }

    public void Editar(int id) {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "update alunos set "
                    + "nome = ?, "
                    + "media = ?, "
                    + "renda = ?, "
                    + "frequencia = ? "
                    + "where id = ?";

            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, this.nome);
            ps.setDouble(2, this.media);
            ps.setDouble(3, this.renda);
            ps.setDouble(4, this.frequencia);
            ps.setDouble(5, id);
            ps.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void Deletar(int id) {
        try {
            Connection conexao = new Banco().getConexao();
            String comando = "delete from alunos where id = ?";

            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setInt(1, id);            
            ps.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
